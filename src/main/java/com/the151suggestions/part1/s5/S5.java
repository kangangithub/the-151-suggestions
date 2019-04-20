package com.the151suggestions.part1.s5;

/**
 * 建议5: 别让null值和空值威胁到变长方法
 * Created by ankang on 2017-03-26.
 */
public class S5 {
    public static void main(String[] args) {
        S5 s5 = new S5();
        s5.methodA("China", 0);
        s5.methodA("China", "People");
//        s5.methodA("China");   编译失败,无法确定方法
//        s5.methodA("China", null);  编译失败,直接量null是没有类型的,无法确定方法
        String[] strings = null;
        s5.methodA("China", strings);
    }

    private void methodA(String string, Integer... integers) {
        System.out.println(string + " " + integers);
    }

    private void methodA(String string, String... strings) {
        System.out.println(string + " " + strings);
    }
}
