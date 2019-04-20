package com.the151suggestions.part9.s123;

/**
 * 线程类,自增运算(线程不安全)
 * 自增自减运算不是原子的,number++，实际上是三个操作的集合（读取number，number加1，将新的值写回number），
 * volatile只能保证每一步的操作对所有线程是可见的，但是假如两个线程都需要执行number++，那么这一共6个操作集合，
 * 之间是可能会交叉执行的，那么最后导致number 的结果可能会不是所期望的
 * 对于自增之类的非原子性操作只能通过如下方式保证可见性：
 *  1. synchronized
 *  2. Lock(ReentrantLock ...)
 *  3. AtomicXxx(AtomicInteger(提供一原子操作的Integer的类, 用原子方式更新的 int 值) AtomicLong...)
 *
 * Created by Akang on 2017/8/28.
 */
public class UnsafeThread implements Runnable {
    //共享资源
    private volatile int count = 0;

    @Override
    public void run() {
        /**
         * 只为增加CPU的繁忙程度,加重线程负荷,以便出现单个线程抢占CPU资源的情况,
         * 否则很难模拟出volatile线程不安全的情况
         */
        for (int i = 0; i < 10000; i++) {
            Math.hypot(Math.pow(2115946450, i), Math.cos(i));
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
