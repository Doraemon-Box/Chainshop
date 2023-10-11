package com.snow.chainshop.module.promotion.dal.mysql.discount;

import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.module.promotion.dal.dataobject.discount.DiscountProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 限时折扣商城 Mapper
 *
 * @author Chainshop
 */
@Mapper
public interface DiscountProductMapper extends BaseMapperX<DiscountProductDO> {

    default List<DiscountProductDO> selectListBySkuId(Collection<Long> skuIds) {
        return selectList(DiscountProductDO::getSkuId, skuIds);
    }

    default List<DiscountProductDO> selectListByActivityId(Long activityId) {
        return selectList(DiscountProductDO::getActivityId, activityId);
    }

}
