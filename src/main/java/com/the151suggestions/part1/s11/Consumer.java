package com.the151suggestions.part1.s11;

/**
 * Created by ankang on 2017-03-26.
 */
public class Consumer {
    public static void main(String[] args) {
        Person person = (Person) SerializationUtils.readObject();
        System.out.println("name=" + person.getName());
    }
}
