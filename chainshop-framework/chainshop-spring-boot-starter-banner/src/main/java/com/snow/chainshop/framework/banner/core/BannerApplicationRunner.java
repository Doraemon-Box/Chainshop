package com.snow.chainshop.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author Chainshop
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "接口文档: \t{} \n\t" +
                            "开发文档: \t{} \n\t" +
                            "视频教程: \t{} \n" +
                            "----------------------------------------------------------",
                    "http://127.0.0.1:48080",
                    "http://127.0.0.1:48080",
                    "http://127.0.0.1:48080");

            // 数据报表
            if (isNotPresent("com.snow.chainshop.module.report.framework.security.config.SecurityConfiguration")) {
                System.out.println("[报表模块 chainshop-module-report - 已禁用][参考 https://doc.iocoder.cn/report/ 开启]");
            }
            // 工作流
            if (isNotPresent("com.snow.chainshop.framework.flowable.config.ChainshopFlowableConfiguration")) {
                System.out.println("[工作流模块 chainshop-module-bpm - 已禁用][参考 https://doc.iocoder.cn/bpm/ 开启]");
            }
            // 微信公众号
            if (isNotPresent("com.snow.chainshop.module.mp.framework.mp.config.MpConfiguration")) {
                System.out.println("[微信公众号 chainshop-module-mp - 已禁用][参考 https://doc.iocoder.cn/mp/build/ 开启]");
            }
            // 商城系统
            if (isNotPresent("com.snow.chainshop.module.trade.framework.web.config.TradeWebConfiguration")) {
                System.out.println("[商城系统 chainshop-module-mall - 已禁用][参考 https://doc.iocoder.cn/mall/build/ 开启]");
            }
            // 支付平台
            if (isNotPresent("com.snow.chainshop.module.pay.framework.pay.config.PayConfiguration")) {
                System.out.println("[支付系统 chainshop-module-pay - 已禁用][参考 https://doc.iocoder.cn/pay/build/ 开启]");
            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
