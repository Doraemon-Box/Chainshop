package com.snow.chainshop.module.trade.api.order;

import com.snow.chainshop.module.trade.dal.dataobject.order.TradeOrderItemDO;
import com.snow.chainshop.module.trade.service.order.TradeOrderQueryService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.snow.chainshop.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.snow.chainshop.module.trade.enums.ErrorCodeConstants.ORDER_ITEM_NOT_FOUND;

/**
 * 订单 API 接口实现类
 *
 * @author HUIHUI
 */
@Service
@Validated
public class TradeOrderApiImpl implements TradeOrderApi {

    @Resource
    private TradeOrderQueryService tradeOrderQueryService;

    @Override
    public Long validateOrder(Long userId, Long orderItemId) {
        // 校验订单项，订单项存在订单就存在
        TradeOrderItemDO item = tradeOrderQueryService.getOrderItem(userId, orderItemId);
        if (item == null) {
            throw exception(ORDER_ITEM_NOT_FOUND);
        }
        return item.getOrderId();
    }

}
