package com.example.part7.s97;

/**
 * 逆变(Contravariance):用宽类型覆盖窄类型,强转
 * 1.Base2 Sub2的doStuff()构成重载,Sub2中doStuff()的参数Number覆盖Base2中的Integer
 * 2.Integer integer = (Integer) number; 宽类型Number给窄类型Integer赋值,逆变
 * Created by ankang on 2017-08-17.
 */
public class Contravariance {
    public static void main(String[] args) {
        Number number = 1;
        Integer integer = (Integer) number;
    }
}

class Base2 {
    public void doStuff(Integer integer) {
    }
}

class Sub2 extends Base2 {
    public void doStuff(Number number) {
    }
}