package com.the151suggestions.part1.s3;

/**
 * 建议3: 三元运算符的类型务必一致
 * Created by ankang on 2017-03-26.
 */
public class S3 {
    public static void main(String[] args) {
        int i = 80;
        String s1 = String.valueOf(i < 100 ? 90 : 100);     //90
        String s2 = String.valueOf(i < 100 ? 90 : 100.0);   //90.0
        System.out.println("两者是否相等: " + s1.equals(s2));
    }
}
