package com.example.part9.s120;

/**
 * 建议120:不使用stop方法停止线程
 * 安全停止线程的方法:
 * 1. 自定义标志位
 * 2. 使用interrupt()辅助
 * Created by Akang on 2017/8/25.
 */
public class S120 {
    public static void main(String[] args) {
        testDIYSign();
        testInterupt();
    }

    private static void testDIYSign() {
        SafeStopThread safeStopThread = new SafeStopThread();
        //启动thread线程
        safeStopThread.start();
    }

    private static void testInterupt() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                System.out.println("The thread started");
                /**
                 * isInterrupted(): 线程是否被打断
                 */
                while (!isInterrupted()) {
                    System.out.println("The thread is running ...");
                    try {
                        Thread.sleep(2000);

                        /**
                         * interrupt():不能停止线程,只会改变中断标志位,使一个被阻塞的线程抛出一个中断异常，
                         * 从而使线程提前结束阻塞状态，退出堵塞代码
                         */
                        interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("The thread is interrupted");
            }
        };

        thread.start();
    }
}

class SafeStopThread extends Thread {
    /**
     * 自定义标志位:使用自定义标志位判断线程的执行情况
     * volatile保证可见性(一个线程对stop变量的修改对其他线程可见)
     */
    private volatile boolean stop = false;

    @Override
    public void run() {
        System.out.println("The thread started");
        /**
         * 线程体中判断是否需要停止运行,保证逻辑的完整和原子操作
         */
        while (!stop) {
            try {
                System.out.println("The thread is running ...");
                Thread.sleep(3000);
                throw new InterruptedException("The thread is interrupted");
            } catch (InterruptedException e) {
                e.printStackTrace();
                /**
                 * 发生异常,修改标志位
                 */
                stop = true;
            }
        }
        System.out.println("The thread stopped safe");
    }
}