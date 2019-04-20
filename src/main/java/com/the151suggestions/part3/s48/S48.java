package com.the151suggestions.part3.s48;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议48:覆写equals方法必须覆写hashCode方法
 * 使用EqualsBuilder、HashCodeBuilder和CompareToBuilder重写equals、hashCode、compareTo方法
 * Created by ankang on 2017-08-07.
 */
public class S48 {
    public static void main(String[] args) {
        Student studentOne = new Student();
        studentOne.setName("张柏芝");
        studentOne.setPassword("123456");
        studentOne.setAge(34);
        List<Student> listOne = new ArrayList<Student>();
        listOne.add(studentOne);
        Teacher teacherOne = new Teacher();
        teacherOne.setName("陈冠希");
        teacherOne.setAge(33);
        teacherOne.setStudent(listOne);

        Student studentTwo = new Student();
        studentTwo.setName("张柏芝");
        studentTwo.setPassword("123456");
        studentTwo.setAge(34);
        List<Student> listTwo = new ArrayList<Student>();
        listTwo.add(studentTwo);
        Teacher teacherTwo = new Teacher();
        teacherTwo.setName("陈冠希");
        teacherTwo.setAge(33);
        teacherTwo.setStudent(listTwo);

        Student studentThree = new Student();
        studentThree.setName("张柏芝00");
        studentThree.setPassword("123456");
        studentThree.setAge(35);
        List<Student> listThree = new ArrayList<Student>();
        listThree.add(studentThree);
        Teacher teacherThree = new Teacher();
        teacherThree.setName("陈冠希00");
        teacherThree.setAge(38);
        teacherThree.setStudent(listThree);

        System.out.println(teacherOne == teacherTwo); //false
        System.out.println(teacherOne.equals(teacherTwo));  //true
        /**
         * 通过 x.compareTo(y) 来“比较x和y的大小”。
         * 若返回“负数”，意味着“x比y小”；
         * 返回“零”，意味着“x等于y”；
         * 返回“正数”，意味着“x大于y”。
         */
        System.out.println(teacherOne.compareTo(teacherThree)); //-2
        System.out.println(teacherOne);
        System.out.println(studentOne);
    }
}
