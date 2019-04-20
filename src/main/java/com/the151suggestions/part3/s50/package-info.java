/**
 * package-info不是平常类，其作用有三个:
 * 1、为标注在包上Annotation提供便利；
 * 2、声明包的私有类和常量；
 * 3、提供包的整体注释说明。
 */
@JyzTargetPackage(version="1.0")  
package com.the151suggestions.part3.s50;
  
class PackageInfo{  
    public void common(){  
        System.out.println("sa");  
    }  
}  
  
class PackageInfoGeneric<T extends Throwable>{  
    private T obj;  
    public void set(T obj){  
        this.obj = obj;  
    }  
    public void common(){  
        System.out.println(obj + "sa");  
    }  
}  
  
interface packageInfoInteger{  
    void test();
}  
  
class PackageConstants{  
    public static final String ERROE_CODE = "100001";     
}  