package com.example.part2.s25;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 建议25: 不要让四舍五入亏了一方
 * Created by ankang on 2017-03-27.
 */
public class S25 {
    public static void main(String[] args) {
        System.out.println("12.5的四舍五入值：" + Math.round(12.5));  //13
        System.out.println("-12.5的四舍五入值：" + Math.round(-12.5) + "\n");  //-12

        BigDecimal d = new BigDecimal(100000);      //存款
        BigDecimal r = new BigDecimal(0.001875 * 3);   //利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);     //使用银行家算法
        System.out.println("季利息是：" + i);
    }
}
        /**
        在银行、帐户、计费等领域，BigDecimal提供了精确的数值计算。其中8种舍入方式值得掌握。
        1、ROUND_UP
        舍入远离零的舍入模式。
        在丢弃非零部分之前始终增加数字(始终对非零舍弃部分前面的数字加1)。
        注意，此舍入模式始终不会减少计算值的大小。
        2、ROUND_DOWN
        接近零的舍入模式。
        在丢弃某部分之前始终不增加数字(从不对舍弃部分前面的数字加1，即截短)。
        注意，此舍入模式始终不会增加计算值的大小。
        3、ROUND_CEILING
        接近正无穷大的舍入模式。
        如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
        如果为负，则舍入行为与 ROUND_DOWN 相同。
        注意，此舍入模式始终不会减少计算值。
        4、ROUND_FLOOR
        接近负无穷大的舍入模式。
        如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
        如果为负，则舍入行为与 ROUND_UP 相同。
        注意，此舍入模式始终不会增加计算值。
        5、ROUND_HALF_UP
        向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
        如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同。
        注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
        6、ROUND_HALF_DOWN
        向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
        如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
        7、ROUND_HALF_EVEN
        向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
        如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同;
        如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同。
        注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
        此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况。
        如果前一位为奇数，则入位，否则舍去。
        以下例子为保留小数点1位，那么这种舍入方式下的结果。
        1.15>1.2 1.25>1.2
        8、ROUND_UNNECESSARY
        断言请求的操作具有精确的结果，因此不需要舍入。
        如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。

        不同舍入模式下的舍入操作汇总
        根据给定的舍入模式将输入数字舍入为一位数的结果
        输入数字	UP	DOWN	CEILING	FLOOR	HALF_UP	HALF_DOWN	HALF_EVEN	UNNECESSARY
        5.5	6	5	6	5	6	5	6	抛出 ArithmeticException
        2.5	3	2	3	2	3	2	2	抛出 ArithmeticException
        1.6	2	1	2	1	2	2	2	抛出 ArithmeticException
        1.1	2	1	2	1	1	1	1	抛出 ArithmeticException
        1.0	1	1	1	1	1	1	1	1
        -1.0	-1	-1	-1	-1	-1	-1	-1	-1
        -1.1	-2	-1	-1	-2	-1	-1	-1	抛出 ArithmeticException
        -1.6	-2	-1	-1	-2	-2	-2	-2	抛出 ArithmeticException
        -2.5	-3	-2	-2	-3	-3	-2	-2	抛出 ArithmeticException
        -5.5	-6	-5	-5	-6	-6	-5	-6	抛出 ArithmeticException
        */


