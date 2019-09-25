package com.example.part5.s62;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 气球类
 * Created by ankang on 2017-08-08.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balloon implements Serializable{
    private int id; //编号
    private Color color;    //颜色

    /**
     * 利用ToStringBuilder覆写toString方法
     * @return
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("编号", id).append("颜色", color).toString();
    }
}
