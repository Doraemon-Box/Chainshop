package com.snow.chainshop.module.promotion.api.price;

import com.snow.chainshop.module.promotion.api.price.dto.PriceCalculateReqDTO;
import com.snow.chainshop.module.promotion.api.price.dto.PriceCalculateRespDTO;

/**
 * 价格 API 接口
 *
 * @author Chainshop
 */
public interface PriceApi {

    /**
     * 计算商品的价格
     *
     * @param calculateReqDTO 价格请求
     * @return 价格相应
     */
    PriceCalculateRespDTO calculatePrice(PriceCalculateReqDTO calculateReqDTO);

}
