package com.example.part8.s116;

import com.example.part6.s83.SeasonEnum;

/**
 * 建议116:异常只为异常服务
 * Created by Akang on 2017/8/25.
 */
public class S116 {
    public static void main(String[] args) {
        System.out.println(Demo.Contain2(SeasonEnum.class, "spring"));
    }
}
