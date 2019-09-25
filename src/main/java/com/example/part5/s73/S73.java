package com.example.part5.s73;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建议73:使用Comparator进行排序
 * Created by ankang on 2017-08-09.
 */
public class S73 {
    private static List<Employee> list = new ArrayList<Employee>() {
        {
            add(new Employee("1001", "张三", PositionEnum.BOSS));
            add(new Employee("1002", "李四", PositionEnum.MANAGER));
            add(new Employee("1003", "王五", PositionEnum.MANAGER));
            add(new Employee("1004", "赵六", PositionEnum.STAFF));
            add(new Employee("1005", "马七", PositionEnum.STAFF));
            add(new Employee("1006", "钱八", PositionEnum.STAFF));
        }
    };

    public static void main(String[] args) {
        test(1);
        test(2);
    }

    public static void test(int i) {
        if (i == 1) {
            Collections.sort(list);
            traversal();
        } else {
            Collections.sort(list, new PositionComparator());//按照职位降序排序
            traversal();
        }
    }

    /**
     * 遍历方法,因为是ArrayList,所以采用fori循环
     */
    public static void traversal() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
