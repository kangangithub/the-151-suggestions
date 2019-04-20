package com.the151suggestions.part8.s110;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义异常容器:解决一次抛出多个异常:Java异常一次只能抛出一个
 * Created by Akang on 2017/8/24.
 */
@Data
public class CatchMoreThanOneException extends Exception {
    //容纳所有异常
    private List<Throwable> causes = new ArrayList<>();

    //构造方法,传递一个异常列表
    public CatchMoreThanOneException(List<? extends Throwable> list) {
        causes.addAll(list);
    }

    //读取所有异常
    public List<Throwable> getExceptions() {
        return causes;
    }
}
