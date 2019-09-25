package com.example.part3.s45;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 建议45:覆写equals方法时不要识别不出自己
 * Created by ankang on 2017-08-04.
 */
public class S45 {
    public static void main(String[] args) {
        Person person1 = new Person("aaa", 12);
        Person person2 = new Person("aaa", 12);
        Person person3 = new Person("bbb", 12);
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));
    }
}

@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 覆盖equals()时总是要覆盖hashCode()方法
     * equals方法实现了等价关系（equivalence relation）:
     * 自反性（reflexive）—>x != null && x.equals(x) == true
     * 对称性（symmetric）—>if(x != null && x.equals(y))可以推出y.equals(x)
     * 传递性（transitive）—>x != null && x.equals(y) == true && y.equals(z)可以推出x.equals(z)
     * 一致性（consistent）—>对于非null的x、y，只要equals的比较操作在对象中所用的信息没有被修改，多次调用equals返回的一致是true或者一致是false
     * 对于非null的x，x.equals(null)返回值一定是false
     * @return
     */
    @Override
    public int hashCode() {//尽量保证不同对象有不同的哈希码值
        return this.name.hashCode() + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//判断obj和this是否是同一对象
            return true;
        }
        if (obj == null) {//判断obj是否为null
            return false;
        }
        if (this.getClass() != obj.getClass()) {//判断两对象实际类型是否相同
            return false;
        }
        Person person = (Person) obj;
        if (this.name.equals(person.name) && this.age == person.age) {//判断属性是否相同(根据具体业务判断哪些属性需要比较),对象类型用equals(),基本类型用==
            return true;
        } else {
            return false;
        }
    }
}
