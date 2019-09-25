package com.example.part2.s21;

import java.util.Scanner;

/**
 * 建议21: 用偶判断,不用奇判断
 * Created by ankang on 2017-03-26.
 */
public class S21 {
    public static void main(String[] args) {
        //接收键盘输入的参数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入多个数字判断奇偶性: ");
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
//            String string = i + "--->" + (i % 2 == 1 ? "奇数" : "偶数"); 输入负数无法正确判断奇偶
            String string = i + "--->" + (i % 2 == 0 ? "偶数" : "奇数");
            System.out.println(string);
        }
    }
}
