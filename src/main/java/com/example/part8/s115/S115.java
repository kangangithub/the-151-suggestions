package com.example.part8.s115;

/**
 * 建议115:使用Throwable获得栈信息
 * Created by Akang on 2017/8/25.
 */
public class S115 {
    public static void main(String[] args) {
        System.out.println(Invoker.m1());   // true
        System.out.println(Invoker.m2());   // (false)抛出异常
    }
}
