package com.the151suggestions.part7.s94;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankang on 2017-08-17.
 */
public class A<T> {
    //private T t = new T();    编译报错,编译时需要获取T类型,但编译期泛型被擦除
    //private T[] ts = new T[5];    编译报错,编译时需要获取T类型,但编译期泛型被擦除
    //private List<T> list = new ArrayList<>();     编译成功
    /**
     * ArrayList源码:
     * ArrayList表面是泛型,其实已在编译期转成Object
     * 无参构造返回Object[],有参构造类似,也返回Object[]
     * public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
     * private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     * <p>
     * transient Object[] elementData;
     * <p>
     * public ArrayList() {
     * this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     * }
     * }
     */

    private T t;
    private T[] ts;
    private List<T> list = new ArrayList<>();

    public A(String path) {
        try {
            /**
             * 表达式：Class.forName("Foo"), 等效于：
             Class.forName("Foo", true, this.getClass().getClassLoader())

             public static Class<?> forName(String name,boolean initialize,ClassLoader loader) throws ClassNotFoundException
             参数：
             name - 所需类的完全限定名
             initialize - 是否必须初始化类
             loader - 用于加载类的类加载器
             */
            Class<?> aClass = Class.forName(path, true, this.getClass().getClassLoader());
            System.out.println(aClass);
            t = (T) aClass.newInstance();
            ts = (T[]) Array.newInstance(aClass, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
