package com.example.part7.s106;

/**
 * 委托类
 * Created by Akang on 2017/8/23.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
