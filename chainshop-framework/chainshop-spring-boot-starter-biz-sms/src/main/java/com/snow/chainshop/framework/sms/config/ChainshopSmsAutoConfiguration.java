package com.snow.chainshop.framework.sms.config;

import com.snow.chainshop.framework.sms.core.client.SmsClientFactory;
import com.snow.chainshop.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author Chainshop
 */
@AutoConfiguration
public class ChainshopSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
