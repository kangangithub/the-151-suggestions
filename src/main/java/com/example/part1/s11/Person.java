package com.example.part1.s11;

import lombok.Data;

import java.io.Serializable;
/**
 * 建议11: 养成良好习惯,显示声明UID(流标识符)
 * Created by ankang on 2017-03-26.
 */
@Data
public class Person implements Serializable {
    /**
     * JVM通过serialVersionUID流标识符来确定类的版本.
     * 刚开始时生产者消费者持有的Person类版本=1.0,生产者Person类变更,
     * 添加年龄属性,变成了版本2.0,由于某种原因消费端的Person还是1.0版,
     * 若隐式定义UID(即不手动创建),则消费端反序列化失败
     * 若显示定义UID(在消费端Person添加与生产端相同的UID,"骗"过JVM),则消费端可以序列化,
     *      但不能读取到新增的业务属性(年龄属性).实现了版本的向上兼容
     */
    //    显示声明UID(流标识符)
    private static final long serialVersionUID = 55799L;

    private String name;
}
