package com.example.part6.s90;

/**
 * 鸟类,使用自定义注解
 * Created by ankang on 2017-08-16.
 */
@Desc(c = Desc.ColorEnum.WHITE)
public abstract class Bird {
    public abstract Desc.ColorEnum getColor();
}
