package com.the151suggestions.part5.s70;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议70:子列表只是原列表的一个视图
 * subList方法本身并没有生成一个数组/链表,即子列表只是原列表的一个视图(View),所有对子列表的操作都反映在了原列表上.
 *
 * Created by ankang on 2017-08-09.
 */
public class S70 {
    public static void main(String[] args) {
        testSubString();
        testSubList();
        /**
         * subList方法是AbstractList实现的会根据是否支持随机存取来提供不同的SubList实现方式.
         * 随机存取使用频率高,RandomAccessSubList是SubList的子类
         * subList方法返回的SubList类(包括RandomAccessSubList)是AbstractList子类,所有方法如
         * get() set(),add(),remove()等都是在原始列表上进行操作,subList方法本身并没有生成一个
         * 数组/链表,即子列表只是原列表的一个视图(View),所有的操作都反映在了原列表上.
         * public List<E> subList(int fromIndex, int toIndex) {
             return (this instanceof RandomAccess ?
             new RandomAccessSubList<>(this, fromIndex, toIndex) :
             new SubList<>(this, fromIndex, toIndex));
            }
         */
    }

    private static void testSubList() {
        List<String> list1 = new ArrayList<String>() {
            {
                add("A");
                add("B");
            }
        };

        List<String> list2 = new ArrayList<String>(list1);

        List<String> list3 = list1.subList(0, list1.size());
        list3.add("C");

        System.out.println(list1.equals(list2));    //false
        System.out.println(list1.equals(list3));    //true
        //遍历原列表
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i)); // ABC 对子列表的添加操作作用在了原始列表list1上
        }
    }

    private static void testSubString() {
        String string1 = "AB";
        String string2 = new String(string1);
        String string3 = string1.substring(0) + "C";
        System.out.println(string1.equals(string2));    //true
        System.out.println(string1.equals(string3));    //false
    }


}
