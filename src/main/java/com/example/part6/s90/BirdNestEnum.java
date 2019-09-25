package com.example.part6.s90;

/**
 * 鸟巢:利用枚举实现工厂模式
 * Created by ankang on 2017-08-16.
 */
public enum BirdNestEnum {
    SPARROW;

    public Bird reproduce() {
        Desc annotation = Sparrow.class.getAnnotation(Desc.class);
        return annotation == null ? new Sparrow() : new Sparrow(annotation.c());
    }
}
