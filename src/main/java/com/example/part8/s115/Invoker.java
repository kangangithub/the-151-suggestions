package com.example.part8.s115;

/**
 * 调用者
 * Created by Akang on 2017/8/25.
 */
public class Invoker {
    public static boolean m1() {
        return Foo.m();
    }

    public static boolean m2() {
        return Foo.m();
    }
}
