package com.the151suggestions.part2.s23;

import com.the151suggestions.common.Constant;

/**
 * 建议23: 不要让类型默默转换
 *          基本类型转换时,使用主动声明式类型转换减少不必要的Bug
 * Created by ankang on 2017-03-27.
 */
public class S23 {
    public static void main(String[] args) {
        System.out.println("1. 月光照射到地球需要1s,计算月球地球距离.");
        long distance1 = Constant.LIGHT_SPEED * 1;
        System.out.println("月球到地球的距离是 " + distance1 + " 米.\n2.太阳光照射到地球需8min,计算太阳地球距离.");
        //可能要超出int范围,使用long型
//        long distance2 = Constant.LIGHT_SPEED * 60 * 8;   负值,超出int范围(过界了会从头开始),Java是先运算再类型转换的
        long distance2 = 1L * Constant.LIGHT_SPEED * 60 * 8; // 1L--->主动声明式类型转换
        System.out.println("太阳到地球的距离是 " + distance2 + " 米.");
    }
}
