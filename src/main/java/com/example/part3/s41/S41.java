package com.example.part3.s41;

/**
 * 建议41:让多重继承成为现实
 * 多重继承:一个类可以同时从多于一个的父类那里继承行为特征.
 * 在遇到需要多重继承时,可以考虑使用内部类.
 * 内部类可以继承一个与外部类无关的类,保证内部类的独立性,基于这一点,才可以实现多重继承.
 * Created by ankang on 2017-08-04.
 */
public class S41 {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.kind() + " " + son.strong());
        Daughter daughter = new Daughter();
        System.out.println(daughter.strong());
    }
}
