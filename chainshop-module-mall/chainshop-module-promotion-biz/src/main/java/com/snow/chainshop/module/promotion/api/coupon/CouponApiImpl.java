package com.snow.chainshop.module.promotion.api.coupon;


import com.snow.chainshop.module.promotion.api.coupon.dto.CouponRespDTO;
import com.snow.chainshop.module.promotion.api.coupon.dto.CouponUseReqDTO;
import com.snow.chainshop.module.promotion.api.coupon.dto.CouponValidReqDTO;
import com.snow.chainshop.module.promotion.convert.coupon.CouponConvert;
import com.snow.chainshop.module.promotion.dal.dataobject.coupon.CouponDO;
import com.snow.chainshop.module.promotion.service.coupon.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 优惠劵 API 实现类
 *
 * @author Chainshop
 */
@Service
public class CouponApiImpl implements CouponApi {

    @Resource
    private CouponService couponService;

    @Override
    public void useCoupon(CouponUseReqDTO useReqDTO) {
        couponService.useCoupon(useReqDTO.getId(), useReqDTO.getUserId(),
                useReqDTO.getOrderId());
    }

    @Override
    public void returnUsedCoupon(Long id) {
        couponService.returnUsedCoupon(id);
    }

    @Override
    public CouponRespDTO validateCoupon(CouponValidReqDTO validReqDTO) {
        CouponDO coupon = couponService.validCoupon(validReqDTO.getId(), validReqDTO.getUserId());
        return CouponConvert.INSTANCE.convert(coupon);
    }

}
