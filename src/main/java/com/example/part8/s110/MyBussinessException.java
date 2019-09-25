package com.example.part8.s110;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常:JDK1.7,当涉及到反射时,可以extends ReflectiveOperationException,
 * 不必extends Exception 或 extends Throwable
 * Created by Akang on 2017/8/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBussinessException extends ReflectiveOperationException {
    private String Message; //错误信息
}
