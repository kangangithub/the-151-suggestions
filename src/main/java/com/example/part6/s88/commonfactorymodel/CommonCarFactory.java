package com.example.part6.s88.commonfactorymodel;

import com.example.part6.s88.common.Car;
import lombok.extern.slf4j.Slf4j;

/**
 * 普通工厂
 * Created by ankang on 2017-08-16.
 */
@Slf4j
public class CommonCarFactory {
    public static Car createCar(Class<? extends Car> c) {
        try {
            return c.newInstance();
        } catch (Exception e) {
            log.error("An error occurred when invoking newInstance(), the error message is {}", e);
        }
        return null;
    }
}
