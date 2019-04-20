package com.the151suggestions.part6.s90;

import lombok.Getter;
import lombok.Setter;

/**
 * 麻雀
 * Created by ankang on 2017-08-16.
 */
public class Sparrow extends Bird {
    @Setter
    @Getter
    private Desc.ColorEnum colorEnum;

    public Sparrow() {
        colorEnum = Desc.ColorEnum.GRAYISH;
    }

    public Sparrow(Desc.ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    @Override
    public Desc.ColorEnum getColor() {
        return colorEnum;
    }
}
