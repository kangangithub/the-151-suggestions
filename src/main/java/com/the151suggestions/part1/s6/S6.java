package com.the151suggestions.part1.s6;

/**
 * 建议6: 覆写变长方法也循规蹈矩
 * 覆写需满足条件:
 * 1.重写方法不能缩小访问权限
 * 2.参数列表必须与被重写方法相同,不仅仅是类型,数量,还包括显示形式
 * 3.返回值类型必须与被重写方法相同或是其子类
 * 4.重写方法不能抛出新的异常,或者超出父类范围的异常,但是可以抛出更少,更有限的异常,或者不抛出异常
 * Created by ankang on 2017-03-26.
 */
public class S6 {
    public static void main(String[] args) {
        //向上转型
        Base base = new Sub();
        base.fun(100, 50);

        //不转型
        Sub sub = new Sub();
        sub.fun(100, 50);
    }
}

class Sub extends Base {
    @Override
    void fun(int price, int... discounts) {
        System.out.println("Sub----fun()");
    }
}

class Base {
//    参数列表必须与被重写方法相同,不仅仅是类型,数量,还包括显示形式
//    void fun(int price, int[] discounts) {    编译不通过
    void fun(int price, int... discounts) {
        System.out.println("Base----fun()");
    }
}

