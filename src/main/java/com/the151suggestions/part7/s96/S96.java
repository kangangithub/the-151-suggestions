package com.the151suggestions.part7.s96;

import java.util.List;

/**
 * 建议96:不同的场景使用不同的泛型通配符
 * 泛型通配符:
 *      ?            任意类
 *      extends     某类/接口的子类
 *      super       某类/接口的父类
 * Created by ankang on 2017-08-17.
 */
public class S96 {
    // 传入父类为E的list,?是E的子类
    public static <E> void read(List<? extends E> list) {
    }

    // 传入子类为E的list,?是E的父类
    public static <E> void write(List<? super E> list) {
    }

    /**
     * Collections工具类的copy(),原列表src元素类型是T的子类,新列表desc元素类型的子类是T
     * @param dest
     * @param src
     * @param <T>
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {}
}
