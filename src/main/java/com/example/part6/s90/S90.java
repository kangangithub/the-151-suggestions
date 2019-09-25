package com.example.part6.s90;

/**
 * 客户端
 * @Inherited 表示@Desc加在父类Bird上,Bird的所有子类都会自动从Bird继承@Desc,不需要显式声明
 * @Inherited 弊大于利,尽量少用
 * Created by ankang on 2017-08-16.
 */
public class S90 {
    public static void main(String[] args) {
        Bird bird = BirdNestEnum.SPARROW.reproduce();
        System.out.println("Bird's color is " + bird.getColor());   //Bird's color is WHITE
    }
}
