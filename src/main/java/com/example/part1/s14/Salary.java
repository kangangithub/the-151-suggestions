package com.example.part1.s14;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 薪水类
 * Created by ankang on 2017-03-26.
 */
@Data
@AllArgsConstructor
public class Salary implements Serializable {
    //    显示声明UID(流标识符)
    private static final long serialVersionUID = 5579790L;

    //基本工资
    private int basePay;

    //绩效工资
    private int bonus;
    /**
     * transient 瞬态关键字,表示此属性不参与序列化
     * 但Salary类不能再实现分布式部署
     */
//    private transient int bonus;



}
