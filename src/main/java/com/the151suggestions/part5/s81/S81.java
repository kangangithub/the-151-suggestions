package com.the151suggestions.part5.s81;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 建议81:非稳定排序推荐使用List
 * SortedSet接口(TreeSet实现该接口)定义了插入元素时排序,并不保证元素修改后的排序结果
 * TreeSet适用于直接量(基本类型+String)排序
 * List适用于可变量(自定义类型等)排序
 * Created by ankang on 2017-08-14.
 */
public class S81 {
    public static void main(String[] args) {
        SortedSet<Person> sortedSet = new TreeSet<>();
        sortedSet.add(new Person(180));
        sortedSet.add(new Person(175));

        //修改175为185
        sortedSet.first().setHeight(185);

        /**
         * 为保证修改后重排序,重新构建sortedSet,也可以重构掉TreeSet,使用List代替,Collections.sort()排序
         * 注意:这里不能使用new TreeSet<>(sortedSet);该构造方法只是原Set的浅拷贝
         */
        sortedSet = new TreeSet<>(new ArrayList<>(sortedSet));

        for (Person person : sortedSet) {
            System.out.println("身高: " + person.getHeight());
        }
        /**
         * 修改前: 175  180
         * 修改后: 185  180   修改后没有重排序
         * 重构sortedSet后: 180  185
         */
    }

    static class Person implements Comparable<Person> {
        private int height;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Person(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {//按身高排序
            return height - o.height;
        }
    }
}
