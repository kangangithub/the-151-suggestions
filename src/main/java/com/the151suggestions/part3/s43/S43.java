package com.the151suggestions.part3.s43;

/**
 * 建议43:避免对象的浅拷贝(Shadow Clone 影子拷贝,存在对象属性拷贝不彻底的问题)
 * 一个类实现Cloneable接口表示它具备了被拷贝的能力,如果再覆写clone(),就具备完全拷贝能力.
 * 拷贝是在内存中进行的,性能比new 对象高.
 * 浅拷贝只是Java提供的一种简单的拷贝机制,不便于直接使用.
 * Created by ankang on 2017-08-04.
 */
public class S43 {
    public static void main(String[] args) {
        Person person1 = new Person("父亲");
        Person person2 = new Person("大儿子", person1);
        Person person3 = person2.clone();//小儿子信息由大儿子拷贝而来
        person3.setName("小儿子");

        //小儿子认干爹
        person3.getFather().setName("干爹");
        System.out.println(person2.getName()+"的父亲是"+person2.getFather().getName());
        System.out.println(person3.getName()+"的父亲是"+person3.getFather().getName());

    }
}
