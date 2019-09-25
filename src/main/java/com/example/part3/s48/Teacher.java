package com.example.part3.s48;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.*;

import java.util.List;

/**
 * 使用EqualsBuilder、HashCodeBuilder、CompareToBuilder、ToStringBuilder重写equals、hashCode、compareTo、toString方法
 * 为什么要使用ToStringBuilder？
 * 系统中一般都要打印日志的，因为所有实体的toString()方法 都用的是简单的"+"，因为每"＋" 一个就会 new 一个 String 对象，
 * 这样如果系统内存小的话会暴内存（前提系统实体比较多）。使用ToStringBuilder就可以避免暴内存这种问题的。
 * Created by ankang on 2017-08-07.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Comparable {
    private String name;
    private int age;
    private List<Student> student;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * 使用CompareToBuilder重写compareTo方法
     * 通过 x.compareTo(y) 来“比较x和y的大小”。
     * 若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
     *
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }

    /**
     * ToStringStyle参数说明：
     1. DEFAULT_STYLE(默认)
     com.example.part3.s48.Teacher@12edcd21[name=陈冠希,age=33,student=[Student(name=张柏芝, age=34)]]
     2. MULTI_LINE_STYLE
     com.example.part3.s48.Teacher@12edcd21[
         name=陈冠希
         age=33
         student=[Student(name=张柏芝, age=34)]
     ]
     3. NO_FIELD_NAMES_STYLE
     com.example.part3.s48.Teacher@12edcd21[陈冠希,33,[Student(name=张柏芝, age=34)]]
     4. SHORT_PREFIX_STYLE (即截去了包名）
     Teacher[name=陈冠希,age=33,student=[Student(name=张柏芝, age=34)]]
     5. SIMPLE_STYLE
     陈冠希,33,[Student(name=张柏芝, age=34)]
     6. NO_CLASS_NAME_STYLE(无类名)
     [name=陈冠希,age=33,student=[Student(name=张柏芝, age=34)]]
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
