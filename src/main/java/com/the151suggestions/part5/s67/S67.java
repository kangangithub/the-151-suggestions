package com.the151suggestions.part5.s67;

import com.the151suggestions.common.Constant;

import java.util.*;

/**
 * 建议67:不同列表选择不同的遍历方法
 * ArrayList实现了RandomAccess接口(随机存取接口),表示ArrayList可以随机存取.也就是说,ArrayList中的元素
 * 之间没有关联,即两个位置相邻的元素之间没有相互依赖和索引关系,可以随机访问存取.
 * LinkedList是有序存取的,是一个双向链表,每个数据节点中都有3个数据项:
 * 前节点的引用(Previous Node),本节点元素(Node Element),后节点引用(Next Node),
 * 也就是说在LinkedList中元素之间是有关联的.
 * Created by ankang on 2017-08-08.
 */
public class S67 {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testArrayList() {
        List<Integer> list = new ArrayList<>(Constant.LIST_SIZE);   //场景明确,直接指定长度,提高效率
        for (int i = 0; i < Constant.LIST_SIZE; i++) {
            list.add(new Random().nextInt(100)); //随机选取0-100的整数存入列表
        }
        long begin = System.currentTimeMillis();
        System.out.println("平均数是: " + averge(list));
        System.out.println("任务耗时: " + (System.currentTimeMillis() - begin) + " 毫秒");
    }

    private static void testLinkedList() {
        List<Integer> list = new LinkedList<>();    //LinkedList没有指定长度的有参构造
        for (int i = 0; i < Constant.LIST_SIZE; i++) {
            list.add(new Random().nextInt(100)); //随机选取0-100的整数存入列表
        }
        long begin = System.currentTimeMillis();
        System.out.println("平均数是: " + averge(list));
        System.out.println("任务耗时: " + (System.currentTimeMillis() - begin) + " 毫秒");
    }

    private static double averge(List<Integer> list) {
        int sum = 0;
        if (list instanceof RandomAccess) {
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
        } else {
            /**
             * foreach循环是迭代器的变形用法,等价于
             * for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
             *    sum += iterator.next();
             *  }
             *  迭代器是23种设计模式的一种,提供一种方法访问一个容器对象中的各个元素,同时又无须暴露该对象的内部细节.
             *  也就是说foreach循环时:
             *  1.创建一个迭代器容器
             *  2.屏蔽内部遍历细节
             *  3.对外提供hasNext(),next()等方法
             *  这等于强制性的给元素添加关联关系,所以ArrayList用foreach遍历耗时较长
             */
            for (Integer integer : list) {
                sum += integer;
            }
        }
        return sum / list.size();
    }


}
