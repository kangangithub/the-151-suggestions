package com.the151suggestions.part9.s127;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class TestReadWriteLock {
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //可重入读写锁
    private final Lock readLock = readWriteLock.readLock(); //读锁
    private final Lock writeLock = readWriteLock.writeLock(); //写锁

    //读方法,可并发执行
    public void read(Thread thread) {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " start reading, the time is " + System.currentTimeMillis() + " ms");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end reading, the time is " + System.currentTimeMillis() + " ms");
        } catch (InterruptedException e) {
            log.error("An error occurred, The error message is {}", e);
        } finally {
            readLock.unlock();
        }
    }

    //写方法,同时只允许一个写操作
    public void write(Thread thread) {
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " start writing, the time is " + System.currentTimeMillis() + " ms");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end writing, the time is " + System.currentTimeMillis() + " ms");
        } catch (InterruptedException e) {
            log.error("An error occurred, The error message is {}", e);
        } finally {
            writeLock.unlock();
        }
    }
}
