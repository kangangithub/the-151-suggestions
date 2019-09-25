package com.example.part3.s33;

/**
 * 建议33: 不要"覆盖Override"静态方法
 * 实例对象有两个类型:表面类型(声明时类型)/实际类型(对象产生时类型)
 * 隐藏:子类"覆盖Override"父类静态方法
 * 隐藏与覆盖不同:
 * 1.隐藏用于静态方法,覆盖用于实例方法
 * 2.隐藏目的是抛弃父类静态方法重现子类方法
 * 覆盖目的是将父类的行为增强/减弱,延续父类职责
 * 另外,尽量不通过实例对象访问静态方法/属性 base.doSomething();-->不好
 * Created by ankang on 2017-03-28.
 */
public class S33 {
    public static void main(String[] args) {
        Base base = new Sub();
        base.doSomething();
        base.doAnything();
    }
}

class Base {
    public static void doSomething() {
        System.out.println("父类静态方法");
    }

    public void doAnything() {
        System.out.println("父类非静态方法(实例方法)");
    }
}

class Sub extends Base {
    public static void doSomething() {
        System.out.println("子类静态方法");
    }

    @Override
    public void doAnything() {
        System.out.println("子类非静态方法(实例方法)");
    }
}