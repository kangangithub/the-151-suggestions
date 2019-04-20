package com.the151suggestions.part1.s7;

/**
 * 建议7: 警惕自增陷阱
 *          i++ : 先赋值后+1
 *          ++i : 先+1后赋值
 * Created by ankang on 2017-03-26.
 */
public class S7 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            /**
             * Java/PHP中 count++是表达式,返回count自加前的值
             * C++中,count++等效于count = count++;
             */
//            count = count++;     先赋值后+1,count的值被重置为0
            count++;
        }
        System.out.println("count=" + count);
    }
}
