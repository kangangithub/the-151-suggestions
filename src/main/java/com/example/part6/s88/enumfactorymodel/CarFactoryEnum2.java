package com.example.part6.s88.enumfactorymodel;

import com.example.part6.s88.common.BuickCar;
import com.example.part6.s88.common.Car;
import com.example.part6.s88.common.FordCar;

/**
 * 汽车枚举2,提供抽象方法,即抽象枚举,需要每个枚举项自行实现该抽象方法
 * Created by ankang on 2017-08-16.
 */
public enum CarFactoryEnum2 {
    FORDCAR {
        @Override
        public Car create() {
            return new FordCar();
        }
    },
    BUICKCAR {
        @Override
        public Car create() {
            return new BuickCar();
        }
    };

    /**
     * 非静态方法,只有通过具体的枚举项才能访问
     *
     * @return
     */
    public abstract Car create();
}
