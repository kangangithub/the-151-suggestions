package com.example.part9.s127;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;

/**
 * 任务类
 * Created by Akang on 2017/11/5.
 */
@Slf4j
public class Task {
    public void doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("An error occurred, The error message is {}", e);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("线程名称: " + Thread.currentThread().getName());
        /**
         * get(13) 获取执行时间,单位: 秒
         * YEAR = 1  MONTH = 2  WEEK_OF_YEAR = 3  WEEK_OF_MONTH = 4  DATE = 5   DAY_OF_MONTH = 5  DAY_OF_YEAR = 6
         *  DAY_OF_WEEK = 7  DAY_OF_WEEK_IN_MONTH = 8   AM_PM = 9   HOUR = 10   HOUR_OF_DAY = 11  MINUTE = 12   SECOND = 13 MILLISECOND = 14
         */
        stringBuffer.append("执行时间: " + Calendar.getInstance().get(13) + " s");
        System.out.println(stringBuffer);
    }
}
