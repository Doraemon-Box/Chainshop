package com.snow.chainshop.module.promotion.service.price;

import com.snow.chainshop.module.promotion.api.price.dto.CouponMeetRespDTO;
import com.snow.chainshop.module.promotion.api.price.dto.PriceCalculateReqDTO;

import java.util.List;

/**
 * 价格计算 Service 接口
 *
 * @author Chainshop
 */
public interface PriceService {

    /**
     * 获得优惠劵的匹配信息列表
     *
     * @param calculateReqDTO 价格请求
     * @return 价格响应
     */
    List<CouponMeetRespDTO> getMeetCouponList(PriceCalculateReqDTO calculateReqDTO);

}
