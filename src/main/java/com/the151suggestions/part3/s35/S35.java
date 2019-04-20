package com.the151suggestions.part3.s35;

/**
 * 建议35: 避免在构造方法中初始化其他类
 * Created by ankang on 2017-03-28.
 */
public class S35 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        /**
         * 报StackOverflowError,栈内存溢出
         * 声明sub时,调用Sub无参构造,JVM又默认调用父类Base无参构造,Base类又初始化Other类,而Other类又调用Sub类--->死循环
         * 假设场景:
         * Base是框架提供的,Sub是自己编写扩展的,Other是框架要求的拦截类,在构造方法中初始化其他类,就会报StackOverflowError,栈内存溢出
         */
        sub.doSomething();
    }
}

//父类
class Base {
    Base() {
        new Other();
    }
}

//子类
class Sub extends Base {
    public void doSomething() {
        System.out.println("Hi,show me something.");
    }
}

//相关类
class Other {
    public Other() {
        new Sub();
    }
}
