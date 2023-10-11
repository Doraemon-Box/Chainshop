package com.snow.chainshop.framework.operatelog.config;

import com.snow.chainshop.framework.operatelog.core.aop.OperateLogAspect;
import com.snow.chainshop.framework.operatelog.core.service.OperateLogFrameworkService;
import com.snow.chainshop.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.snow.chainshop.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ChainshopOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
