package com.the151suggestions.part3.s32;

/**
 * 建议32: 静态变量一定要先声明后赋值
 * Created by ankang on 2017-03-28.
 */
public class S32 {
    public static void main(String[] args) {
        A.method();
        B.method();
    }
}

/**
 * 静态变量是类加载时分配到数据区的,它在内存中只有一个拷贝,不会被分配多次,其后所有的赋值操作都是值改变.地址保持不变.
 * JVM初始化变量是先声明空间,后赋值. int i = 100  ===> int i;  i=100;
 * 静态变量是在类初始化时首先被加载的,JVM会去查找类中所有的静态声明,然后分配空间,注意这时候只是完成了地址空间的分配,还没有赋值,
 * 之后JVM会根据类中静态赋值(包括静态类/块赋值)的书写先后顺序来执行.
 * 变量一定要先声明后使用.
 */

class A {
    public static int i = 1;

    static {
        i = 100;
    }

    public static void method() {
        System.out.println(i);  //  100
    }
}

class B {
    static {
        i = 100;
    }

    public static int i = 1;

    public static void method() {
        System.out.println(i);  //  1
    }
}
