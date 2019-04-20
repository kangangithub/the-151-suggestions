package com.the151suggestions.part3.s37;

/**
 * 建议37: 构造代码块会想你所想
 * 构造代码块:在类中没有任何前后缀,使用"{}"括起来的代码片段,是为了提取构造方法的共同量,减少各个构造方法的代码而产生的
 *       特性:在每个构造方法中都运行且首先运行(有super();时,插入构造代码块在super()后执行),
 *            遇到this关键字(构造方法调用其他构造方法时,如this();/ this.a = a;)不插入构造代码块
 * Created by ankang on 2017-03-28.
 */
public class S37 {
    public static void main(String[] args) {
        new Base();
        new Base("");
        new Base(0);
        new Base(5L);
        new Base(0.5D);
        System.out.println("实例对象数量: " + Base.getNumOfObjects());    //  5
    }
}

class Base {
    private long a;

    //对象计数器
    private static int numOfObjects = 0;

    {
        numOfObjects++;
    }

    public Base() {
    }

    //有参构造调用无参构造
    public Base(String s) {
        this();
    }

    //有参构造调用无参构造
    public Base(int i) {

    }

    //有参构造为属性赋值
    public Base(long a) {
        this.a = a;
    }

    //有参构造调用父类Object无参构造
    public Base(double d) {
        super();
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }
}