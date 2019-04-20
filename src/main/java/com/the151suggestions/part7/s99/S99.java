package com.the151suggestions.part7.s99;

/**
 * 建议99:严格限定泛型类型采用多重界限
 * 例:对工资低于2500的上班族且站立的乘客车费打8折
 * Created by Akang on 2017/8/22.
 */
public class S99 {
    public static void main(String[] args) {
        discount(new Me());
    }

    // & 设定多重边界,指定泛型T必须是Staff和Passenger的共有子类型
    private static <T extends Staff & Passenger> void discount(T t) {
        if (t.getSalary() < 2500 && t.isStanding()) {
            System.out.println("恭喜,您的车票打8折");
        }
    }
}
