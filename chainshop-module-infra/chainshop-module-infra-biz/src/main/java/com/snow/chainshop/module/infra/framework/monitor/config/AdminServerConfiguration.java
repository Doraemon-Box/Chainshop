package com.snow.chainshop.module.infra.framework.monitor.config;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableAdminServer
public class AdminServerConfiguration {
}
