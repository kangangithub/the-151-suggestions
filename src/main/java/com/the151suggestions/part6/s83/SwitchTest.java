package com.the151suggestions.part6.s83;

/**
 * 枚举用法2:switch case
 * JDK1.7后,switch case : byte short int char String Enum
 * Created by ankang on 2017-08-14.
 */
public class SwitchTest {
    public static void main(String[] args) {
        ColorEnum colorEnum = ColorEnum.BLACK;
        switch (colorEnum) {
            case RED:
                System.out.println("RED");
                break;

            case GREEN:
                System.out.println("GREEN");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            case YELLOW:
                System.out.println("YELLOW");
                break;
            default:
                System.out.println("NULL");
                break;
        }
    }
}
