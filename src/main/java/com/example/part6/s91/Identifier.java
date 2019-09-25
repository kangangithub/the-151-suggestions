package com.example.part6.s91;

/**
 * 鉴权接口
 * Created by ankang on 2017-08-16.
 */
public interface Identifier {
    String REFUSE_WORD = "您无权访问";   //礼貌语
    boolean identify(IdentifierEnum identifierEnum);//鉴权方法
}
