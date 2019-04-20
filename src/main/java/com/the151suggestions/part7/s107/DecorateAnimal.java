package com.the151suggestions.part7.s107;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * 包装动作类,增加各种能力
 * Created by Akang on 2017/8/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecorateAnimal implements Animal {
    /**
     * 持有代理接口对象
     */
    private Animal animal;

    /**
     * 具体的包装器
     */
    private Class<? extends Feature> clazz;

    public void doStuff() {
        /**
         * 创建额外功能
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = null;
                if (Modifier.isPublic(method.getModifiers())) {
                    o = method.invoke(clazz.newInstance(), args);
                }
                animal.doStuff();
                return o;
            }
        };

        ClassLoader classLoader = Rat.class.getClassLoader();

        Feature feature = (Feature) Proxy.newProxyInstance(classLoader, clazz.getInterfaces(), invocationHandler);

        feature.load();
    }
}
