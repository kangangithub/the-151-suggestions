package com.the151suggestions.part6.s83;

/**
 * 枚举用法5:使用接口组织枚举
 * Created by ankang on 2017-08-14.
 */
public interface Food {
    enum CoffeeEnum implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum DessertEnum implements Food {
        FRUIT, CAKE, GELATO
    }
}
