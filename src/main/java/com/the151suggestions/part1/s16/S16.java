package com.the151suggestions.part1.s16;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 建议16:易变业务使用脚本语言编写
 * Created by ankang on 2017-03-26.
 */
public class S16 {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        //获得JavaScript的执行引擎 需要JDK6
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bindings = scriptEngine.createBindings();
        bindings.put("factor", 1);
        //绑定上下文,作用域是当前引擎范围
        scriptEngine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            System.out.println("输入的参数是:" + first + "," + second);
            //执行js代码
            scriptEngine.eval(new FileReader("E:\\Git\\The151Suggestions\\src\\main\\java\\com\\the151suggestions\\part1\\s16\\model.js"));
            //是否可调用方法
            if (scriptEngine instanceof Invocable) {
                Invocable invocable = (Invocable) scriptEngine;
                //执行js中的方法
                Double formula = (Double) invocable.invokeFunction("formula", first, second);
                System.out.println("运算结果:" + formula.intValue());
            }
        }
    }
}
