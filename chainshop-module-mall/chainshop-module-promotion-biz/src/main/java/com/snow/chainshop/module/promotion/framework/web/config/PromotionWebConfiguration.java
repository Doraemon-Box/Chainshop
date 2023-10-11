package com.snow.chainshop.module.promotion.framework.web.config;

import com.snow.chainshop.framework.swagger.config.ChainshopSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * promotion 模块的 web 组件的 Configuration
 *
 * @author Chainshop
 */
@Configuration(proxyBeanMethods = false)
public class PromotionWebConfiguration {

    /**
     * promotion 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi promotionGroupedOpenApi() {
        return ChainshopSwaggerAutoConfiguration.buildGroupedOpenApi("promotion");
    }

}
