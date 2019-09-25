package com.example.part4.s59;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * 建议59:对字符串排序持一种宽容的心态
 * 简单的中文排序,使用Collator类.
 * Created by ankang on 2017-08-07.
 */
public class S59 {
    public static void main(String[] args) {
        String[] arrStrings = {"乔峰", "郭靖", "杨过", "张无忌", "韦小宝"};
        // Collator 类是用来执行区分语言环境的 String 排序的，这里选择使用CHINA
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        // 使根据指定比较器产生的顺序对指定对象数组进行排序。
        Arrays.sort(arrStrings, comparator);
        for (int i = 0; i < arrStrings.length; i++) {
            System.out.println(arrStrings[i]);
        }
    }
}
