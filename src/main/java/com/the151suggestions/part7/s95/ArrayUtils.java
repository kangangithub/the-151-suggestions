package com.the151suggestions.part7.s95;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 把变长参数或数组转变成列表
 * Created by ankang on 2017-08-17.
 */
public class ArrayUtils {
    //Arrays工具类asList()生成的列表长度不可变,自己实现一个工具类使生成的列表长度可变
    public static <T> List<T> asList(T... t) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, t);
        return list;
    }
}
