package com.example.part3.s41;

/**
 * 女儿类,强壮指数降低
 * Created by ankang on 2017-08-04.
 */
public class Daughter extends MotherImpl implements Father {
    public int strong() {
        return new FatherImpl() {//匿名内部类
            @Override
            public int strong() {
                return super.strong() - 2;
            }
        }.strong();
    }
}
