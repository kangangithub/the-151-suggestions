package com.example.part1.s12;

import java.io.Serializable;

/**
 * 建议12: 避免用序列化类在构造方法中为不可变量赋值
 * Created by ankang on 2017-03-26.
 */
public class Person implements Serializable {
    //    显示声明UID(流标识符)
    private static final long serialVersionUID = 5579779L;

    public final String name = "混世魔王";

//    final变量避免用构造方法赋值
//    public final String name;
//
//    public Person() {
//        name = "混世魔王";
//    }
}
