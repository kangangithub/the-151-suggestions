package com.the151suggestions.part5.s65;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 建议65:避开基本类型数组转换列表陷阱
 * Java中,8种基本类型不能泛型化,也就是说不能做泛型参数,想做泛型参数要用其对应的包装类型
 * Java中,数组是对象(基本类型数组也是对象,int[]是对象),是可泛型化的
 * Created by ankang on 2017-08-08.
 */
public class S65 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * asList方法源码:输入一个变成参数,返回一个固定长度的列表,此列表不可扩容
     * public static <T> List<T> asList(T... a) {
     *  return new ArrayList<>(a);
     * }
     * 不可扩容的原因:
     * 返回的ArrayList是Arrays的一个私有的静态内部类,该内部类没有提供add方法,
     * 其父类AbstractList中的add方法直接throw new UnsupportedOperationException();
     * 这里把int[]作为T类型的参数,转换后List中就只有一个参数类型为int[]的元素
     * 原始类型数组(8种基本类型数组)不能直接作为asList方法的实参
     */
    public static void test1() {
        int[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        System.out.println("列表中的元素数量是: " + list.size());
        System.out.println(ints.equals(list.get(0)));
    }

    private static void test2() {
        Integer[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        System.out.println("列表中的元素数量是: " + list.size());
        System.out.println(ints.equals(list.get(0)));
    }

    /**
     * JDK1.8:IDEA中需指定jdk的Language level为8,setting->Compiler->Java Compiler 设置相应Module的byte code version为1.8.
     * Java 8 允许使用 :: 关键字来传递方法或者构造函数引用.
     * int[]转化成Integer[]
     */
    private static void test3() {
        int[] ints = {1, 2, 3, 4, 5};
        Integer[] integers1 = IntStream.of(ints).boxed().toArray(Integer[]::new);
        Integer[] integers2 = Arrays.stream(ints).boxed().toArray(Integer[]::new);
//        System.out.println(integers1.equals(integers2));
        /**
         * 数组的equals比较常用Arrays.equals(one, two), one.equals(two)也可以
         */
        System.out.println(Arrays.equals(integers1, integers2));
    }

    /**
     * JDK1.8:IDEA中需指定jdk的Language level为8,setting->Compiler->Java Compiler 设置相应Module的byte code version为1.8
     * int[]转换成List<Integer>
     */
    private static void test4() {
        int[] ints = {1, 2, 3, 4, 5};
        List<Integer> list1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(ints).boxed().collect(Collectors.toList());
        System.out.println(list1.equals(list2));
    }
}
