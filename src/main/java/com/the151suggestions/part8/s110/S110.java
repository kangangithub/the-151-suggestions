package com.the151suggestions.part8.s110;

import com.the151suggestions.part7.s103.Foo;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 建议110:提倡异常封装
 * Created by Akang on 2017/8/24.
 */
@Slf4j
public class S110 {
    public static void main(String[] args) throws MyBussinessException, CatchMoreThanOneException {
        test1("JDK1.7捕获多个异常");
        test2("异常分类处理,并抛出自定义异常");
        test3("解决一次抛出多个异常");
    }

    /**
     * 通过反射执行方法:先获取方法对象,根据isAccessible()返回值判断是否能够执行,返回值为false,调用setAccessible(true),最后调用invoke()
     */
    private static void test1(String s) {
        try {
            Method method = Foo.class.getMethod("doSomething", s.getClass());
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            /**
             * public Object invoke(Object obj, Object... args)
             *  obj: 目标方法所在的类的对象
             *  args: 调用目标方法需要的参数
             *  Object: 目标方法返回值
             */
            String string = (String) method.invoke(new Foo(), s);
            System.out.println(string);
            /**
             * JDK1.7新特性,捕获多个异常 catch(A|B|C ex) 只有当ABC没有继承关系 
             */
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error("An error occurred when invoking test1, the error message is {}", e);
        }
        /*} catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
    }

    private static void test2(String s) throws MyBussinessException {
        try {
            Method method = Foo.class.getMethod("doSomething", s.getClass());
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            String string = (String) method.invoke(new Foo(), s);
            System.out.println(string);
        } catch (NoSuchMethodException e) {
            log.error("An error occurred when invoking test2, the error message is {}", e);
            throw new MyBussinessException("找不到这个方法");
        } catch (IllegalAccessException e) {
            log.error("An error occurred when invoking test2, the error message is {}", e);
            throw new MyBussinessException("非法访问");
        } catch (InvocationTargetException e) {
            log.error("An error occurred when invoking test2, the error message is {}", e);
            throw new MyBussinessException("其他错误");
        }
    }

    private static void test3(String s) throws CatchMoreThanOneException {
        List<Throwable> causes = new ArrayList<>();
        try {
            Method method = Foo.class.getMethod("doSomething", s.getClass());
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            String string = (String) method.invoke(new Foo(), s);
            System.out.println(string);
        } catch (NoSuchMethodException e) {
            log.error("An error occurred when invoking test3, the error message is {}", e);
            causes.add(e);
        } catch (IllegalAccessException e) {
            log.error("An error occurred when invoking test3, the error message is {}", e);
            causes.add(e);
        } catch (InvocationTargetException e) {
            log.error("An error occurred when invoking test3 the error message is {}", e);
            causes.add(e);
        }

        if (causes.size() > 0) {
            CatchMoreThanOneException catchMoreThanOneException = new CatchMoreThanOneException(causes);
            List<Throwable> exceptions = catchMoreThanOneException.getExceptions();
            for (Throwable exception : exceptions) {
                System.out.println(exception);
            }
            throw catchMoreThanOneException;
        }
    }
}
