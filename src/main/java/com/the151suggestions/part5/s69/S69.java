package com.the151suggestions.part5.s69;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 建议69:列表相等只需关心元素数据
 * 判断列表是否相等,只需判断其元素和长度是否相等,与具体的实现类无关
 * 列表只是容器,只要是同种容器(如,都是List),只需确定其所有元素及长度是否相同就可以,不关注具体的容器细节(如ArrayList和LinkedList),
 * 其他集合类型(Set,Map等)与此相同,只关心元素,不关注具体的集合类型.
 * Created by ankang on 2017-08-09.
 */
public class S69 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");

        Vector<String> vector = new Vector<>();
        vector.add("A");

        System.out.println(arrayList.equals(vector));   //true

        /**
         * ArrayList Vector 都继承AbstractList,equals方法由AbstractList实现,
         * 方法中只判断两者是否是List列表(只要实现List接口就行),不关注具体的实现类
         * 源码:
         * public boolean equals(Object o) {
             if (o == this)
             return true;
            //注意:这里只判断是否是List列表(只要实现List接口就行)
             if (!(o instanceof List))
             return false;

             ListIterator<E> e1 = listIterator();
             ListIterator<?> e2 = ((List<?>) o).listIterator();
             while (e1.hasNext() && e2.hasNext()) {
             E o1 = e1.next();
             Object o2 = e2.next();
             if (!(o1==null ? o2==null : o1.equals(o2)))
             return false;
             }
             return !(e1.hasNext() || e2.hasNext());
             }
         */
    }
}
