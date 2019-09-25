package com.example.part8.s115;

/**
 *  不同方法调用相同方法产生不同的结果
 *  当出现异常或主动声明Throwable时,JVM会通过fillInStackTrace()记录栈帧信息,
 *  生成Throwable对象,可以知道类间调用顺序,方法名称及当前行号等信息.
 *  Throwable部分源码:
 *  public class Throwable implements Serializable {
 *      //出现异常的栈信息
 *      private StackTraceElement[] stackTrace;
 *      //默认无参构造,调用记录栈帧的方法fillInStackTrace()
 *      public Throwable() {fillInStackTrace();}
 *      //本地方法,抓取执行时的栈信息
 *      public synchronized Throwable fillInStackTrace() {...}
 *  }
 * Created by Akang on 2017/8/25.
 */
public class Foo {
    public static boolean m() {
        //获取当前栈信息
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        //检查是否是m1()调用
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            if (stackTraceElement.getMethodName().equals("m1")) {
                return true;
            }
        }
        //return false;
        /**
         * 将return false;替换成如下,常用作离线注册码校验,当被暴力破解时,
         * 由于主程序不是期望的值,会返回一个经过包装的异常信息,增加破解难度
         */
        throw new RuntimeException("除了m1()外,其他方法调用都会产生异常");
    }
}
