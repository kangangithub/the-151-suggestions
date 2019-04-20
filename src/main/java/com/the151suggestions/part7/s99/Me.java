package com.the151suggestions.part7.s99;

/**
 * "我"
 * Created by Akang on 2017/8/22.
 */
public class Me implements Staff, Passenger {
    @Override
    public boolean isStanding() {
        return true;
    }

    @Override
    public int getSalary() {
        return 2000;
    }
}
