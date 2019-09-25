package com.example.part5.s75;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 城市
 * 利用EqualsBuilder, HashCodeBuilder覆写equals(),hashCode()
 * Created by ankang on 2017-08-10.
 */
@NoArgsConstructor
@AllArgsConstructor
public class City implements Comparable<City> {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;
        //根据code判断是否相等
        return new EqualsBuilder().append(code, city.code).isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getCode()).append(this.getName()).hashCode();
    }

    @Override
    public int compareTo(City o) {
        //根据name排序
        return new CompareToBuilder().append(name, o.name).toComparison();
    }
}
