package com.the151suggestions.part9.s123;

/**
 * 建议123:volatile不能保证数据同步
 * volatile 变量提供顺序和可见性保证
 *  顺序性:JVM 或者 JIT为了获得更好的性能会对语句重排序，volatile 类型变量不会与其他语句重排序
 *  可见性:volatile 提供 happens-before 的保证，确保一个线程的修改能对其他线程是可见的。
 *          volatile变量每次被线程访问时，都强迫线程从主内存中重读该变量的最新值，
 *          而当该变量发生修改变化时，也会强迫线程将最新的值刷新回主内存中。
 *          这样一来，不同的线程都能及时的看到该变量的最新值。
 * volatile 型的 long 或 double 变量的读写是原子的.
 *  double 和 long 是64位数据类型,因此对这两种类型的读是分为两部分的，第一次读取第一个 32 位，
 *  然后再读剩下的 32 位，这个过程不是原子的.
 *
 * volatile不能保证变量更改的原子性,比如自增自减操作：number++，
 * 这个操作实际上是三个操作的集合（读取number，number加1，将新的值写回number），
 * volatile只能保证每一步的操作对所有线程是可见的，但是假如两个线程都需要执行number++，
 * 那么这一共6个操作集合，之间是可能会交叉执行的，那么最后导致number 的结果可能会不是所期望的。
 * Created by Akang on 2017/8/28.
 */
public class S123 {
    public static void main(String[] args) throws InterruptedException {
        //理想值,并作为最大循环次数
        int value = 10000;
        //循环次数,防止出现无限循环
        int loop = 0;

        /**
         * ThreadGroup线程组,表示一个线程的集合。此外，线程组也可以包含其他线程组。
         */
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (loop++ < value) {
            UnsafeThread unsafeThread = new UnsafeThread();
            /**
             * 1. 启动1000个线程,修改count值
             */
            for (int i = 0; i < value; i++) {
                new Thread(unsafeThread).start();
            }

            /**
             * 2. 暂停15秒,观察活动线程数是否为1(即只剩下主线程运行),不为1,再暂停15毫秒
             */
            do {
                Thread.sleep(15);
                /**
                 *  int activeCount() 返回此线程组中活动线程的数量。
                 */
            } while (threadGroup.activeCount() != 1);

            /**
             * 3. 判断共享资源是否安全,即实际值与理想值是否相同,若不相同,则count为脏数据
             *      如果实际值与理想值相同,继续循环直到最大循环次数
             */
            if (unsafeThread.getCount() != value) {
                System.out.println("循环到第" + loop + "次,出现线程不安全的情况.");
                System.out.println("此时,count = " + unsafeThread.getCount());
            }
        }
    }
}
