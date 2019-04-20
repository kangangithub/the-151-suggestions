package com.the151suggestions.part7.s106;

import lombok.*;

/**
 * 静态代理类
 * Created by Akang on 2017/8/23.
 */
@Data
public class StaticProxySubject implements Subject {
    /**
     * 持有一个代理接口对象
     */
    private Subject subject;


    public StaticProxySubject() {
        this.subject = new RealSubject();
    }

    @Override
    public void request() {
        before();
        System.out.print("StaticProxy: ");
        subject.request();
        after();
    }

    private void after() {
        System.out.println("back handle");
    }

    private void before() {
        System.out.println("before handle");
    }
}
