package com.snow.chainshop.module.system.framework.sms;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SmsCodeProperties.class)
public class SmsCodeConfiguration {
}
