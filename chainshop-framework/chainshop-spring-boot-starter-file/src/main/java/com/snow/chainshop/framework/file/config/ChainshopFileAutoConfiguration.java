package com.snow.chainshop.framework.file.config;

import com.snow.chainshop.framework.file.core.client.FileClientFactory;
import com.snow.chainshop.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author Chainshop
 */
@AutoConfiguration
public class ChainshopFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
