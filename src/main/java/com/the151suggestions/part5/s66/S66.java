package com.the151suggestions.part5.s66;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 建议66:asList方法产生的List对象不可更改
 * asList方法源码:输入一个变成参数,返回一个固定长度的列表,此列表不可扩容
 *  public static <T> List<T> asList(T... a) {
     return new ArrayList<>(a);
     }
 * 不可扩容的原因:
 * 返回的ArrayList是Arrays的一个私有的静态内部类,该内部类没有提供add方法,
 * 其父类AbstractList中的add方法直接throw new UnsupportedOperationException();
 *
 * Arrays的静态内部类ArrayList中实现的方法:
 *  1. size() 长度
 *  2. toArray() 转化成数组
 *  3. get() 获取指定值
 *  4. set() 重置某元素值
 *  5. contains() 是否包含某元素
 *
 *  List<String> list = Arrays.asList("ABC","CDF","GJK");--->不可取
 * Created by ankang on 2017-08-08.
 */
@Slf4j
public class S66 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        try {
            list.add(6);
        } catch (Exception e) {
            log.error("An error occurred when adding something into the list, the error message is {}", e);
        }
    }
}
