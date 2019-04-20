package com.the151suggestions.part7.s95;

import java.util.List;

/**
 * 建议95:强制声明泛型的实际类型
 * Created by ankang on 2017-08-17.
 */
public class S95 {
    public static void main(String[] args) {
        //实参是String,列表泛型是String
        List<String> list1 = ArrayUtils.asList("A", "B");

        //实参是null,编译器以Object为泛型类型,即List<Object> list2 = ArrayUtils.<Object>asList();
        List list2 = ArrayUtils.asList();
        //强制声明泛型类型
        List<Integer> list3 = ArrayUtils.<Integer>asList();

        //实参有Integer,Double两种类型,编译器发现多个实参类型不一致会直接以Object为泛型类型,
        //即List<Object> list4 = ArrayUtils.<Object>asList(1, 2, 3.2D);
        List list4 = ArrayUtils.asList(1, 2, 3.2D);

        //实参是Integer,Double两种类型,可以强制声明泛型类型Number(Integer,Double的父类)
        List<Number> list5 = ArrayUtils.asList(1, 2, 3.2D);
    }
}
