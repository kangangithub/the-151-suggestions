package com.the151suggestions.part5.s76;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议76:集合运算时使用更优雅的方式
 * 可以对两个集合遍历,然后求出并集(add),交集(contains),差集(!contains)等,但步骤繁琐
 * Created by ankang on 2017-08-10.
 */
public class S76 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>() {
            {
                add("A");
                add("B");
                add("C");
                add("A");
                add("B");
            }
        };

        List<String> list2 = new ArrayList<String>() {
            {
                add("D");
                add("E");
                add("C");
                add("A");
                add("C");
            }
        };

//        list1.addAll(list2);  //求list1 和list2的并集    A	B	C	A	B	D	E	C	A	C
//        list1.retainAll(list2);   //求list1 和list2的交集    A	C	A
//        list1.removeAll(list2);   //求list1 和list2的差集(属于list1,不属于list2)    B	B
        /**
         * 求list1 和list2的无重复并集  A	B	C	A	B	D	E
         * 无重复并集:如果集合A B有交集,需要确保并集结果中只有一份交集
         * 注意:
         * 这里不能先求list1 和list2的并集,再转变成HashSet.因为HashSet会把原本A中的重复元素删除     A	B	C	D	E
         */
        list2.removeAll(list1); //求list1 和list2的差集(属于list2,不属于list1)  D E
        list1.addAll(list2);    //求list1 和list2的并集  A	B	C	A	B	D	E

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + "\t");
        }
    }
}
