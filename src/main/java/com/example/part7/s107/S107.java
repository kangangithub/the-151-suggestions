package com.example.part7.s107;

/**
 * 建议107:使用反射增加装饰模式的普适性
 * Created by Akang on 2017/8/23.
 */
public class S107 {
    public static void main(String[] args) {
        //定义Jerry
        Animal jerry = new Rat();
        //为Jerry增加飞行能力
        jerry = new DecorateAnimal(jerry, FlyFeature.class);
        //为Jerry增加钻地能力
        jerry = new DecorateAnimal(jerry, DigFeature.class);
        //Jerry戏耍Tom
        jerry.doStuff();
    }
}
