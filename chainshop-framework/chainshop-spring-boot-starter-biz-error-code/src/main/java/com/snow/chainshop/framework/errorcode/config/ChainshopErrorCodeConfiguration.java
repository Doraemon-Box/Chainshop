package com.snow.chainshop.framework.errorcode.config;

import com.snow.chainshop.framework.errorcode.core.generator.ErrorCodeAutoGenerator;
import com.snow.chainshop.framework.errorcode.core.generator.ErrorCodeAutoGeneratorImpl;
import com.snow.chainshop.framework.errorcode.core.loader.ErrorCodeLoader;
import com.snow.chainshop.framework.errorcode.core.loader.ErrorCodeLoaderImpl;
import com.snow.chainshop.module.system.api.errorcode.ErrorCodeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 错误码配置类
 *
 * @author Chainshop
 */
@AutoConfiguration
@ConditionalOnProperty(prefix = "chainshop.error-code", value = "enable", matchIfMissing = true) // 允许使用 chainshop.error-code.enable=false 禁用访问日志
@EnableConfigurationProperties(ErrorCodeProperties.class)
@EnableScheduling // 开启调度任务的功能，因为 ErrorCodeRemoteLoader 通过定时刷新错误码
public class ChainshopErrorCodeConfiguration {

    @Bean
    public ErrorCodeAutoGenerator errorCodeAutoGenerator(@Value("${spring.application.name}") String applicationName,
                                                         ErrorCodeProperties errorCodeProperties,
                                                         ErrorCodeApi errorCodeApi) {
        return new ErrorCodeAutoGeneratorImpl(applicationName, errorCodeProperties.getConstantsClassList(), errorCodeApi);
    }

    @Bean
    public ErrorCodeLoader errorCodeLoader(@Value("${spring.application.name}") String applicationName,
                                           ErrorCodeApi errorCodeApi) {
        return new ErrorCodeLoaderImpl(applicationName, errorCodeApi);
    }

}
