package com.the151suggestions.part9.s121;

/**
 * 建议121:线程优先级只使用3个等级
 *   //最低优先级
     public final static int MIN_PRIORITY = 1;

     //普通优先级,默认
     public final static int NORM_PRIORITY = 5;

     //最高优先级
     public final static int MAX_PRIORITY = 10;

 * Created by Akang on 2017/8/25.
 */
public class S121 {
    public static void main(String[] args) {
        /**
         * 1.不是严格按照线程优先级来执行
         *      7级可能在8级前面执行,但很少出现优先级1在优先级10前面执行
         *      优先级只是代表获得CPU运行时间片的机会大小,并不代表强制的排序
         * 2.优先级擦别越大,运行机会差别越明显
         *  10级通常在1级前面执行,但5级6级的差别不明显
         *
         *  操作系统分配优先级和CPU时间片,但不同系统调用不同方法设置优先级,
         *  不同系统优先级也不同.Java跨平台,所以Java的优先级只代表获得CPU运
         *  行时间片的机会大小
         Priority: 10
         Priority: 8
         Priority: 7
         Priority: 9
         Priority: 3
         Priority: 5
         Priority: 6
         Priority: 4
         Priority: 1
         Priority: 2
        */
        testPriority();

        /**
         * 建议使用Thread的3个优先级常量,即便在不同的操作系统上,
         * MAX_PRIORITY优先级大部分情况下比NORM_PRIORITY优先级先运行,
         * 当优先级相同时,按照FIFO(先进先出)原则,但也不能完全保证
         *
         * Thread部分源码:
         public class Thread implements Runnable {
            //最低优先级
            public final static int MIN_PRIORITY = 1;

            //普通优先级,默认
            public final static int NORM_PRIORITY = 5;

            //最高优先级
            public final static int MAX_PRIORITY = 10;
            ....
         }
         */
    }

    private static void testPriority() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest());
            thread.setPriority(i % 10 + 1);
            thread.start();
        }
    }
}

class ThreadTest implements Runnable {
    @Override
    public void run() {
        /**
         * 线程优先级只有在CPU繁忙时才能更直观的显现,
         * 所以这里多次循环执行一个很占用CPU资源的操作
         */
        for (int i = 0; i < 100000; i++) {
            //只为尽可能多的占用CPU资源,无其他含义
            Math.hypot(Math.pow(953565445665D, i), Math.cos(i));
        }
        //输出线程优先级
        System.out.println("Priority: " + Thread.currentThread().getPriority());
    }
}
