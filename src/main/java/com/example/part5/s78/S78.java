package com.example.part5.s78;

import java.util.HashMap;
import java.util.Map;

/**
 * 建议78:减少HashMap中元素的数量
 * Created by ankang on 2017-08-14.
 */
public class S78 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 393217; i++) {
            map.put("key" + i, "value" + i);
        }
        Runtime runtime = Runtime.getRuntime();
        //JVM终止前记录内存信息,钩子方法
        runtime.addShutdownHook(new Thread() {
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer();
                long heapMaxSize = runtime.maxMemory() >> 20;
                stringBuffer.append("JVM最大可用内存: " + heapMaxSize + "M\n");
                long total = runtime.totalMemory() >> 20;
                stringBuffer.append("JVM总共可用内存: " + total + "M\n");
                long free = runtime.freeMemory() >> 20;
                stringBuffer.append("JVM空闲内存: " + free + "M");
                System.out.println(stringBuffer);
            }
        });
    }
}
