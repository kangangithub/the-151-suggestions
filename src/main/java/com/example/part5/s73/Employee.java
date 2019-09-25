package com.example.part5.s73;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 员工
 * 实现Comparable接口时,要加上泛型,即public class Employee implements Comparable<Employee> {...}
 * Created by ankang on 2017-08-09.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private PositionEnum position;

    @Override
    public int compareTo(Employee o) {
        //先按职位排序(枚举中定义顺序),再按id排序
        //左右参数互换即可实现倒叙或者Collections.reverse(list)或者定义一个倒叙的比较器
        /**
         * 3.append族
         CompareToBuilder类使用append方法加入需要比较的左值和右值，并通过比较给comparison变量赋值，如果comparison不为0，即已经获得了结果，则直接返回。分为以下两族。

         3.1 单个对象的append方法
         左值和右值为Object类型，除了左值和右值外，还需要一个Comparator参数用于执行比较。执行以下操作
         如果左值等于右值，则直接返回。
         如果左值为空，则赋值-1，并返回。
         如果右值为空，则赋值+1，并返回。
         如果是数组，根据数组的类型，调用各自的append方法。
         否则，如果comparator为空，则利用左值的compareTo方法测试和右值的关系，此时左值必须实现Comparable接口。否则，使用comparator测试左值和右值的关系。
         左值和右值为基本类型，如long,int,short,char,byte，则直接进行比较，左值小于右值，则赋值-1，反之赋值1。
         左值和右值为基本类型，如double,float，则使用NumberUtils的compare方法进行比较（该方法比较的更为精细）。
         左值和右值为基本类型，如boolean，则如果左值为假，赋值-1，左值为真（右值为假）则赋值1。

         3.2 数组对象的append方法
         左值和右值为Object[]类型，除了左值和右值外，还需要一个Comparator参数用于执行比较。执行以下操作
         如果左值等于右值，则直接返回。
         如果左值为空，则赋值-1，并返回。
         如果右值为空，则赋值+1，并返回。
         如果两数组长度不等，则如果左值长度小于右值，则赋值-1，反之赋值+1，并返回。
         遍历数组，如果comparsion等于0，则调用单个对象的append方法进行判断。
         左值和右值为long[],int[],short[],char[],byte[],double[],float[],boolean[]类型时，除了不需要Comparator参数外，其余操作同上。

         4.toComparison方法
         返回comparison变量，输出最后的结果。
         */
        return new CompareToBuilder().append(position, o.position).append(id, o.id).toComparison();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
