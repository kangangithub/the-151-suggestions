package com.example.part5.s72;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建议72:生成子列表后不要再操作原列表
 * subList生成子列表后,保持原列表的只读状态
 * Created by ankang on 2017-08-09.
 */
public class S72 {
    public static void main(String[] args) {
        test2();
        test1();
    }

    private static void test1() {
        List<String> list = new ArrayList<String>() {
            {
                add("A");
                add("B");
                add("C");
            }
        };
        List<String> list1 = list.subList(0, 2);
        list.add("D");  //添加元素至原列表,不报错,修改计数器在生成子列表时的基础上+1
        System.out.println("原列表长度: " + list.size());
        System.out.println("子列表长度: " + list1.size());   //并发修改异常java.util.ConcurrentModificationException
        /**
         * subList()返回一个SubList对象,该对象的其他方法,get(),set(),add()等方法,也会检查修改次数,不一致就抛出并发修改异常
         * SubList的size()源码:
         * public int size() {
         checkForComodification();
         return size;
         }
         private void checkForComodification() {
         //判断当前修改计数器与子列表生成时是否一致
         if (this.modCount != l.modCount)
         throw new ConcurrentModificationException();
         }
         */
    }

    /**
     * 一个List可以有多个子列表(视图),只要生成的子列表多于1个,任何子列表都不能修改,否则抛出并发修改异常
     */
    private static void test2() {
        List<String> list = new ArrayList<String>() {
            {
                add("A");
                add("B");
                add("C");
            }
        };
        List<String> subList = list.subList(0, 2);
        /**
         * 通过Collections.unmodifiableList(list)设置列表为只读状态
         * 试图修改返回的列表（不管是直接修改还是通过其迭代器进行修改）将导致抛出 UnsupportedOperationException。
         * 场景:我生成一个List,需调用其他同事的共享方法,但List某些元素不能修改-->subList()和unmodifiableList()配合使用(防御式编程)
         */
        list = Collections.unmodifiableList(list);
        //对原列表进行只读操作
        doRead(list);
        //对子列表进行读写操作
        doReadAndWrite(subList);
    }

    private static void doReadAndWrite(List<String> subList) {
        subList.add("D");
        System.out.println(subList.get(2));
    }

    private static void doRead(List<String> list) {
        System.out.println(list.get(0));
    }
}
