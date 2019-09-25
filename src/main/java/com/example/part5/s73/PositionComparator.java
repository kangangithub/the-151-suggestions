package com.example.part5.s73;

import java.util.Comparator;

/**
 * 职位比较器
 * Created by ankang on 2017-08-10.
 */
public class PositionComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Employee employee1 = (Employee) o1;
        Employee employee2 = (Employee) o2;
        //职位降序
        return employee1.getPosition().compareTo(employee2.getPosition());
    }
}
