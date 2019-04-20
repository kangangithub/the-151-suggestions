package com.the151suggestions.part9.s118;

/**
 * 建议118:不推荐覆写start方法
 * start()源码:
 * public synchronized void start() {
 *  //判断线程状态,必须是未启动状态
    if (threadStatus != 0) throw new IllegalThreadStateException();
    //加入线程组
    group.add(this);

    boolean started = false;
    try {
        //本地方法,分配栈内存,启动线程,运行run()
        start0();
        started = true;
    } finally {
        try {
            //在启动前设置了停止状态
            if (!started) {
                group.threadStartFailed(this);
            }
        } catch (Throwable ignore) {
            do nothing.
        }
    }
 }
    start0()本地方法,实现了启动线程,申请栈内存,运行run(),修改线程状态等职责,
    线程管理和栈内存管理是JVM负责,如果覆盖start(){run();},无法线程管理
    和栈内存管理,无法启动线程.非要覆盖start(){super.start();}
    private native void start0();

 * Created by Akang on 2017/8/25.
 */
public class S118 {
    public static void main(String[] args) {
        MultiThread multiTHread = new MultiThread();
        multiTHread.start();
    }
}

class MultiThread extends Thread {
    /**
     *不推荐覆盖start(),非要覆盖,要super.start();
     */
    //@Override
    //public synchronized void start() {
    //    super.start();
    //    //run();
    //}

    @Override
    public void run() {
        super.run();
    }
}