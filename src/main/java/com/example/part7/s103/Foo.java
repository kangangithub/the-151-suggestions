package com.example.part7.s103;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Akang on 2017/8/23.
 */
public class Foo {
    public <T> T[] doStuff(List<T> list) {
        return (T[]) list.toArray();
    }

    public String doSomething(String s) {
        System.out.println(s);
        return s;
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("A", "B");
        String[] strings = doStuff(list);
        /**
         * 打印数组用Arrays.toString(strings)或Arrays.deepToString(strings)
         * 数组没有实现toString()
         */
        System.out.println(Arrays.deepToString(strings));
        System.out.println(Arrays.toString(strings));
    }
}
