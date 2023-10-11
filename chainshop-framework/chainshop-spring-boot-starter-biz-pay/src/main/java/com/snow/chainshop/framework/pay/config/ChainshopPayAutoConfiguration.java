package com.snow.chainshop.framework.pay.config;

import com.snow.chainshop.framework.pay.core.client.PayClientFactory;
import com.snow.chainshop.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author Chainshop
 */
@AutoConfiguration
public class ChainshopPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
