package com.example.part6.s85;

import com.example.part6.s83.SeasonEnum;

/**
 * 建议85:小心switch带来的空值异常
 * switch case中，case后面只能是常量表达式。
 * Created by ankang on 2017-08-15.
 */
public class S85 {
    public static void main(String[] args) {
        doSport(SeasonEnum.AUTUMN);
        doSport(null);
    }

    private static void doSport(SeasonEnum seasonEnum) {
        //这里不用校验 "".equals(seasonEnum),参数类型限定SeasonEnum,避免思维惯性
        if (seasonEnum == null) {  //这里不用校验 "".equals(seasonEnum),参数类型限定SeasonEnum,避免思维惯性
            System.out.println("输入不能为空");
        } else {
            switch (seasonEnum) {
                case SPRING:
                    System.out.println("春天放风筝");
                    break;
                case SUMMER:
                    System.out.println("夏天捉知了");
                    break;
                case AUTUMN:
                    System.out.println("秋天收玉米");
                    break;
                case WINTER:
                    System.out.println("冬天打雪仗");
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
            /**
             * JDK1.7之后的switch语句支持byte, short, int,char, String类型，但也可以使用枚举。 
             * 原因:编译器判断出switch语句后的参数是枚举类型,会根据枚举的排序值继续匹配,即等价于
             * switch (seasonEnum.ordinal()) {
                 case SeasonEnum.SPRING.ordinal():
                     System.out.println("春天放风筝");
                     break;
                }
             */
        }
    }
}
