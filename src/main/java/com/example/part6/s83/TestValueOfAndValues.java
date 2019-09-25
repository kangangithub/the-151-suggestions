package com.example.part6.s83;

/**
 * 枚举方法:测试values()和valueOf()
 * Created by ankang on 2017-08-14.
 */
public class TestValueOfAndValues {
    public static void main(String[] args) {
        /**
         * values()获取枚举类中的所有的元素
         */
        for (WeekendEnum weekendEnum : WeekendEnum.values()) {
            System.out.println(weekendEnum);
        }
        /**
         * valueOf方法的作用是通过枚举元素的名称获取一个枚举类。
         * 1. 枚举中的valueOf()
         * 2. java.lang.Enum中的valueOf()
         */
        System.out.println(ColorEnum.valueOf("RED").getName());
        System.out.println(Enum.valueOf(ColorEnum.class, "RED").getName());
    }
}
