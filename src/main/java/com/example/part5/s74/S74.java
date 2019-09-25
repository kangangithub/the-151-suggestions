package com.example.part5.s74;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建议74:不推荐使用binarySearch对列表进行检索
 * 使用binarySearch()检索必须先排序
 * Created by ankang on 2017-08-10.
 */
public class S74 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("上海");
                add("北京");
                add("广州");
                add("广州");
                add("深圳");
            }
        };

        int index1 = list.indexOf("广州");    //遍历列表(效率低),返回指定值的第一个索引值(指定值有可能重复)

        /**
         * binarySearch():使用二分法对列表检索(效率高),返回指定值的索引值,使用前必须对列表排序
         * 为什么排序:
         *  不排序无法确定查找时是在小区(比中间值小)还是大区(比中间值大)查找,二分法查找必须先排序
         *  如果列表因为业务等原因不能排序,可以拷贝一个列表再排序,再使用binarySearch()查找指定值
         */
        Collections.sort(list);
        int index2 = Collections.binarySearch(list, "广州");

        System.out.println("索引值(indexOf): " + index1);
        System.out.println("索引值(binarySearch): " + index2);
    }
}
