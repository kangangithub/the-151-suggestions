package com.example.part8.s114;

import lombok.Data;

import java.io.IOException;

/**
 * 建议114:不要在构造函数中抛出异常
 * Created by Akang on 2017/8/25.
 */
public class S114 {
    public static void main(String[] args) {
        /**
         * 构造方法抛出错误:无法处理
         */

        /**
         * 构造方法抛出非受检异常:age<18,无法产生Person对象,无法调用seeMovie()
         */
        Person person = new Person(17);
        person.seeMovie();

        /**
         * 构造方法抛出受检异常:
         *  1.导致子类代码膨胀:
         *      父类无参构造抛出IOException,子类无参构造默认调用父类无参构造,
         *      子类无参构造必须抛出IOException或其父类异常
         *  2.违背里氏替换原则
         *      里氏替换原则:父类能出现的地方子类就可以出现,而且将父类替换为子类也不会产生任何异常
         *      Base base = new Sub();  编译不通过,因为Sub抛出比Base更宽泛的异常,需要增加新的catch{}
         *  3.子类构造方法扩展受限
         *      子类存在的原因是扩展父类的逻辑,比如注释掉的Sub无参构造编译不过
         */
        try {
            Base base = new Base();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Base base = new Sub();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

@Data
class Person {
    private int age;

    public Person(int age) {
        if (age < 18) {
            /**
             * 构造方法抛出非受检异常
             */
            throw new RuntimeException("年龄必须大于18岁");
        }
    }

    public void seeMovie() {
        System.out.println("看限制级电影");
    }
}

class Base {
    public Base() throws IOException {
        throw new IOException();
    }
}

class Sub extends Base {
    /**
     * 注意:子类Sub构造方法抛出比父类Base更宽泛的异常
     * Override时,子类方法不可抛出比父类方法更宽泛的异常,
     * 但构造方法没有Override的概念,只是构造方法间的调用,
     * 所以子类构造可以抛出比父类更宽泛的异常
     * @throws Exception
     */
    public Sub() throws Exception {
    }

    //public Sub() throws Exception {
    //    try {
    //        super();  //super()、super(实参)必须是子类构造方法的第1个有效语句。
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    } finally {
    //    }
    //}
}