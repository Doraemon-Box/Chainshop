package com.snow.chainshop.framework.websocket.config;

import com.snow.chainshop.framework.websocket.core.UserHandshakeInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.HandshakeInterceptor;

@EnableConfigurationProperties(WebSocketProperties.class)
public class WebSocketHandlerConfig {
    @Bean
    public HandshakeInterceptor handshakeInterceptor() {
        return new UserHandshakeInterceptor();
    }
}
