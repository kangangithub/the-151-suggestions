package com.the151suggestions.part6.s90;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Java5.0定义了4个元注解:
 *   1.@Target；说明自定义注解可以用在什么地方，其ElementType取值有：
 *       1. CONSTRUCTOR:用于描述构造器 
         2. FIELD:用于描述域 
         3. LOCAL_VARIABLE:用于描述局部变量 
         4. METHOD:用于描述方法 
         5. PACKAGE:用于描述包 
         6. PARAMETER:用于描述参数 
         7. TYPE:用于描述类、接口(包括注解类型) 或enum声明
         使用示例：@Target(ElementType.FIELD) 
     2.@Retention；描述自定义注解的生命周期，其RetentionPoicy取值有： 
         1. SOURCE:在源文件中有效 
         2. CLASS:在class文件中有效 
         3. RUNTIME:在运行时有效
         使用示例：@Retention(RetentionPolicy.RUNTIME)
     3.@Documented；表示自定义注解可以被javadoc之类的工具文档化，没有成员。
     4.@Inherited。表示该注解加在父类上会被所有子类自动继承
 * Created by ankang on 2017-08-16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Desc {
    enum ColorEnum {
        WHITE, GRAYISH, YELLOW
    }

    ColorEnum c() default ColorEnum.WHITE;
}
