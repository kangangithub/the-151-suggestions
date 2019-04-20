package com.the151suggestions.part3.s44;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 采用序列化方式拷贝,使用commons-lang3工具包中的SerializationUtils类,要求被克隆对象实现Serializable接口.
 * Created by ankang on 2017-08-07.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Person implements Serializable{
    private String name;
    private Person father;

    public Person(String name) {
            this.name = name;
        }
}
