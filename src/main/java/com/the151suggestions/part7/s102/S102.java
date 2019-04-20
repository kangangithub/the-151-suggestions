package com.the151suggestions.part7.s102;

import java.lang.reflect.Method;

/**
 * 建议102:适时选择getDeclaredXxx和getXxx
 *  getDeclaredXxx():获得自身类(不包括父类,内部类)的所有方法(包括共有,私有方法,不受限于访问权限)
 *  getXxx():获得所有public方法,包括自身类,从父类继承的方法
 *
 * Created by Akang on 2017/8/22.
 */
public class S102 {
    public static void main(String[] args) throws NoSuchMethodException {
        String methodName = "doStuff";
        Method method1 = Foo.class.getDeclaredMethod(methodName);
        Method method2 = Foo.class.getMethod(methodName);   //报错,NoSuchMethodException
    }

    static class Foo {
        void doStuff() {
        }
    }
}
