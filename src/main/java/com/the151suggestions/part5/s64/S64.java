package com.the151suggestions.part5.s64;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 建议64:多种最值算法,适时选择
 * 最值计算使用集合最简单,使用数组效率最高
 * JDK1.8:IDEA中需指定jdk的Language level为8,Java 8 允许使用 :: 关键字来传递方法或者构造函数引用.
 *   int[] data = {1,2,3,4,5,6,7,8,9,10};
     // To boxed array
     Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
     Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );
     // To boxed list
     List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
     List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
 * Created by ankang on 2017-08-08.
 */
public class S64 {
    static int[] ints = {1, 9, 6, 7, 23, 5, 4, 9};

    public static void main(String[] args) {
        System.out.println(getMAX1(ints));
        System.out.println(getMAX2(ints));
        System.out.println(getSecond1(ints));
        System.out.println(getSecond2(ints));
        System.out.println(getSecond3(ints));
    }

    private static int getSecond1(int[] ints) {  //获取第二最值
        List<Integer> list = Arrays.asList(convert(ints));
        TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
        return treeSet.lower(treeSet.last());   //返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null
    }

    private static int getSecond2(int[] ints) {  //获取第二最值
        /**
         * JDK1.8:IDEA中需指定jdk的Language level为8,setting->Compiler->Java Compiler 设置相应Module的byte code version为1.8.
         * Java 8 允许使用 :: 关键字来传递方法或者构造函数引用.
         * int[]转化成Integer[]
         */
        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);
//        Integer[] integers = IntStream.of(ints).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(integers);
        TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
        return treeSet.lower(treeSet.last());   //返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null
    }

    /**
     * JDK1.8:IDEA中需指定jdk的Language level为8,setting->Compiler->Java Compiler 设置相应Module的byte code version为1.8
     * int[]转换成List<Integer>
     * @param ints
     * @return
     */
    private static int getSecond3(int[] ints) {  //获取第二最值
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
//        List<Integer> list = IntStream.of(ints).boxed().collect(Collectors.toList());
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        return treeSet.lower(treeSet.last());   //返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null
    }

    private static Integer[] convert(int[] ints) {//int[] Integer[]转换
        Integer[] integers = new Integer[ints.length];
        for (int i = 0; i < ints.length; i++) {
            integers[i] = ints[i];
        }
        return integers;
    }

    private static int getMAX2(int[] ints) {
        /**
         * 这里ints.clone()是因为,数组是对象,不clone()就改变了原有数组的顺序,除非顺序无所谓,返回克隆数组的最值
         */
        int[] clone = ints.clone();
        Arrays.sort(clone);  //先排序
        return clone[ints.length - 1];   //再选最大值,一定返回克隆数组的值
    }

    private static int getMAX1(int[] ints) {
        int max = ints[0];
        for (int i : ints) {
            max = max > i ? max : i;
        }
        return max;
    }
}
