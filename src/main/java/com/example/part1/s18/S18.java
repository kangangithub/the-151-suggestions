package com.example.part1.s18;

import java.util.Date;

/**
 * 建议18: 避免instanseof非预期结果
 * Created by ankang on 2017-03-27.
 */
public class S18 {
    public static void main(String[] args) {
        //String对象是否是Object的实例
        boolean b1 = "String" instanceof Object;    //true
        //String对象是否是String的实例
        boolean b2 = "String" instanceof String;    //true
        //Object对象是否是String的实例
        boolean b3 = new Object() instanceof String;    //false
        //拆箱类型是否是装箱类型的实例
//        boolean b4 = 'A' instanceof Character;  'A'是基本类型,instanceof只能用于对象的判断,编译不通过
        //空对象是否是String的实例
        boolean b5 = null instanceof String;   //false instanceof规则:左边是null,返回false
        //类型转换后的空对象是否是String的实例
        boolean b6 = (String) null instanceof String;   //false instanceof规则:左边是null(包括强转类型),返回false
        //Date对象是否是String的实例
//        boolean b7 = new Date() instanceof String;  Date与String无继承/实现关系,编译不通过
        //在泛型类中判断String对象是否是Date的实例
        /**
         * T是String 类型,Date与String无继承/实现关系,t instanceof Date等效于 String instanceof Date
         */
        boolean b8 = new GenericClass<String>().isDateInstance(""); //false
    }
}

class GenericClass<T>{
    public boolean isDateInstance(T t) {
        return t instanceof Date;
    }
}