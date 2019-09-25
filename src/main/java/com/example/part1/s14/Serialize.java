package com.example.part1.s14;

import com.example.part1.s11.SerializationUtils;

/**
 * 序列化
 * Created by ankang on 2017-03-26.
 */
public class Serialize {
    public static void main(String[] args) {
        Salary salary = new Salary(1000, 2500);
        Person person = new Person("张三", salary);
        //持久化到硬盘
        SerializationUtils.writeObject(person);
    }
}
