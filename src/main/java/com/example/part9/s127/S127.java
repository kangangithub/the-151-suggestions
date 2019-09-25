package com.example.part9.s127;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 建议127: Lock与synchronized是不一样的
 * <p>
 * 开始执行 TaskWithLock 任务
 * 线程名称: pool-1-thread-3执行时间: 55 s
 * 线程名称: pool-1-thread-1执行时间: 55 s
 * 线程名称: pool-1-thread-2执行时间: 55 s
 * TaskWithLock 任务执行完毕
 * 开始执行 TaskWithSync 任务
 * 线程名称: pool-2-thread-1执行时间: 5 s
 * 线程名称: pool-2-thread-2执行时间: 7 s
 * 线程名称: pool-2-thread-3执行时间: 9 s
 * TaskWithSync 任务执行完毕
 * (执行时间,执行顺序会随每次执行改变,不具有参考意义)
 * Lock锁不出现互斥现象,内部锁符合预期结果.
 * Lock是对象级别的锁(跟随对象,每次newInstance()后对象不一样),内部锁是类级别的锁(跟随类,newInstance()与类无关)
 * 把Lock定义为多线程类的私有属性起不到资源互斥作用,除非把Lock定义为所有线程的共享变量,见testLock()
 * <p>
 *  1. Lock支持更细粒度的锁控制,可重入读写锁--ReentrantReadWriteLock
 *  2. Lock是无阻塞锁,synchronized是阻塞锁
 *  3. Lock可实现公平锁,synchronized只能是非公平锁
 *     公平锁:线程A持有锁,线程B,C阻塞/等待,A释放锁,JVM选择等待时间最长的一个线程持有锁
 *     非公平锁:线程A持有锁,线程B,C阻塞/等待,A释放锁,JVM从B,C中随机选择一个线程持有锁
 *     即使是公平锁,也无法做到准确公平
 *  4.Lock是代码级的,synchronized是JVM级的
 * Created by Akang on 2017/11/5.
 */
@Slf4j
public class S127 {
    public static void main(String[] args) throws Exception {
        //runTasks(TaskWithLock.class);
        //runTasks(TaskWithSync.class);
        //testLock();
        testReadWriteLock();
    }

    private static void runTasks(Class<? extends Runnable> clazz) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("开始执行 " + clazz.getSimpleName() + " 任务");
        //启动三个线程
        for (int i = 0; i < 3; i++) {
            executorService.submit(clazz.newInstance());
        }
        //等待足够长的时间,然后关闭执行器
        TimeUnit.SECONDS.sleep(10);
        System.out.println(clazz.getSimpleName() + " 任务执行完毕");
        //关闭执行器
        executorService.shutdown();
    }

    private static void testLock() throws Exception {
        ReentrantLock lock = new ReentrantLock();
        //启动3个线程
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    log.error("An error occurred, The error message is {}", e);
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }

    private static void testReadWriteLock() throws Exception {
        TestReadWriteLock readWriteLock = new TestReadWriteLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> readWriteLock.read(Thread.currentThread())).start();

            new Thread(() -> readWriteLock.write(Thread.currentThread())).start();
        }
    }
}
