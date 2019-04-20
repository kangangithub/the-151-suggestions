package com.the151suggestions.part5.s75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建议75:集合中的元素必须做到compareTo和equals同步
 *  1.indexOf()依赖equals()查找,binarySearch()依赖compareTo()查找
 *  2.equals()是判断元素是否相等,compareTo()是判断元素在排序中的位置是否相同
 *  因此应该保证当排序位置相同时,其equals()为true,否则,会产生逻辑混乱.
 *
 *  实现compareTo(),就要覆写equals(),且保证两者比较逻辑同步(即equals()根据name判断,compareTo()根据name比较)
 * Created by ankang on 2017-08-10.
 */
public class S75 {
    public static void main(String[] args) {
        List<City> list = new ArrayList<City>() {
            {
                add(new City("021", "上海"));
                add(new City("021", "沪"));
            }
        };

        Collections.sort(list); //先排序,保证列表顺序相对固定

        City city = new City("021", "沪");
        int index1 = list.indexOf(city);
        int index2 = Collections.binarySearch(list, city);

        /**
         * indexOf()是根据equals()判断的,equals()返回true就认为找到符合条件的元素
         * indexOf()查找时,遍历列表,比较equals()返回值,equals()方法是根据code判断,当第一次循环时,equals返回true,indexOf()结束
         * binarySearch()是根据compareTo()返回值判断,返回0认为找到符合条件的元素
         * binarySearch()二分法查找时,根据compareTo()返回值判断,compareTo()根据name排序,name相等返回0,binarySearch()认为找到符合条件的元素
         *
         * 解决:将equals()修改成判断name是否相等
         */
        System.out.println("索引值(indexOf): " + index1);  // 0
        System.out.println("索引值(binarySearch): " + index2); // 1
    }
}
