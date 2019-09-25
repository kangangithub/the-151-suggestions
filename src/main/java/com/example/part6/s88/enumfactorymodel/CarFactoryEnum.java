package com.example.part6.s88.enumfactorymodel;

import com.example.part6.s88.common.BuickCar;
import com.example.part6.s88.common.Car;
import com.example.part6.s88.common.FordCar;

/**
 * 汽车枚举
 * Created by ankang on 2017-08-16.
 */
public enum CarFactoryEnum {
    FORDCAR, BUICKCAR;

    /**
     * 非静态方法,只有通过具体的枚举项才能访问
     * @return
     */
    public Car create() {
        switch (this) {
            case FORDCAR:
                return new FordCar();//这里不能跟break,return在前,break执行不到
            case BUICKCAR:
                return new BuickCar();
            default:
                throw new AssertionError("Illegal Arguments");
        }
    }
}
