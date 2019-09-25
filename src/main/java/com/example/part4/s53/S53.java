package com.example.part4.s53;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

/**
 * 建议53:注意方法中传递的参数要求
 * replaceAll方法中第一个参数是正则表达式,
 * Created by ankang on 2017-08-07.
 */
public class S53 {
    public static void main(String[] args) {
        /**
         *  String replaceAll(String regex, String replacement)第一个参数是正则表达式
         *  String replace(char oldChar, char newChar)
         *  String replace(CharSequence target, CharSequence replacement)
         *  Apache下的StringUtils工具类remove方法调用的replace()
         * public static String remove(String str, String remove) {
            return !isEmpty(str) && !isEmpty(remove)?replace(str, remove, "", -1):str;
            }
         */
        Assert.assertTrue(StringUtils.remove("好是好","好").equals("是"));
        Assert.assertTrue(StringUtils.remove("$是$","$").equals("是"));
    }
}
