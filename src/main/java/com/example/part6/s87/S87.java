package com.example.part6.s87;

import com.example.part6.s83.SeasonEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议87:使用valueOf前必须进行校验
 * valueOf(String name)不可见,是JVM内置方法,valueOf(Class<T> enumType,String name)源码:
 *  public static <T extends Enum<T>> T valueOf(Class<T> enumType,String name) {
     T result = enumType.enumConstantDirectory().get(name);
     if (result != null) return result;
     if (name == null) throw new NullPointerException("Name is null");
     throw new IllegalArgumentException("No enum constant " + enumType.getCanonicalName() + "." + name);
     }
 * valueOf方法先通过反射从枚举类常量声明中查找,若找到接直接返回,参数为空抛出空指针异常,找不到相关枚举项则抛出无效参数异常
 * 解决:
 *  1.try catch
 *  2.修改枚举类,提供contains()方法
 * Created by ankang on 2017-08-16.
 */
@Slf4j
public class S87 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("SPRING");
                add("summer");
            }
        };
        for (String s : list) {
            try {
                SeasonEnum seasonEnum = SeasonEnum.valueOf(s);
                System.out.println(seasonEnum);
            } catch (IllegalArgumentException e) {
                log.error("An error occurred when invoking valueOf(), the error message is {}", e);
            }
        }
    }
}
