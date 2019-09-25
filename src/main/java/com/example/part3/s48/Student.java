package com.example.part3.s48;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.lang.reflect.Field;

/**
 * 使用EqualsBuilder、HashCodeBuilder、CompareToBuilder、ToStringBuilder重写equals、hashCode、compareTo、toString方法
 * Created by ankang on 2017-08-07.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private String password;    //toString()时密码不显示
    private int age;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * 类里有名为password这样的属性,一般情况下,是不想让toString输入的, 但用反射默认情况下是会输出的. 这怎么办呢?
     * ReflectionToStringBuilder有一个扩展: 通过子类,覆盖其accept方法来加以筛选.
     * com.example.part3.s48.Student@3d494fbf[name=张柏芝,age=34,student=<null>]
     * @return
     */
    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this) {
            @Override
            protected boolean accept(Field field) {
                return super.accept(field) && !field.getName().equals("password");
            }
        }).toString();
    }
}
