package com.snow.chainshop.module.system.framework.web.config;

import com.snow.chainshop.framework.swagger.config.ChainshopSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的 web 组件的 Configuration
 *
 * @author Chainshop
 */
@Configuration(proxyBeanMethods = false)
public class SystemWebConfiguration {

    /**
     * system 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi systemGroupedOpenApi() {
        return ChainshopSwaggerAutoConfiguration.buildGroupedOpenApi("system");
    }

}
