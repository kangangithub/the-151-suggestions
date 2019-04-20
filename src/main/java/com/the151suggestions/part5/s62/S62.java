package com.the151suggestions.part5.s62;


import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

/**
 * 建议62:警惕数组的浅拷贝
 * Arrays.copyOf(oldData, newLen) 浅拷贝
 * 解决方法:
 * 1. 遍历box1每个元素,重新生成Balloon对象,再放入box2数组,见deepClone1();
 * 2. Balloon implements Serializable,调用lang3包下的SerializationUtils.clone(box1);见deepClone2();
 * Created by ankang on 2017-08-08.
 */
public class S62 {
    public static void main(String[] args) {
        shallowClone();
        System.out.println("===========================================================================");
        deepClone1();
        System.out.println("===========================================================================");
        deepClone2();
    }

    public static void shallowClone() {
        Balloon[] box1 = new Balloon[7];
        for (int i = 0; i < 7; i++) {
            box1[i] = new Balloon(i, Color.values()[i]);    //初始化第一个箱子的气球
        }

        Balloon[] box2 = Arrays.copyOf(box1, box1.length);  //第二个箱子气球由第一个箱子拷贝来
        box2[6].setColor(Color.BLUE);    //修改第二个箱子最后一个气球颜色

        for (Balloon balloon : box1) {  //遍历第一个箱子气球
            System.out.println(balloon);
        }
    }

    public static void deepClone1() {
        Balloon[] box1 = new Balloon[7];
        for (int i = 0; i < 7; i++) {
            box1[i] = new Balloon(i, Color.values()[i]);    //初始化第一个箱子的气球
        }
        Balloon[] box2 = new Balloon[7];  //第二个箱子气球

        for (int i = 0; i < 7; i++) {  //遍历box1每个元素,重新生成Balloon对象,再放入box2数组
            box2[i] = new Balloon(i, Color.values()[i]);
        }

        box2[6].setColor(Color.BLUE);    //修改第二个箱子最后一个气球颜色

        for (Balloon balloon : box1) {  //遍历第一个箱子气球
            System.out.println(balloon);
        }
    }

    public static void deepClone2() {
        Balloon[] box1 = new Balloon[7];
        for (int i = 0; i < 7; i++) {
            box1[i] = new Balloon(i, Color.values()[i]);    //初始化第一个箱子的气球
        }

        Balloon[] box2 = SerializationUtils.clone(box1);  //第二个箱子气球由第一个箱子拷贝来
        box2[6].setColor(Color.BLUE);    //修改第二个箱子最后一个气球颜色

        for (Balloon balloon : box1) {  //遍历第一个箱子气球
            System.out.println(balloon);
        }
    }
}
