package com.example.part2.s29;

/**
 * 建议29: 优先选择基本类型
 * 避免形参为基本类型/包装类型的方法重载
 * Created by ankang on 2017-03-27.
 */
public class S29 {
    public static void main(String[] args) {
        S29 s29 = new S29();
        s29.method(140);    //int ---> long
        /**
         * 自动装箱规则:基本类型先加宽,再转变为宽类型的包装类型,不能直接转变成宽类型的包装类型
         *              int ---> long ---> Long
         */
        s29.method(Integer.valueOf(140));   //Integer ---> int ---> long
    }

    private void method(long i) {
        System.out.println("基本类型的方法被调用");
    }

    private void method(Long i) {
        System.out.println("包装类型的方法被调用");
    }
}
