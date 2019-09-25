package com.example.part4.s52;

/**
 * 建议52:推荐使用String直接量赋值
 * Java为避免产生大量String对象,设计了字符串池(字符串常量池),里面存储字符串对象
 * 其创建机制:
 * 创建字符串时,先检查池中有没有字面值相等的字符串,若有,则不再创建,直接返回池中该对象的引用
 * 若没有,则创建,放在池中,返回对象引用
 *
 * 对象放池中会不会有线程安全问题?
 * 不会. String是不可变对象(final修饰),不可继承不可产生String子类;
 * String方法中如果有String的返回值,会新建一个String对象,不对原对象修改.
 *
 * 对象放池中需要考虑垃圾回收问题吗?
 * 不需要,字符串池特殊,在编译时就决定了其存在JVM中的常量池(其他对象保存在堆内存),垃圾回收器不会进行回收.
 *
 * new String()时不检查字符串池,也不会把对象放到池中
 *
 * intern()会检查当前对象在对象池中是否有字面值相同的引用对象,若有,则不再创建,直接返回池中该对象的引用
 * 若没有,则创建,放在池中,返回对象引用
 *
 * Created by ankang on 2017-08-07.
 */
public class S52 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = s3.intern();
        System.out.println(s1 == s2);   //true
        System.out.println(s1 == s3);   //false
        System.out.println(s1 == s4);   //true
    }
}
