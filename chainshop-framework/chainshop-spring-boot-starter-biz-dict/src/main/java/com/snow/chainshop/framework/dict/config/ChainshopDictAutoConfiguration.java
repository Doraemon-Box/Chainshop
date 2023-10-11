package com.snow.chainshop.framework.dict.config;

import com.snow.chainshop.framework.dict.core.util.DictFrameworkUtils;
import com.snow.chainshop.module.system.api.dict.DictDataApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ChainshopDictAutoConfiguration {

    @Bean
    @SuppressWarnings("InstantiationOfUtilityClass")
    public DictFrameworkUtils dictUtils(DictDataApi dictDataApi) {
        DictFrameworkUtils.init(dictDataApi);
        return new DictFrameworkUtils();
    }

}
