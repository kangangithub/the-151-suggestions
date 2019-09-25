package com.example.part1.s15;

import java.util.Scanner;

/**
 * 建议15: break万万不可忘
 * JDK1.7以后,switch()中,可以是byte,short,int,char,String(内部实现是使用字符串的 hash code。)
 * Created by ankang on 2017-03-26.
 */
public class S15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("走入深渊...");
                break;
            case 2:
                System.out.println("灰色的一天...");
                break;
            case 3:
                System.out.println("灰色的一天...");
                break;
            case 4:
                System.out.println("黎明前的黑暗");
                break;
            case 5:
                System.out.println("好日子即将来临...");
                break;
            default:
                System.out.println("快乐的单身汉...");
                break;
        }
        System.out.println("ending...");
    }
}
