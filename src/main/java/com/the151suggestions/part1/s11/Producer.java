package com.the151suggestions.part1.s11;

/**
 * Created by ankang on 2017-03-26.
 */
public class Producer {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("混世魔王");
        //序列化至硬盘
        SerializationUtils.writeObject(person);
    }
}
