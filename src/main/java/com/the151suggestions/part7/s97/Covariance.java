package com.the151suggestions.part7.s97;

/**
 * 协变(Covariance):用窄类型替换宽类型,多态
 *      1. 协变-->Sub1中doStuff()返回值Integer,覆盖了父类的doStuff方法(返回值Number),窄类型替换宽类型
 *      2. 协变-->Base1 base1 = new Sub1(); 父类Base1接收,子类Sub1赋值,窄类型替换宽类型,就是多态
 * Created by ankang on 2017-08-17.
 */
public class Covariance {
    public static void main(String[] args) {
        Base1 base1 = new Sub1();
    }
}

class Base1 {
    public Number doStuff() {
        return 0;
    }
}

class Sub1 extends Base1 {
    @Override
    public Integer doStuff() {
        return 0;
    }
}