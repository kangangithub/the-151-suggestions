package com.the151suggestions.part2.s30;

import java.util.Random;

/**
 * 建议30: 不要随便设置随机种子
 * Created by ankang on 2017-03-28.
 */
public class S30 {
    public static void main(String[] args) {
        seed();
        noSeed();
        test();
        /**
         * 获取随机数方法:
         *  1. new Random();
         *  2. new Random(seed); //同一台机器,不管运行多少次,随机数固定
         *  3. Math.random();
         * 随机数的产生取决于种子,两个规则:
         *  1.种子不同,产生不同随机数
         *  2.种子相同,即使实例不同也产生相同随机数
         *  注:
         *  Math.random()与new Random().nextDouble()一样
         */
    }

    private static void test() {
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次: " + Math.random());
        }
    }

    private static void noSeed() {
        Random random = new Random();
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次: " + random.nextInt());
        }
    }

    private static void seed() {
        Random random = new Random(1000);
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次: " + random.nextInt());
        }
    }

}
