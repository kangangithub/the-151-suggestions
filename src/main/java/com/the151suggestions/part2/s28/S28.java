package com.the151suggestions.part2.s28;

import java.util.Scanner;

/**
 * 建议28: 优先使用整型池
 * Created by ankang on 2017-03-27.
 */
public class S28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组整数: "); // 127 128 550
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.print("\n======" + i + "的相等判断======\n");
            //两个通过new产生的Integer的对象
            Integer integer1 = new Integer(i);
            Integer integer2 = new Integer(i);
            System.out.println("new产生的对象: " + (integer1 == integer2));

            //基本类型转换成包装类型比较
            integer1 = i;
            integer2 = i;
            System.out.println("基本类型转换的对象: " + (integer1 == integer2));

            //通过静态方法生成的实例比较
            integer1 = Integer.valueOf(i);
            integer2 = Integer.valueOf(i);
            System.out.println("valueOf()生成的对象: " + (integer1 == integer2));
        }
    }
}
/**
        ======127的相等判断======
        new产生的对象: false
        基本类型转换的对象: true
        valueOf()生成的对象: true

        ======128的相等判断======
        new产生的对象: false
        基本类型转换的对象: false
        valueOf()生成的对象: false

        ======550的相等判断======
        new产生的对象: false
        基本类型转换的对象: false
        valueOf()生成的对象: false

    分析:
        new表示生成新对象,产生的对象地址肯定不同,结果false
        基本类型转换的对象(装箱生成的对象)是通过valueOf()实现的,也就是后两个相同

        Integer.valueOf()的源码:
         public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }

        IntegerCache中的cache是一个静态数组,容纳的是-128--->127间的Integer对象,
        通过valueOf()产生对象时,如果int在-128 -->127 之间,则直接熊整型池中获得对象,
        不在该范围就new一个新对象,通过包装类的valueOf()生成对象可以显著提升效率.

        对象比较不用==
*/