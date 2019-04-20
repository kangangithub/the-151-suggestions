package com.the151suggestions.part9.s122;

/**
 * TCP服务器DEMO,实现数据的收发
 * 实际环境中,TCP服务器开发需要注意:
 *  1.记录异常信息,以便查找问题
 *  2.发生异常时重新启动一个Server,提供不间断服务
 *  3.共享资源被锁定时,停止所有线程,释放资源(自动重启自会增加系统负担)
 *  4.产生脏数据时(原子操作中抛出异常,可能破坏业务逻辑),重启不能解决逻辑异常
 *  5.可能出现内存溢出,异常发生后重启,为保证对用户的透明性(即用户感觉不到服务重启),
 *      在启动时需要加载大量对象以保证用户状态,如果反复重启,可能引发内存溢出
 * Created by Akang on 2017/8/25.
 */
public class TCPServer implements Runnable {
    //创建后即启动
    public TCPServer() {
        Thread thread = new Thread(this);
        /**
         * JDK1.5以后,Thread类中增加了setUncaughtExceptionHandler(),实现了线程异常的捕获和处理.
         */
        thread.setUncaughtExceptionHandler(new TCPServerExceptionHandler());
        thread.start();
    }

    @Override
    public void run() {
        //正常业务运行,运行3秒
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("系统正常运行: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //抛出异常
        throw new RuntimeException();
    }

    /**
     * 线程异常处理类TCPServerExceptionHandler:JDK1.5以后, UncaughtExceptionHandler
     *  1.记录异常信息,以便查找问题
     *  2.重新启动一个Server,提供不间断服务
     */
    private static class TCPServerExceptionHandler implements Thread.UncaughtExceptionHandler {
        /**
         * uncaughtException(): 设置该线程出现非受检异常时,由TCPServerExceptionHandler异常处理器处理
         * @param t 当前线程对象
         * @param e 当前线程抛出的异常
         */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("线程: " + t.getName() + " 出现异常,服务器重启,异常信息: ");
            e.printStackTrace();
            //重启Server
            new TCPServer();
        }
    }
}
