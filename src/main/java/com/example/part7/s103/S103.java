package com.example.part7.s103;

import com.example.part7.s99.Me;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 建议103:反射访问属性或方法时将Accessible设置为true
 * Accessible属性决定Field,Method,Constructor是否可以快速访问,为性能考虑,要setAccessible(true)
 * Created by Akang on 2017/8/22.
 */
public class S103 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        test1("建议103:反射访问属性或方法时将Accessible设置为true");
        test2();
    }

    /**
     * 通过反射执行方法:先获取方法对象,根据isAccessible()返回值判断是否能够执行,返回值为false,调用setAccessible(true),最后调用invoke()
     */
    private static void test1(String s) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Foo.class.getMethod("doSomething", s.getClass());
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        /**
         * public Object invoke(Object obj, Object... args)
         *  obj: 目标方法所在的类的对象
         *  args: 调用目标方法需要的参数
         *  Object: 目标方法返回值
         */
        String string = (String) method.invoke(new Foo(), s);
        System.out.println(string);
    }

    private static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Me.class.getMethod("isStanding");
        /**
         * Accessible属性是指是否进行安全检查
         * 动态修改一个类或方法时会受Java安全体系的制约,而安全处理非常消耗资源(性能低),因此,
         * 对于运行期要执行的方法或要修改的属性就提供了Accessible属性
         * isAccessible()是否可以快速访问
         * AccessibleObject是Field, Method,Constructor的父类,变量override决定是否可以快速访问,源码:
         * public class AccessibleObject implements AnnotatedElement {
             boolean override;  //是否可以快速访问
             public boolean isAccessible() {
                 return override;
            }
            protected AccessibleObject() {}//Constructor: only used by the Java Virtual Machine.
             }
         具体是否快速访问是在Method的invoke()决定,Method源码:
         public final class Method extends Executable {
             public Object invoke(Object obj, Object... args)
             throws IllegalAccessException, IllegalArgumentException,
             InvocationTargetException
             {
             if (!override) {
             if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
             Class<?> caller = Reflection.getCallerClass();
             checkAccess(caller, clazz, obj, modifiers);
             }
             }
             MethodAccessor ma = methodAccessor;             // read volatile
             if (ma == null) {
             ma = acquireMethodAccessor();
             }
             return ma.invoke(obj, args);
             }
         }
        */
        System.out.println("Accessible = " + method.isAccessible());
        System.out.println(method.invoke(new Me()));
    }
}
