package com.the151suggestions.part9.s120;

/**
 * 不使用stop()停止线程原因:
 * 1.stop()已过时
 * @Deprecated
 * public final void stop() {...}
 *
 * Created by Akang on 2017/8/25.
 */
public class NoUseStop {
    public static void main(String[] args) {
        testStop2();    //stop()会导致代码逻辑不完整
        testStop3();    //stop()会破坏原子逻辑
    }

    /**
     * 1. 线程thread.start(),执行run(),此时没有其他线程持有锁标记,thread线程a++,然后休眠0.1秒(此时a=1)
     * 2. JVM有相继启动5个线程且运行run(),但此时thread线程(持有锁标记)休眠,5个线程无法执行自增自减操作
     * 3. 线程thread.stop()停止线程,释放锁标记,由于a变量是所有线程共享,所以其他线程获得的a的值
     * 4. 5个线程相继获得锁标记,执行打印语句
     * 结果全部为1:在thread线程休眠的0.1秒内,5个线程启动后阻塞,并且执行thread.stop(),此时a=1
     * 结果全部为0:在thread线程休眠的0.1秒内,5个线程启动后阻塞,休眠结束,thread执行a--,再执行thread.stop(),此时a=0
     */
    private static void testStop3() {
        MultiThread multiThread = new MultiThread();
        Thread thread = new Thread(multiThread);
        //启动thread线程
        thread.start();
        for (int i = 0; i < 5; i++) {
            /**
             * 所有线程共享了multiThread对象
             */
            new Thread(multiThread).start();
        }

        /**
         * 停止thread线程
         * 不stop(),a应该全是0,stop()后a有时=1,破坏了synchronized的原子操作
         */
        thread.stop();
    }

    /**
     * 子线程启动后,休眠1秒,期间主线程休眠0.1秒,子线程停止(此时,子线程还在休眠状态),
     * stop()会清除栈内存信息,结束线程,导致run()逻辑不完整(打印语句不执行)
     */
    private static void testStop2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    /**
                     * 子线程休眠1秒
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * 该打印语句不会执行
                 */
                System.out.println("此处代表一段逻辑,比如,子线程的主逻辑,资源回收,情景初始化等");
            }
        };
        //子线程启动
        thread.start();
        try {
            /**
             * 主线程休眠0.1秒
             */
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         *子线程停止
         * stop()使线程停止,打印语句不会执行
         */
        thread.stop();
    }

}

class MultiThread implements Runnable {
    int a = 0;

    @Override
    public void run() {
        //同步代码块
        synchronized (this) {
            a++;    //自增操作,非原子性
            try {
                //休眠0.1秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a--;    //自减操作,非原子性
            String name = Thread.currentThread().getName(); //获取线程名称
            /**
             * 输出结果a全是1,或全是0
             *  Thread-5: a = 1 或 0
                Thread-3: a = 1 或 0
                Thread-4: a = 1 或 0
                Thread-2: a = 1 或 0
                Thread-6: a = 1 或 0
             */
            System.out.println(name + ": a = " + a);
        }
    }
}