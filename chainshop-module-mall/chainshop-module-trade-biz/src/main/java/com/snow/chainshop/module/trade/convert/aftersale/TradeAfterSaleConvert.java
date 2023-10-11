package com.snow.chainshop.module.trade.convert.aftersale;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.member.api.user.dto.MemberUserRespDTO;
import com.snow.chainshop.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import com.snow.chainshop.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import com.snow.chainshop.module.trade.controller.admin.aftersale.vo.TradeAfterSaleDetailRespVO;
import com.snow.chainshop.module.trade.controller.admin.aftersale.vo.TradeAfterSaleRespPageItemVO;
import com.snow.chainshop.module.trade.controller.admin.aftersale.vo.log.TradeAfterSaleLogRespVO;
import com.snow.chainshop.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import com.snow.chainshop.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import com.snow.chainshop.module.trade.controller.admin.order.vo.TradeOrderBaseVO;
import com.snow.chainshop.module.trade.controller.app.aftersale.vo.AppTradeAfterSaleCreateReqVO;
import com.snow.chainshop.module.trade.controller.app.aftersale.vo.AppTradeAfterSaleRespVO;
import com.snow.chainshop.module.trade.dal.dataobject.aftersale.TradeAfterSaleDO;
import com.snow.chainshop.module.trade.dal.dataobject.aftersale.TradeAfterSaleLogDO;
import com.snow.chainshop.module.trade.dal.dataobject.order.TradeOrderDO;
import com.snow.chainshop.module.trade.dal.dataobject.order.TradeOrderItemDO;
import com.snow.chainshop.module.trade.framework.aftersalelog.core.dto.TradeAfterSaleLogRespDTO;
import com.snow.chainshop.module.trade.framework.order.config.TradeOrderProperties;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper
public interface TradeAfterSaleConvert {

    TradeAfterSaleConvert INSTANCE = Mappers.getMapper(TradeAfterSaleConvert.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
            @Mapping(target = "creator", ignore = true),
            @Mapping(target = "updater", ignore = true),
    })
    TradeAfterSaleDO convert(AppTradeAfterSaleCreateReqVO createReqVO, TradeOrderItemDO tradeOrderItem);

    @Mappings({
            @Mapping(source = "afterSale.orderId", target = "merchantOrderId"),
            @Mapping(source = "afterSale.id", target = "merchantRefundId"),
            @Mapping(source = "afterSale.applyReason", target = "reason"),
            @Mapping(source = "afterSale.refundPrice", target = "price")
    })
    PayRefundCreateReqDTO convert(String userIp, TradeAfterSaleDO afterSale,
                                  TradeOrderProperties orderProperties);

    MemberUserRespVO convert(MemberUserRespDTO bean);

    PageResult<TradeAfterSaleRespPageItemVO> convertPage(PageResult<TradeAfterSaleDO> page);

    default PageResult<TradeAfterSaleRespPageItemVO> convertPage(PageResult<TradeAfterSaleDO> pageResult,
                                                                 Map<Long, MemberUserRespDTO> memberUsers) {
        PageResult<TradeAfterSaleRespPageItemVO> voPageResult = convertPage(pageResult);
        // 处理会员
        voPageResult.getList().forEach(afterSale -> afterSale.setUser(
                convert(memberUsers.get(afterSale.getUserId()))));
        return voPageResult;
    }

    ProductPropertyValueDetailRespVO convert(ProductPropertyValueDetailRespDTO bean);

    AppTradeAfterSaleRespVO convert(TradeAfterSaleDO bean);

    PageResult<AppTradeAfterSaleRespVO> convertPage02(PageResult<TradeAfterSaleDO> page);

    List<TradeAfterSaleLogRespDTO> convertList(List<TradeAfterSaleLogDO> list);
    
    default TradeAfterSaleDetailRespVO convert(TradeAfterSaleDO afterSale, TradeOrderDO order, List<TradeOrderItemDO> orderItems,
                                               MemberUserRespDTO user, List<TradeAfterSaleLogRespDTO> logs) {
        TradeAfterSaleDetailRespVO respVO = convert(afterSale, orderItems);
        // 处理用户信息
        respVO.setUser(convert(user));
        // 处理订单信息
        respVO.setOrder(convert(order));
        // 处理售后日志
        respVO.setLogs(convertList1(logs));
        return respVO;
    }
    List<TradeAfterSaleLogRespVO> convertList1(List<TradeAfterSaleLogRespDTO> list);
    @Mapping(target = "id", source = "afterSale.id")
    TradeAfterSaleDetailRespVO convert(TradeAfterSaleDO afterSale, List<TradeOrderItemDO> orderItems);
    TradeOrderBaseVO convert(TradeOrderDO order);

}