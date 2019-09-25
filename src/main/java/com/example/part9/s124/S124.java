package com.example.part9.s124;

import java.util.concurrent.*;

/**
 * 建议124:异步运算考虑使用Callable接口
 * 为了系统更友好,实现用户输入即有输出,若耗时较长,显示运算进度,重启一个线程来运算,main线程做进度展示.
 * Created by Akang on 2017/8/28.
 */
public class S124 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 生成一个单线程的Executor异步执行器
         * Executors,静态工具类,提供异步执行器的创建
         * newFixedThreadPool(int nThreads)   创建固定数目线程的线程池
         * newCachedThreadPool() 创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
         *      如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
         * newSingleThreadExecutor()   创建一个单线程化的Executor
         * newScheduledThreadPool(int corePoolSize) 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        /**
         * Future: 线程执行后的返回值(期望值)
         */
        Future<Integer> future = executorService.submit(new TaxCalculator(100));
        //还未计算完
        while (!future.isDone()) {
            //等待200毫秒
            TimeUnit.MILLISECONDS.sleep(200);
            //输出进度符号#
            System.out.print("#");
        }
        System.out.println("\n计算完成,税金是: " + future.get() + " 元.");
        //关闭Executor
        executorService.shutdown();
    }
}
