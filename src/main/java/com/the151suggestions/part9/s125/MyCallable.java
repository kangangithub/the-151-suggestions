package com.the151suggestions.part9.s125;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 自定义有返回值的任务
 * Created by Akang on 2017/8/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCallable implements Callable<Object> {
    private Integer taskNum;

    @Override
    public Object call() throws Exception {
        System.out.println(taskNum + " task start.");
        Date date = new Date();
        Thread.sleep(1000);
        long time = new Date().getTime() - date.getTime();
        System.out.println(taskNum + " task stop.");
        return taskNum + " task expend " + time + " ms.";
    }
}
