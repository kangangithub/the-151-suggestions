package com.the151suggestions.part7.s106;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 建议106:动态代理可以使代理模式更加灵活
 * Created by Akang on 2017/8/23.
 */
public class S106 {
    public static void main(String[] args) {
        testStaticProxy();
        testJDKDynamicProxy();
        testCglibDynamicProxy();
    }

    private static void testCglibDynamicProxy() {
        Subject subject = new RealSubject();
        /**
         * Enhancer: setSuperclass(原始类) setCallback(额外功能)
         */
        //核心类
        Enhancer enhancer = new Enhancer();
        //设置原始类
        enhancer.setSuperclass(subject.getClass());
        //获取额外功能
        net.sf.cglib.proxy.InvocationHandler invocationHandler = new CglibDynamicProxySubject();
        //设置额外功能
        enhancer.setCallback(invocationHandler);
        //返回代理对象
        Subject cglibDynamicProxy = (Subject) enhancer.create();
        cglibDynamicProxy.request();
    }

    private static void testJDKDynamicProxy() {
        Subject subject = new RealSubject();
        //获取额外功能
        InvocationHandler invocationHandler = new JDKDynamicProxySubject();
        //获取类加载器
        ClassLoader classLoader = subject.getClass().getClassLoader();
        /**
         *  Proxy.newProxyInstance(类加载器,委托类(目标接口),额外功能)
         */
        Subject jdkDynamicProxy = (Subject) Proxy.newProxyInstance(classLoader, subject.getClass().getInterfaces(), invocationHandler);
        jdkDynamicProxy.request();
    }

    public static void testStaticProxy() {
        Subject subject = new StaticProxySubject();
        subject.request();
    }
}
