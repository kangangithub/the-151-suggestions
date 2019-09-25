package com.example.part1.s10;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

/**
 * 建议10: 不要在本类中覆盖静态导入的变量和方法
 *          优先选择本类中的方法,属性
 * Created by ankang on 2017-03-26.
 */
public class S10 {
    public static void main(String[] args) {
        System.out.println("PI=" + PI);
        System.out.println("abs(100)="+abs(100));
    }

    //常量名与静态导入的PI相同
    public final static String PI = "祖冲之";

    //方法名与静态导入的相同
    public static int abs(int abs){
        return 0;
    }
}
