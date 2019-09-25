package com.example.part1.s14;

import com.example.part1.s11.SerializationUtils;

/**
 * 反序列化
 * Created by ankang on 2017-03-26.
 */
public class Deserialize {
    public static void main(String[] args) {
        Person person = (Person) SerializationUtils.readObject();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("姓名:" + person.getName());
        stringBuilder.append("\t 基本工资:" + person.getSalary().getBasePay());
        stringBuilder.append("\t 绩效工资:" + person.getSalary().getBonus());
        System.out.println(stringBuilder);
    }
}
