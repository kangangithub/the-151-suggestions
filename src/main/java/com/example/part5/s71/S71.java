package com.example.part5.s71;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建议71:推荐使用subList处理局部列表
 * subList()返回原始List的一个视图,删除该视图元素,最终反映到原始列表上
 * Created by ankang on 2017-08-09.
 */
public class S71 {
    public static void main(String[] args) {
        test(1);
        test(2);
        testSubList();
    }

    private static void testSubList() {
        List<Integer> list = Collections.nCopies(100, 0);//创建一个长度固定为100,元素都是0的list,不可变列表
        List<Integer> list1 = new ArrayList<>(list);//转换成可变列表
        /**
         *  List<E> subList(int fromIndex, int toIndex)返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。
         */
        list1.subList(20, 30).clear();//删除指定范围元素
        System.out.println(list1.size());
    }

    private static void test(int i) {   //删除一个长度100的列表索引位为20-30间的元素
        /**
         * nCopies(长度,元素)创建了一个尺寸固定且元素都一样的List,该List长度不能改变，其中的元素也不能改变,即不可变列表
         * 虽然n个元素都是一样的，而且是不可改变的，但java实现的时候只用一个空间，存放一个元素来实现这个功能。如果n足够大的话，可以节省空间和性能。
         * 虽然list.size()返回的是设置的长度,但实际长度是1
         * 使用场景：存放一些不变的信息，比如大家的国籍，性别之类的时候。
         */
        List<Integer> list = Collections.nCopies(100, 0);//创建一个长度固定为100,元素都是0的list,不可变列表
        if (i == 1) {
            List<Integer> list1 = new ArrayList<>(list);//转换成可变列表
            for (int j = 0, size = list1.size(); j < size; j++) {
                if (j >= 20 && j < 30) {
                    list1.remove(j);
                }
            }
            System.out.println(list1.size());
        } else {
            List<Integer> list2 = new ArrayList<>(list);//转换成可变列表
            for (int j = 20; j < 30; j++) {
                if (j < list2.size()) {
                    list2.remove(j);
                }
            }
            System.out.println(list2.size());
        }
    }
}
