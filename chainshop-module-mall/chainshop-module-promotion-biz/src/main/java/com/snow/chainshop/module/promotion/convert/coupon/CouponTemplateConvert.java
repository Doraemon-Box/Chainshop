package com.snow.chainshop.module.promotion.convert.coupon;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplateRespVO;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵模板 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface CouponTemplateConvert {

    CouponTemplateConvert INSTANCE = Mappers.getMapper(CouponTemplateConvert.class);

    CouponTemplateDO convert(CouponTemplateCreateReqVO bean);

    CouponTemplateDO convert(CouponTemplateUpdateReqVO bean);

    CouponTemplateRespVO convert(CouponTemplateDO bean);

    PageResult<CouponTemplateRespVO> convertPage(PageResult<CouponTemplateDO> page);

}
