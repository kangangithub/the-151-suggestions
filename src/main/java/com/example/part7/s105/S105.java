package com.example.part7.s105;

import java.lang.reflect.Array;

/**
 * 建议105:动态加载不适合数组
 * Created by Akang on 2017/8/23.
 */
public class S105 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String[] strings = new String[10];
        /**
         * String[]是声明类型,编译后变成[Ljava.lang.String;
         * byte[] ---> [B
         * char[] ---> [C
         * double[] ---> [D
         * float[] ---> [F
         * int[] ---> [I
         * long[] ---> [J
         * short[] ---> [S
         * boolean[] ---> [Z
         * 引用类型(如String[],包装类Integer[]) ---> [L([Ljava.lang.String;[Ljava.lang.Integer;)
         */
        Class.forName("[Ljava.lang.String;");// 全限定名中;结尾不能省略

        int[] ints = new int[10];
        Integer[] integers = new Integer[10];
        Class.forName("[I");
        Class.forName("[Ljava.lang.Integer;");

        double[] doubles = new double[10];
        Double[] doubles1 = new Double[10];
        Class.forName("[D");
        Class.forName("[Ljava.lang.Double;");

        /**
         * Class.forName("[Z"); Class.forName("[Ljava.lang.Boolean;");
         * 只是把boolean[]/Boolean[]加载到内存中,不能通过newInstance()生成实例对象,
         * 因为没有定义数组长度,Java中,数组定长,不存在没有长度的数组
         */
        boolean[] booleans;
        Boolean[] booleans1;
        Class.forName("[Z");
        Class.forName("[Ljava.lang.Boolean;");

        /**
         * 获取数组对象的方法:不能通过Class.forName(String).newInstance()获取
         *  1.使用new关键字/显式声明数组
         *       long[] longs1 = new long[10];
         *       long[] longs1 = {2L, 3L};
         *       long[] longs1 = new long[]{4L, 5L};
         *  2.使用Array类
         *      long[] longs = (long[]) Array.newInstance(long.class, 10);
         *      int[][] ints = (int[][]) Array.newInstance(int.class, 2, 3);
         */
        long[] longs1 = new long[10];
        long[] longs2 = {2L, 3L};
        long[] longs3 = new long[]{4L, 5L};

        long[] longs4 = (long[]) Array.newInstance(long.class, 10);
        System.out.println(longs4.length);
        Long[] longs5 = new Long[10];
        System.out.println(longs5.length);
        Class.forName("[J");
        Class.forName("[Ljava.lang.Long;");


    }
}
