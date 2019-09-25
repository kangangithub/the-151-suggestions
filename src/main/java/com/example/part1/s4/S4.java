package com.example.part1.s4;

import java.text.NumberFormat;

/**
 * 建议4: 避免带有可变长参数的方法重载
 * Created by ankang on 2017-03-26.
 */
public class S4 {
    public static void main(String[] args) {
        S4 s4 = new S4();
        //499元货物,打75折
        s4.calPrice(49900, 75);
    }

    //简单折扣计算
    private void calPrice(int price, int discount) {
        float knockdomnPrice = price * discount / 100.0F;
        System.out.println("简单折扣计算后的价格是: " + formateCurrency(knockdomnPrice));
    }

    //复杂折扣计算 折上折(打75折,生日再打9折)
    private void calPrice(int price, int... discounts) {
        float knockdomnPrice = price;
        for (int discount : discounts) {
            knockdomnPrice = knockdomnPrice * discount / 100;
        }
        System.out.println("复杂折扣计算后的价格是: " + formateCurrency(knockdomnPrice));
    }

    //格式化货币形式
    private String formateCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price / 100);
    }
}

