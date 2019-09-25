package com.example.part6.s91;

/**
 * 建议91:枚举和注解结合使用威力更大
 * 模拟ACL(Access Control List,访问控制列表)设计
 * 资源:需要被控制的信息
 * 权限:不同访问者有不同的权限级别
 * 控制器/鉴权人:控制不同级别访问不同资源
 * Created by ankang on 2017-08-16.
 */
public class S91 {
    public static void main(String[] args) {
        SystemConfiguration systemConfiguration = new SystemConfiguration();
        Access annotation = systemConfiguration.getClass().getAnnotation(Access.class);

        AllGoods allGoods = new AllGoods();
        Access access = allGoods.getClass().getAnnotation(Access.class);
        if (access == null) {
            System.out.println("该类不需要被控制");
        } else if (access.level().identify(access.level())) {
            System.out.println(access.level().REFUSE_WORD);
        }
    }
}
