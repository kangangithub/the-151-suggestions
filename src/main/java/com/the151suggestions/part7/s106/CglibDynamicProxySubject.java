package com.the151suggestions.part7.s106;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * Cglib动态代理,实现InvocationHandler接口(cglib包),覆盖invoke()
 * Created by Akang on 2017/8/23.
 */
public class CglibDynamicProxySubject implements InvocationHandler{
    /**
     * 持有一个代理接口对象
     */
    private Subject subject;


    public CglibDynamicProxySubject() {
        this.subject = new RealSubject();
    }

    /**
     * 委托处理方法
     * @param o
     * @param method    目标方法对象
     * @param objects   调用目标方法需要的参数
     * @return  目标方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        before();
        /**
         * 调用Method类中的invoke()
         * public Object invoke(Object obj, Object... args)
         *  obj: 目标方法所在的类的对象
         *  args: 调用目标方法需要的参数
         *  Object: 目标方法返回值
         */
        System.out.print("CglibDynamicProxy: ");
        Object object = method.invoke(subject, objects);
        after();
        return object;
    }

    private void after() {
        System.out.println("back handle");
    }

    private void before() {
        System.out.println("before handle");
    }
}
