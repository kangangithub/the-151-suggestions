package com.example.part4.s56;

/**
 * 建议56:自由选择字符串拼接方法
 *
 * +号最慢,concat()次之,append()最快
 *
 * +号拼接:
 *      编译器对+号做了优化,调用StringBuilder的append()追加,但最终通过toString()返回,
 *      等价于new StringBuilder("AB").append("C").toString();
 *
 * concat()拼接:
 *  concat()源码:基于数组拷贝,速度很快,但return new String(buf, true);创建了50000个String对象
 *  public String concat(String str) {
         int otherLen = str.length();
         if (otherLen == 0) {
            return this;
         }
         int len = value.length;
         char buf[] = Arrays.copyOf(value, len + otherLen);
         str.getChars(buf, len);
         return new String(buf, true);
     }

 * append()拼接:
 *  append()由父类AbstractStringBuilder实现,内部做字符数组处理,加长,拷贝,没有新建对象,源码:
 *  public AbstractStringBuilder append(String str) {
         if (str == null)
            return appendNull();
         int len = str.length();
         ensureCapacityInternal(count + len);
         str.getChars(0, len, value, count);
         count += len;
         return this;
     }
 *
 * Created by ankang on 2017-08-07.
 */
public class S56 {
    private static String string = "AB";
    private static String string1 = "AB";
    private static StringBuilder stringBuilder = new StringBuilder("AB");

    public static void main(String[] args) {
        System.out.println("+号拼接耗时: " + test(1) + " 毫秒");
        System.out.println("concat()拼接耗时: " + test(2) + " 毫秒");
        System.out.println("append()拼接耗时: " + test(3) + " 毫秒");
        System.out.println(string);
        System.out.println(string1);
        System.out.println(stringBuilder);
    }

    private static long test(int i) {
        long begin = System.currentTimeMillis();
        for (int j = 0; j < 50000; j++) {
            StringAdd(i);
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    private static void StringAdd(int i) {
        switch (i) {
            case 1:
                string += "C";
                break;
            case 2:
                string1 = string1.concat("C");
                break;
            case 3:
                stringBuilder.append("C");
                break;
            default:
                System.out.println("只能输入1-3之间的整数");
                break;
        }
    }
}
