package com.the151suggestions.part6.s86;

/**
 * 建议86:在switch的default代码块中增加AssertionError错误
 * switch case 中列举所有枚举项,建议在switch的default代码块中增加AssertionError错误,
 * 当枚举项有增删且增删的枚举项被调用时,会抛出异常,能快速定义出错位置
 * 也可在IDE中修改警告级别:Other Settings--Editor--Inspections,搜索switch/default/break
 * Created by ankang on 2017-08-16.
 */
public class S86 {
    public static void main(String[] args) {
        LogLevelEnum fatal = LogLevelEnum.FATAL;
        switch (fatal) {
            case DEBUG:
                System.out.println("DEBUG");
                break;
            case INFO:
                System.out.println("INFO");
                break;
            case WARN:
                System.out.println("WARN");
                break;
            case ERROR:
                System.out.println("ERROR");
                break;
            case FATAL:
                System.out.println("FATAL");
                break;
            default:
                throw new AssertionError("执行到这里,就失败");
        }
    }
}
