package com.example.part9.s124;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 模拟个税计算器
 * Created by Akang on 2017/8/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxCalculator implements Callable<Integer> {
    //本金
    private int seedMoney;

    @Override
    public Integer call() throws Exception {
        //复杂运算,耗时10秒
        TimeUnit.MILLISECONDS.sleep(10000);
        return seedMoney / 10;
    }
}
