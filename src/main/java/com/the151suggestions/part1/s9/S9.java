package com.the151suggestions.part1.s9;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * 建议9: 少用静态导入
 *      静态导入:import static java.lang.Math.PI;   import static org.junit.Assert.assertEquals;
 *      静态导入要点:
 *      1.不适用*(通配符),除非是导入静态常量类(只包含常量的类/接口)
 *      2.方法名是具有明确,清晰表象意义的工具类
 * Created by ankang on 2017-03-26.
 */
public class S9 {
    public static void main(String[] args) {
        System.out.println(MathUtils.calBallArea(1));
        DaoTest.test1();
    }
}

class MathUtils {
    //计算圆面积
    public static double calCircleArea(double r) {
        return PI * r * r;
    }

    //计算球面积
    public static double calBallArea(double r) {
        return 4 * PI * r * r;
    }
}

class DaoTest{
    public static void test1(){
        assertEquals("foo","foo");
        assertFalse(Boolean.FALSE);
    }
}