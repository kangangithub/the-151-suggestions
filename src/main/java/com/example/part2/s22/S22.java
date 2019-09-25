package com.example.part2.s22;

import java.math.BigDecimal;

/**
 * 建议22: 使用处理BigDecimal货币
 * (1)商业计算使用BigDecimal。
 * (2)尽量使用参数类型为String的构造函数。
 * (3) BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
 * Created by ankang on 2017-03-27.
 */
public class S22 {
    public static void main(String[] args) throws IllegalAccessException {
        /**
         * 使用BigDecimal参数类型为String的构造方法或者静态方法的valueOf()方法把基本类型的变量构建成BigDecimal对象。
         */
        BigDecimal b1 = new BigDecimal("0.48");
        BigDecimal b2 = BigDecimal.valueOf(0.48);

        BigDecimal b = new BigDecimal("11.23482");
        //四舍五入,保留2位小数
        /**
         ROUND_CEILING
         Rounding mode to round towards positive infinity.
         向正无穷方向舍入

         ROUND_DOWN
         Rounding mode to round towards zero.
         向零方向舍入

         ROUND_FLOOR
         Rounding mode to round towards negative infinity.
         向负无穷方向舍入

         ROUND_HALF_DOWN
         Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round down.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5

         ROUND_HALF_EVEN
         Rounding mode to round towards the "nearest neighbor" unless both neighbors are equidistant, in which case, round towards the even neighbor.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP ，如果是偶数，使用ROUND_HALF_DOWN


         ROUND_HALF_UP
         Rounding mode to round towards "nearest neighbor" unless both neighbors are equidistant, in which case round up.
         向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6


         ROUND_UNNECESSARY
         Rounding mode to assert that the requested operation has an exact result, hence no rounding is necessary.
         计算结果是精确的，不需要舍入模式


         ROUND_UP
         Rounding mode to round away from zero.
         向远离0的方向舍入
         */
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        System.out.println(BigDecimalUtils.add(0.48, 0.26));
        System.out.println(BigDecimalUtils.sub(0.48, 0.26));
        System.out.println(BigDecimalUtils.mul(0.48, 0.26));
        System.out.println(BigDecimalUtils.div(0.48, 0.26, 4));
    }
}
