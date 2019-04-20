package com.the151suggestions.part9.s127;

/**
 * 内部锁任务
 * Created by Akang on 2017/11/5.
 */
public class TaskWithSync extends Task implements Runnable{
    @Override
    public void run() {
        synchronized ("A") { // 内部锁
            doSomething();
        }
    }
}
