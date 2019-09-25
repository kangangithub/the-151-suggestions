package com.example.part6.s91;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义访问注解,不同级别访问不同资源
 * Created by ankang on 2017-08-16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Access {
    IdentifierEnum level() default IdentifierEnum.ADMIN;    //默认管理员才能访问
}
