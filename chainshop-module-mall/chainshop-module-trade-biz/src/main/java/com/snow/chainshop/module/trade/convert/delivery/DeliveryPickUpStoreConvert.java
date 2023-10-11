package com.snow.chainshop.module.trade.convert.delivery;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.ip.core.utils.AreaUtils;
import com.snow.chainshop.module.trade.controller.admin.delivery.vo.pickup.DeliveryPickUpStoreCreateReqVO;
import com.snow.chainshop.module.trade.controller.admin.delivery.vo.pickup.DeliveryPickUpStoreRespVO;
import com.snow.chainshop.module.trade.controller.admin.delivery.vo.pickup.DeliveryPickUpStoreSimpleRespVO;
import com.snow.chainshop.module.trade.controller.admin.delivery.vo.pickup.DeliveryPickUpStoreUpdateReqVO;
import com.snow.chainshop.module.trade.dal.dataobject.delivery.DeliveryPickUpStoreDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeliveryPickUpStoreConvert {

    DeliveryPickUpStoreConvert INSTANCE = Mappers.getMapper(DeliveryPickUpStoreConvert.class);

    DeliveryPickUpStoreDO convert(DeliveryPickUpStoreCreateReqVO bean);

    DeliveryPickUpStoreDO convert(DeliveryPickUpStoreUpdateReqVO bean);

    DeliveryPickUpStoreRespVO convert(DeliveryPickUpStoreDO bean);

    List<DeliveryPickUpStoreRespVO> convertList(List<DeliveryPickUpStoreDO> list);

    PageResult<DeliveryPickUpStoreRespVO> convertPage(PageResult<DeliveryPickUpStoreDO> page);

    List<DeliveryPickUpStoreSimpleRespVO> convertList1(List<DeliveryPickUpStoreDO> list);
    @Mapping(source = "areaId", target = "areaName", qualifiedByName = "convertAreaIdToAreaName")
    DeliveryPickUpStoreSimpleRespVO convert02(DeliveryPickUpStoreDO bean);

    @Named("convertAreaIdToAreaName")
    default String convertAreaIdToAreaName(Integer areaId) {
        return AreaUtils.format(areaId);
    }

}
