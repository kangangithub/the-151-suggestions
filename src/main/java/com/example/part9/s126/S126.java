package com.example.part9.s126;

import com.example.common.Constant;
import com.example.part9.s125.MyCallable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 建议126:适时选择不同的线程池来实现
 * Created by Akang on 2017/9/14.
 */
public class S126 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testNewSingleThreadExecutor();
        testNewCachedThreadPool();
        testNewFixedThreadExecutor();
    }

    /**
     * newFixedThreadPool: 固定线程数量的线程池,初始化时决定了线程池最大容量,若任务添加的能力超出了线程处理能力,
     * 则建立阻塞队列容纳多余的任务
     * 源码:
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     * return new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
     * }
     * private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
     * 注意: 上面返回的是ThreadPoolExecutor,其corePoolSize和maximumPoolSize相等,即最大线程数量是nThreads,若任务增长速度非常快,\
     * 超过了LinkedBlockingQueue的最大容量(int最大值),会按照ThreadPoolExecutor默认的拒绝策略(默认DiscardPolicy,直接丢弃)来处理.
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testNewFixedThreadExecutor() throws ExecutionException, InterruptedException {
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

    /**
     * newCachedThreadPool: 缓冲功能的线程池.该线程池线程数量没有限制(不能超过int最大值),新增一个任务既有一个线程处理,
     * 或者复用之前空闲的线程,或启动一个新线程,但一旦一个线程在60秒内一直处于等待状态时(即1分钟没有工作可做),则会被终止
     * 源码:
     * public static ExecutorService newCachedThreadPool() {
     * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
     * }
     * 注意: 该任务队列使用了同步阻塞队列(SynchronousQueue<Runnable>),即向队列中加入一个元素,即可唤醒一个线程(新创建的线程或复用池中的空闲线程)来处理任务
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testNewCachedThreadPool() throws ExecutionException, InterruptedException {
        System.out.println("Task start running ...");
        Date date = new Date();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建有返回值的任务的List集合
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < Constant.TASK_SIZE; i++) {
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

    /**
     * newSingleThreadExecutor: 单线程池,即一个池中只有一个线程运行,该线程永不超时,当有多个任务需要处理时,
     * 会将它们放置到一个无界的阻塞队列中逐个处理.
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testNewSingleThreadExecutor() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "newSingleThreadExecutor";
            }
        });
        //Future<String> future = executorService.submit(() -> "newSingleThreadExecutor");
        System.out.println("return: " + future.get());
        executorService.shutdown();
    }
}

