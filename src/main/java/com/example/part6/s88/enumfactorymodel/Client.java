package com.example.part6.s88.enumfactorymodel;

import com.example.part6.s88.common.Car;

/**
 * 客户端
 * Created by ankang on 2017-08-16.
 */
public class Client {
    public static void main(String[] args) {
        Car car = CarFactoryEnum.BUICKCAR.create();
        Car car2 = CarFactoryEnum2.FORDCAR.create();
    }
}
