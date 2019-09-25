package com.example.part8.s116;

/**
 * 异常只为异常服务,不要当做主逻辑使用,能避免就避免
 * Created by Akang on 2017/8/25.
 */
public class Demo {
    /**
     * 判断枚举中是否有name的枚举项
     * 该方法以异常作为主逻辑使用,不好
     */
    public static <T extends Enum<T>> boolean Contain1(Class<T> clazz, String name) {
        boolean result = false;
        try {
            /**
             * 这里是根据valueOf()是否抛异常来进行判断的,如果抛出异常(一般是IllegalArgumentException),
             * 则认为不包含,若没有异常,则认为有该枚举项
             * 这段代码的缺点:
             *  1.异常判断降低了系统性能
             *  2.降低了代码的可读性,需要了解valueOf()抛出异常(IllegalArgumentException 非受检异常)
             *  3.隐藏了运行期可能产生的错误,catch{}到异常却未处理
             */
            Enum.valueOf(clazz, name);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断枚举中是否有name的枚举项,正确写法
     */
    public static <T extends Enum<T>> boolean Contain2(Class<T> clazz, String name) {
        /**
         * T[] getEnumConstants() 返回枚举类的元素,如果此 Class 对象不表示枚举类型，则返回null。
         */
        for (T t : clazz.getEnumConstants()) {
            if (t.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
