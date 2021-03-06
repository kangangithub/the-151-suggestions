package com.example.part3.s50;

import java.io.IOException;

/**
 * Created by ankang on 2017-08-07.
 */
public class TestPackageInfo {
    public static void main(String[] args) {
        //1
        Package p = Package.getPackage("com.jyz.study.jdk.annotation");
        if (p != null && p.isAnnotationPresent(JyzTargetPackage.class)) {
            JyzTargetPackage nav = p.getAnnotation(JyzTargetPackage.class);
            if (nav != null) {
                System.out.println("package version:" + nav.version());
            }
        }

        //2
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.common();

        //泛型也能很好的工作，在pakcage-info.java里定义的类和普通类没什么区别
        PackageInfoGeneric<Exception> packageInfoGeneric = new PackageInfoGeneric<Exception>();
        packageInfoGeneric.set(new IOException("device io"));
        packageInfoGeneric.common();


        Sub sub = new Sub();
        sub.test();

        System.out.println(PackageConstants.ERROE_CODE);
    }
}

class Sub implements packageInfoInteger {

    @Override
    public void test() {
        System.out.println("sub");
    }
}
