package com.example.part3.s41;

/**
 * 儿子类:比父亲更强壮,但温柔指数降低
 * Created by ankang on 2017-08-04.
 */
public class Son extends FatherImpl implements Mother {
    public int kind() {
        return new MotherSpecial().kind();
    }

    @Override
    public int strong() {
        return super.strong() + 1;
    }

    //成员/实例内部类
    private class MotherSpecial extends MotherImpl {

        public int kind() {
            return super.kind() - 1;
        }
    }
}
