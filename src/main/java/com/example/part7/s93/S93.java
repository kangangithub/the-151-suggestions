package com.example.part7.s93;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议93:Java的泛型是类型擦除的
 * 泛型:减少强制类型转换,规范集合元素类型,提高代码安全性和可读性,优先使用泛型
 * <p>
 * Created by ankang on 2017-08-16.
 */
public class S93 {

    void arrayMethod(String[] strings) {
    }

    void arrayMethod(Integer[] strings) {
    }

    /**
     * 编译不通过,Java的泛型在编译后都会被擦除
     * 擦除规则:
     * List<String>,List<Integer>,List<T> ---> List
     * List<String>[] ---> List[]
     * List<? extends E>, List<? super E> ---> List<E>
     * List<T extends Serializable & Cloneable> ---> List<Serializable>
     * <p>
     * void listMethod(List<String> stringList){} 泛型擦除后等同于
     * void listMethod(List stringList){}
     * <p>
     * Java泛型擦除原因:
     * 1.避免JVM大换血,在编译后擦除,避免了大量的重构工作
     * 2.JDK版本兼容
     *
     * @param stringList
     */
    void listMethod(List<String> stringList) {
    }
    //void listMethod(List<Integer> integerList){}

    public static void main(String[] args) {
        /**
         * 每个类都有一个class属性,泛型化不会改变class属性
         * 泛型擦除后,stringList integerList都是List
         */
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        System.out.println(stringList.getClass() == integerList.getClass()); //true

        /**
         * 泛型数组初始化时不能声明泛型类型
         * 可以声明带有泛型的数组,但不能初始化,泛型擦除后List<Object>[]和List<String>[]一样,编译器不允许
         */
        List<String>[] stringLists;
        //List<String>[] stringLists = new List<String>[];

        /**
         * instanceof不允许存在泛型参数,泛型擦除
         */
        List<String> list = new ArrayList<>();
        //System.out.println(list instanceof List<String>);
    }
}
