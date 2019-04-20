package com.the151suggestions.part1.s19;

import org.junit.Test;

/**
 * 建议19: 断言绝不是鸡肋
 * 断言是为了方便调试程序，并不是发布程序的组成部分。默认情况下，
 * JVM是关闭断言的。因此如果想使用断言调试程序，需要手动打开断言功能。
 * 在命令行模式下运行Java程序时可增加参数-enableassertions或者-ea打开断言。
 * 可通过-disableassertions或者-da关闭断言(默认情况,可有可无)。
 * Created by ankang on 2017-03-27.
 */
public class S19 {
    /**
     * 断言的使用：
     * 断言是通过关键字assert来定义的，一般的，它有两种形式。
     * assert <bool expression>;       比如     boolean isStudent = false; assert isStudent;
     * assert <bool expression> : <message>;    比如  boolean isSafe = false;  assert isSafe : "Not Safe at all";
     * 第二种形式和第一种的区别在于后者可以指定错误信息。
     */

    @Test
    public void test1() {
        boolean isSafe = false;
        assert isSafe;
        System.out.println("断言通过!");
    }

    @Test
    public void test2() {
        boolean isSafe = false;
        assert isSafe : "Not safe at all";
        System.out.println("断言通过!");
    }

    /**
     * d断言在两种情况下不可用:
     * 1.在对外公开的方法中
     * 2.断言只是为了用来调试程序，切勿将断言写入业务逻辑中,但是如果在发布程序的时候（一般都不会开启断言），所以该句会被忽视
     */
    @Test
    public void test3() {
        String[] args = {};
        assert (args.length > 0);
        System.out.println(args[1]);
    }
}
