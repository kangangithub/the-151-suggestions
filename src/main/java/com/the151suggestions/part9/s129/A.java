package com.the151suggestions.part9.s129;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A {
    public static void main(String[] args) {
        String format = SimpleDateFormat.getInstance().format(new Date());
        System.out.println(format);
    }
}
