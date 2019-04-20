package com.the151suggestions.part3.s44;

import org.apache.commons.lang3.SerializationUtils;

/**
 * 建议44:推荐使用序列化实现对象的拷贝
 * 采用序列化方式拷贝,使用commons-lang3工具包中的SerializationUtils类,要求被克隆对象实现Serializable接口.
 * Created by ankang on 2017-08-07.
 */
public class S44 {
    public static void main(String[] args) {
        Person person1 = new Person("父亲");
        Person person2 = new Person("大儿子", person1);
        Person person3 = SerializationUtils.clone(person2);//小儿子信息由大儿子拷贝而来
        person3.setName("小儿子");

        //小儿子认干爹
        person3.getFather().setName("干爹");
        System.out.println(person2.getName()+"的父亲是"+person2.getFather().getName());
        System.out.println(person3.getName() + "的父亲是" + person3.getFather().getName());
    }
}
