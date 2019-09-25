package com.example.part6.s88.commonfactorymodel;

import com.example.part6.s88.common.Car;
import com.example.part6.s88.common.FordCar;

/**
 * 客户端
 * Created by ankang on 2017-08-16.
 */
public class Client {
    public static void main(String[] args) {
        Car car = CommonCarFactory.createCar(FordCar.class);
    }
}
