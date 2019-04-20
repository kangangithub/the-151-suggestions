package com.the151suggestions.part6.s83;

/**
 * 枚举用法3:在枚举中添加方法,覆盖方法
 * Created by ankang on 2017-08-14.
 */
public enum ColorEnum {
    RED("红色", 1), GREEN("绿色", 2), BLACK("黑色", 3), YELLOW("黄色", 4);

    //成员变量
    private String name;
    private int index;

    //getter setter方法
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //构造方法
    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;

    }

    //普通方法
    public static String getName(int index) {
        /**
         * values()获取枚举类中的所有的元素
         */
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if (colorEnum.getIndex() == index) {
                return colorEnum.getName();
            }
        }
        return null;
    }

    //覆盖方法
    @Override
    public String toString() {
        return "ColorEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
