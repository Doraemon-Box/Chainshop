package com.snow.chainshop.module.product.framework.web.config;

import com.snow.chainshop.framework.swagger.config.ChainshopSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * product 模块的 web 组件的 Configuration
 *
 * @author Chainshop
 */
@Configuration(proxyBeanMethods = false)
public class ProductWebConfiguration {

    /**
     * product 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi productGroupedOpenApi() {
        return ChainshopSwaggerAutoConfiguration.buildGroupedOpenApi("product");
    }

}
