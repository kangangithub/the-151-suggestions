package com.the151suggestions.part3.s40;

/**
 * 建议40:匿名累的构造函数很特殊
 * 一般类的构造方法都调用父类无参构造,匿名类没有名字,无所谓有参无参构造,初始化时直接调用父类的同参构造,然后再调用自己的构造代码块
 * Created by ankang on 2017-08-04.
 */
public class S40 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(1, 2) {
            {
                setOperator(Ops.ADD);
            }
        };
        /**
         * 等价于
         * class Add extends Calculator {
                {
                    setOperator(Ops.ADD);
                }

                public Add(int i, int j) {
                    super(i, j);
                }
            }
            Calculator calculator = new Add(1,2);
         */
        System.out.println(calculator.getResult());
    }
}

