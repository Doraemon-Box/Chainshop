package com.snow.chainshop.module.promotion.api.discount;

import com.snow.chainshop.module.promotion.api.discount.dto.DiscountProductRespDTO;
import com.snow.chainshop.module.promotion.convert.discount.DiscountActivityConvert;
import com.snow.chainshop.module.promotion.service.discount.DiscountActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 限时折扣 API 实现类
 *
 * @author Chainshop
 */
@Service
public class DiscountActivityApiImpl implements DiscountActivityApi {

    @Resource
    private DiscountActivityService discountActivityService;

    @Override
    public List<DiscountProductRespDTO> getMatchDiscountProductList(Collection<Long> skuIds) {
        return DiscountActivityConvert.INSTANCE.convertList02(discountActivityService.getMatchDiscountProductList(skuIds));
    }

}
