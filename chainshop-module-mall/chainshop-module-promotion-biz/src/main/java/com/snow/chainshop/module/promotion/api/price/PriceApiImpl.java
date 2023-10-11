package com.snow.chainshop.module.promotion.api.price;

import com.snow.chainshop.module.promotion.api.price.dto.PriceCalculateReqDTO;
import com.snow.chainshop.module.promotion.api.price.dto.PriceCalculateRespDTO;
import com.snow.chainshop.module.promotion.service.price.PriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 价格 API 实现类
 *
 * @author Chainshop
 */
@Service
public class PriceApiImpl implements PriceApi {

    @Resource
    private PriceService priceService;

    @Override
    public PriceCalculateRespDTO calculatePrice(PriceCalculateReqDTO calculateReqDTO) {
        //return priceService.calculatePrice(calculateReqDTO); TODO 没有 calculatePrice 这个方法

        return null;
    }

}
