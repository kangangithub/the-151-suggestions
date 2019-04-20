package com.the151suggestions.part7.s97;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议97:警惕泛型是不能协变和逆变的
 * Java泛型不支持协变和逆变,但是能实现协变和逆变.
 *  Integer是Number的子类
 *  ArrayList<Integer>是List<Integer>的子类
 *  Integer[]是Number[]子类
 *  List<Integer>不是List<Number>的子类
 *  List<Integer>不是List<? extends Integer>的子类
 *  List<Integer>不是List<? super Integer>的子类
 *
 * Created by ankang on 2017-08-17.
 */
public class S97 {
    public static void main(String[] args) {
        /*泛型不支持协变*/
        Number[] numbers = new Integer[10];
        //List<Number> numberList = new ArrayList<Integer>();  编译错误

        //numberList中元素类型是Number的子类
        List<? extends Number> numberList = new ArrayList<Integer>();

        /*泛型不支持逆变*/
        //List<Integer> list = new ArrayList<Number>();   编译出错

        //list中元素类型是Integer的父类
        List<? super Integer> list = new ArrayList<Number>();
    }
}
