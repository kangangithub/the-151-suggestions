package com.the151suggestions.part1.s14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 建议14: 使用序列化的私有方法巧妙解决部分属性持久化问题
 * 员工类
 * Created by ankang on 2017-03-26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    //显示声明UID(流标识符)
    private static final long serialVersionUID = 1637613L;

    private String name;

    private Salary salary;

    /**
     * 添加自定义的序列化/反序列化方法,以实现绩效工资的隐藏,但Person类不能实现分布式部署,Person类计算的可能性不大,即使为性能考虑,Person类实现分布式部署的意义不大.
     * 序列化回调:
     * Java调用ObjectOutputStream类把一个对象转化成流数据时,会通过反射检查被序列化的类是否有writeObject()方法,
     * 并检查其是否符合私有 无返回值(private void)的特性,若有,则会委托该方法进行对象序列化,
     * 若没有,则由ObjectOutputStream按照默认规则继续序列化.
     * 同样,在从流数据恢复成实例对象时,也会检查一个私有的 无返回值的private void readObject()方法,如果有,则通过该方法读取属性值.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();    //告知JVM以默认规则写入对象,写在方法第一句
        objectOutputStream.writeInt(salary.getBasePay());   //写入基本工资属性
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();  //告知JVM以默认规则读取对象,写在方法第一句
        salary = new Salary(objectInputStream.readInt(), 0);    //读取基本工资属性
    }
}
