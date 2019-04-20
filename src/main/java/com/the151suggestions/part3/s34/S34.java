package com.the151suggestions.part3.s34;

import com.the151suggestions.common.Constant;

/**
 * 建议34: 构造方法尽量简化
 * 构造方法尽量简单,尽可能不抛异常,尽量不做复杂运算,做到一眼洞穿.
 * Created by ankang on 2017-03-28.
 */
public class S34 {
    public static void main(String[] args) {
        Server server = new SimpleServer(1000);
        /**
         * 子类实例化时:初始化父类变量-->父类构造-->初始化子类变量-->调用子类构造-->生产实例对象
         * 执行顺序:
         * 1.接收int参数1000
         * 2.父类初始化常量DEFAULT_PORT(40000)
         * 3.执行int port = getPort();调用子类getPort()实现;
         * 4.返回port值(注意: 此时port没有赋值,默认值0或默认值DEFAULT_PORT=40000),打印值40000 / 0
         * 5.初始化子类实例变量,port赋值100
         * 6.执行自乐构造方法,port赋值1000
         * 7.实例化结束,对象创建完毕
         */
//        server.start();
    }
}

abstract class Server {
    public final static int DEFAULT_PORT = Constant.DEFAULT_PORT;

    //修改:把构造中逻辑代码提取成start()方法
    public Server() {
        int port = getPort();
        System.out.println("端口号: " + port); //40000 或 0  永远不会是100 1000
        /**其他操作*/
    }

//    修改:把构造中逻辑代码提取成start()方法
//    public void start() {
//        int port = getPort();
//        System.out.println("端口号: " + port);
//        /**其他操作*/
//    }

    protected abstract int getPort();
}

class SimpleServer extends Server {
    private int port = 100;

    public SimpleServer(int port) {
        this.port = port;
    }

    //检查端口是否有效,无效使用默认端口,这里在使用随机数模拟
    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}