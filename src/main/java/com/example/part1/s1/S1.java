package com.example.part1.s1;

/**
 * 建议1:不用再常量和变量中出现易混淆的字母
 * Created by ankang on 2017-03-26.
 */
public class S1 {
    public static void main(String[] args) {
//        long i = 1l;
        long i = 1L;  //L大写
        System.out.println("i的两倍是: " + (i + i));
    }
}
