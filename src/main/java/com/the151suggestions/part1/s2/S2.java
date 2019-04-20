package com.the151suggestions.part1.s2;

import java.util.Random;

/**
 * 建议2: 莫让常量蜕变成变量
 * Created by ankang on 2017-03-26.
 */
public class S2 {
    public static void main(String[] args) {
        System.out.println("常量会变哦: " + Constant.RAND_CONST);
    }
}

//接口常量
interface Constant {
    //接口中变量是公开静态常量 public static final
    int RAND_CONST = new Random().nextInt();
}