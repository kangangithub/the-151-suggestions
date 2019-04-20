package com.the151suggestions.part9.s125;

import com.the151suggestions.common.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 建议125:优先选择线程池
 * Created by Akang on 2017/8/28.
 */
public class S125 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Task start running ...");
        Date date = new Date();
        //任务数量
        int taskSize = Constant.TASK_SIZE;
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        //创建有返回值的任务的List集合
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable callable = new MyCallable(i);
            //获取任务返回值
            Future future = executorService.submit(callable);
            //添加任务返回值到list
            list.add(future);
        }

        //关闭线程池
        executorService.shutdown();

        //遍历list列表
        for (Future future : list) {
            //get(): 获取任务返回值
            System.out.println(future.get().toString());
        }

        System.out.println("Task stop, it expends " + (new Date().getTime() - date.getTime()) + " ms.");
    }
}
