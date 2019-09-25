package com.example.part3.s39;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议39:使用匿名类的构造函数
 *  匿名类虽然没有名字,但也有构造方法(构造代码块).
 * Created by ankang on 2017-08-04.
 */
public class S39 {
    /**
     * List<Integer> list2 = new ArrayList<Integer>(){}; 等价于
     *  class Sub extends ArrayList<Integer>{}
     *  List list2 = new Sub();
     * List<Integer> list3 = new ArrayList<Integer>(){{}};  等价于
     *  class Sub extends ArrayList<Integer>{
     *      {}
     *  }
     *  List list3 = new Sub();
     * List<Integer> list4 = new ArrayList<Integer>(){{}{}{}{}}; 等价于
     *  class Sub extends ArrayList<Integer>{
     *      {}
     *      {}
     *      {}
     *      {}
     *  }
     *  List list4 = new Sub();
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>(){};
        List<Integer> list3 = new ArrayList<Integer>(){{}};
        List<Integer> list4 = new ArrayList<Integer>(){{}{}{}{}};
        System.out.println(list1.getClass());   //class java.util.ArrayList
        System.out.println(list2.getClass());   //class com.example.part3.s39.S39$1
        System.out.println(list3.getClass());   //class com.example.part3.s39.S39$2
        System.out.println(list4.getClass());   //class com.example.part3.s39.S39$3
    }
}
