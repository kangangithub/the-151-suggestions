package com.the151suggestions.part9.s127;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显式锁任务
 * Created by Akang on 2017/11/5.
 */
public class TaskWithLock extends Task implements Runnable {
    // 声明显式锁
    private final Lock lock = new ReentrantLock();

    /**
     *  显式锁的锁定与解锁必须放在同一个try{}finally{}中,保证即使出现异常也能正常释放锁,保证其他代码能顺利执行
     */
    @Override
    public void run() {
        try {
            lock.lock(); // 锁定
            doSomething();
        } finally {
            lock.unlock(); // 解锁
        }
    }
}
