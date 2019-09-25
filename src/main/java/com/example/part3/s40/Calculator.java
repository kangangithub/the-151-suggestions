package com.example.part3.s40;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运算符
 * Created by ankang on 2017-08-04.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {
    private int i;
    private int j;
    private int result;

    public Calculator(int i, int j) {
        this.i = i;
        this.j = j;
    }

    //设置运算符
    public void setOperator(Ops ops) {
        result = ops.equals(Ops.ADD) ? i + j : i - j;
    }

    //获取运算结果
    public int getResult() {
        return result;
    }
}
