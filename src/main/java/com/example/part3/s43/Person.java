package com.example.part3.s43;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by ankang on 2017-08-04.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Person implements Cloneable {
    private String name;
    private Person father;

    public Person(String name) {
        this.name = name;
    }

    /**
     * 该clone()最终来自于Object类,是一个本地方法，这意味着它是由 c 或 c++ 或 其他本地语言实现的,该方法有缺陷,它提供的是浅拷贝,拷贝规则:
     *  1. 基本类型拷贝值
     *  2. 对象类型拷贝引用,即拷贝对象和原对象共享该实例变量,不受访问权限的限制(一个private修饰的变量被两个不同的的实例对象访问,突破了Java访问权限的限制)
     *  3. String 拷贝引用,但修改时会从字符串池中重新生成新字符串,这里可以认为String是基本类型
     * @return
     */
    @Override
    protected Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
            person.setFather(new Person(person.getFather().getName()));
        } catch (CloneNotSupportedException e) {
            log.error("An error occurred when cloning the object, the error message is {}", e);
        }
        return person;
    }
}
