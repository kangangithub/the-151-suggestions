package com.the151suggestions.part8.s113;

import com.the151suggestions.part1.s14.Person;

import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 * 建议113:不要在finally块中处理返回值
 *  finally{}中不能处理return, System.exit(0), Runtime.getRuntime().exit(0),否则会产生逻辑错误
 * 注意:方法有正常返回值就认为在方法调用过程中没有产生异常,即便真的产生异常,但如果有正常返回值,
 *      也认为没有产生异常
 * Created by Akang on 2017/8/24.
 */
public class S113 {
    public static void main(String[] args) {
        /**
         * 调用doStuff(int i)返回-1,且不会抛出异常,原因:
         * 1. finally块中return 会覆盖try{}中的return
         *      doStuff(-1):throw new DataFormatException --> catch{throw e;} --> finally{return -1;}
         *      doStuff(100):else{return 100} --> finally{return -1}
         * 2. 调用doStuff()不会抛出异常:
         *      代码中有try{}就标志着运行时会有一个Throwable线程监视该方法的运行,一旦出现异常(doStuff(-1)时),
         *      catch{}会捕获到当前的异常类型(DataFormatException),捕获后直接抛出,当执行到finally{}时,
         *      return -1;告诉JVM该方法返回-1,(有正常返回值,认为没有异常产生),main方法中捕获不到异常
         */
        try {
            System.out.println(doStuff(-1));    // -1
            System.out.println(doStuff(100));   // -1
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 该方法永远返回1,而不会是0或-1,原因:
         * 不会返回0: finally{}执行完毕之后,doJob()已经有返回值(try{return a;}),后续代码不会执行(return 0;)
         * 不会返回-1: 方法是在栈内存中按照"先进后出"的顺序执行,main()调用doJob(),main()先进,main()后执行,doJob()先执行,
         *              执行到return a;时,返回值已经确定是int类型的1,finally{a=-1;}对a重新赋值与doJob()返回值无关
         */
        System.out.println(doJob());    // 1

        /**
         * return person;返回的是引用类型
         * doSomething(0): throw new IOException --> catch{} --> finally{} --> person.setName("王五"); return person;
         * doSomething(1): try{return person;} --> finally{person.setName("李四");} --> try{return person;}
         */
        String name = doSomething(0).getName(); // 王五
        String name1 = doSomething(1).getName();    // 李四
        System.out.println(name + " " + name1);
    }

    private static int doJob() {
        int a = 1;
        try {
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = -1;
        }
        return 0;
    }

    private static Person doSomething(int i) {
        Person person = new Person();
        person.setName("张三");
        try {
            if (i == 0) {
                throw new IOException("try{}中产生异常");
            }
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            person.setName("李四");
        }
        person.setName("王五");
        return person;
    }

    private static int doStuff(int i) {
        try {
            if (i < 0) {
                throw new DataFormatException("数据格式错误");
            } else {
                return i;
            }
        } catch (DataFormatException e) {
            throw e;
        } finally {
            return -1;
        }
    }
}
