package com.example.part3.s36;

/**
 * 建议36: 使用构造代码块精炼程序
 * Java中四类代码块:
 * 1.普通代码块:方法后面使用"{}"括起来的代码片段,不能单独执行,必须通过方法名调用执行
 * 2.静态代码块:static{...},用于静态变量初始化/对象创建前的环境初始化
 * 3.同步代码块:synchronized(加锁对象){...},表示同一时间只有一个获得锁的线程进入到代码块中
 * 4.构造代码块:在类中没有任何前后缀,使用"{}"括起来的代码片段,是为了提取构造方法的共同量,减少各个构造方法的代码而产生的
 *              编译器会把构造代码块插入到每个构造方法的最前端
 *              特性:在每个构造方法中都运行且首先运行(有super();时,在super()后执行),
 *                   遇到this关键字(构造方法调用其他构造方法时,如this();)不插入构造代码块
 *              应用场景:
 *              1.初始化实例变量
 *              2.初始化实例环境:例,要生成HTTP Request,需首先建立HTTP Session,可以通过构造代码块来检查HTTP Session是否存在,不存在则创建
 *
 * Created by ankang on 2017-03-28.
 */
public class S36 {
    public static void main(String[] args) {
        //A B类写法等效
        new A();
        new A("");
        new B();
        new B("");
        new C();
        new C("");
    }
}

class A {
    {
        System.out.println("执行A构造代码块");
    }

    A() {
        System.out.println("执行A无参构造");
    }

    A(String s) {
        System.out.println("执行A有参构造");
    }
}

class B {

    B() {
        System.out.println("执行B构造代码块");
        System.out.println("执行B无参构造");
    }

    B(String s) {
        System.out.println("执行B构造代码块");
        System.out.println("执行B有参构造");
    }
}

class C {

    {
        System.out.println("执行C构造代码块1");
    }

    {
        System.out.println("执行C构造代码块2");
    }

    C() {
        System.out.println("执行C无参构造");
    }

    C(String s) {
        System.out.println("执行C有参构造");
    }
}