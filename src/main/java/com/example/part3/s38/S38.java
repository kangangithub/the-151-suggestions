package com.example.part3.s38;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 建议38:使用静态内部类提高封装性
 * 静态内部类与普通内部类区别:
 *  1.静态内部类不持有外部类的引用
 *  2.静态内部类不依赖外部类
 *      普通内部类与外部类是相互依赖的不能脱离外部类的实例,同生同死
 *      静态内部类可独立存在,即使外部类消亡,也可存在
 *  3.普通内部类不能声明static方法/变量,可以声明常量(final修饰)
 * 注:
 *  static修饰类时只能修饰静态内部类
 * Created by ankang on 2017-08-04.
 */
public class S38 {
    public static void main(String[] args) {
        Person person = new Person("张三");
        person.setHome(new Person.Home("北京", "010-31254852"));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
    private Home home;

    public Person(String name) {
        this.name = name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    /**
     * 静态内部类Home
     */
    public static class Home {
        private String address;
        private String telPhone;
    }

}