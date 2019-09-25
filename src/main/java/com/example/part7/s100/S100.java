package com.example.part7.s100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 建议100:数组的真实类型必须是泛型类型的子类型
 * Created by Akang on 2017/8/22.
 */
public class S100 {
    public static void main(String[] args) {
        //List<String> list1 = Arrays.asList("A", "B");
        //for (String string : toArray1(list1)) {
        List<String> list2 = Arrays.asList("A", "B");
        for (String string : toArray2(list2, String.class)) {
            System.out.println(string);
        }
    }

    /**
     * ClassCastException:类型转换异常
     * 1.Why Object[]不能强转String[]
     * 数组只有保证所有元素类型与期望类型有父子关系才能转换,Object[]只能保证数组内元素是Object类型,
     * 不能确保都是String类型的父/子类型
     * 2.Why main()抛异常,不是toArray1()
     * 泛型在编译期擦除, T[] t = (T[]) new Object[list.size()];等价于 Object[] t = (Object[]) new Object[list.size()];
     * for (String string : toArray1(list1)) 等价于 for (String string : (String[])toArray1(list1))
     *
     * @param list
     * @param <T>
     * @return
     */
    private static <T> T[] toArray1(List<T> list) {
        T[] t = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            t[i] = list.get(i);
        }
        return t;
    }

    private static <T> T[] toArray2(List<T> list, Class<T> clazz) {
        //声明并初始化一个T类型的数组
        T[] t = (T[]) Array.newInstance(clazz, list.size());
        for (int i = 0; i < list.size(); i++) {
            t[i] = list.get(i);
        }
        return t;
    }
}
