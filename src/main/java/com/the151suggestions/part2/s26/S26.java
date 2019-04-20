package com.the151suggestions.part2.s26;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议26: 提防包装类型的null值
 * Created by ankang on 2017-03-27.
 */
public class S26 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(null);
        System.out.println(sum(list));
    }

    private static int sum(List<Integer> list) {
        int count = 0;
        for (Integer integer : list) {
//            count += integer;  报空指针,for循环中隐藏了拆箱,把包装类型转换成基本类型,拆箱是调用intValue()实现的,包装对象null, null.intValue()
            count += (integer != null ? integer : 0);
        }
        return count;
    }
}
