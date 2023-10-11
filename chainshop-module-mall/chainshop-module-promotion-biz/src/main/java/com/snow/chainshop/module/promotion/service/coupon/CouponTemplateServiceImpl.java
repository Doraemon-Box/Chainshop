package com.snow.chainshop.module.promotion.service.coupon;

import com.snow.chainshop.framework.common.enums.CommonStatusEnum;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplatePageReqVO;
import com.snow.chainshop.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import com.snow.chainshop.module.promotion.convert.coupon.CouponTemplateConvert;
import com.snow.chainshop.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import com.snow.chainshop.module.promotion.dal.mysql.coupon.CouponTemplateMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.snow.chainshop.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.snow.chainshop.module.promotion.enums.ErrorCodeConstants.COUPON_TEMPLATE_NOT_EXISTS;
import static com.snow.chainshop.module.promotion.enums.ErrorCodeConstants.COUPON_TEMPLATE_TOTAL_COUNT_TOO_SMALL;

/**
 * 优惠劵模板 Service 实现类
 *
 * @author Chainshop
 */
@Service
@Validated
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Resource
    private CouponTemplateMapper couponTemplateMapper;

    @Override
    public Long createCouponTemplate(CouponTemplateCreateReqVO createReqVO) {
        // 插入
        CouponTemplateDO couponTemplate = CouponTemplateConvert.INSTANCE.convert(createReqVO)
                .setStatus(CommonStatusEnum.ENABLE.getStatus());
        couponTemplateMapper.insert(couponTemplate);
        // 返回
        return couponTemplate.getId();
    }

    @Override
    public void updateCouponTemplate(CouponTemplateUpdateReqVO updateReqVO) {
        // 校验存在
        CouponTemplateDO couponTemplate = validateCouponTemplateExists(updateReqVO.getId());
        // 校验发放数量不能过小
        if (updateReqVO.getTotalCount() < couponTemplate.getTakeCount()) {
            throw exception(COUPON_TEMPLATE_TOTAL_COUNT_TOO_SMALL, couponTemplate.getTakeCount());
        }

        // 更新
        CouponTemplateDO updateObj = CouponTemplateConvert.INSTANCE.convert(updateReqVO);
        couponTemplateMapper.updateById(updateObj);
    }

    @Override
    public void updateCouponTemplateStatus(Long id, Integer status) {
        // 校验存在
        validateCouponTemplateExists(id);
        // 更新
        couponTemplateMapper.updateById(new CouponTemplateDO().setId(id).setStatus(status));
    }

    @Override
    public void deleteCouponTemplate(Long id) {
        // 校验存在
        validateCouponTemplateExists(id);
        // 删除
        couponTemplateMapper.deleteById(id);
    }

    private CouponTemplateDO validateCouponTemplateExists(Long id) {
        CouponTemplateDO couponTemplate = couponTemplateMapper.selectById(id);
        if (couponTemplate == null) {
            throw exception(COUPON_TEMPLATE_NOT_EXISTS);
        }
        return couponTemplate;
    }

    @Override
    public CouponTemplateDO getCouponTemplate(Long id) {
        return couponTemplateMapper.selectById(id);
    }

    @Override
    public PageResult<CouponTemplateDO> getCouponTemplatePage(CouponTemplatePageReqVO pageReqVO) {
        return couponTemplateMapper.selectPage(pageReqVO);
    }

    @Override
    public void updateCouponTemplateTakeCount(Long id, int incrCount) {
        couponTemplateMapper.updateTakeCount(id, incrCount);
    }

}
