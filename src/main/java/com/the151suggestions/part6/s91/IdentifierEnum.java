package com.the151suggestions.part6.s91;

/**
 * 定义枚举,结合权限级别,鉴权方法
 * Created by ankang on 2017-08-16.
 */
public enum IdentifierEnum implements Identifier {
    GUEST, USER, ADMIN; //权限级别

    @Override
    public boolean identify(IdentifierEnum identifierEnum) { //鉴权方法
        switch (identifierEnum) {
            case GUEST:
                return false;
            case USER:
                return true;
            case ADMIN:
                return true;
            default:
                throw new AssertionError("执行到此处就出错");
        }
    }
}
