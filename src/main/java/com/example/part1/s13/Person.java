package com.example.part1.s13;

import java.io.Serializable;

/**
 * 建议13: 避免为final变量复杂赋值
 *          final属性是直接量(字面量),反序列化时会重新赋值.这里的值是指简单对象,
 *          即8中基本类型+数组+字符串(不通过new String对象的情况),但是不能方法赋值
 *          反序列化时final变量在以下情况下不会重新赋值:
 *          1.通过构造方法赋值
 *          2.通过方法返回值赋值
 *          3.final修饰的属性不是基本类型
 * Created by ankang on 2017-03-26.
 */
public class Person implements Serializable {
    //    显示声明UID(流标识符)
    private static final long serialVersionUID = 5579789L;

    public final String name = "混世魔王";

//    final变量避免用方法赋值
//    public final String name = initName();
//
//    private String initName() {
//        return "混世魔王";
//    }

}
