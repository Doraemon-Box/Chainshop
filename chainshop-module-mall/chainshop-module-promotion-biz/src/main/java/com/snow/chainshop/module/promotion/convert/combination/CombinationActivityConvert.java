package com.snow.chainshop.module.promotion.convert.combination;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.common.util.collection.CollectionUtils;
import com.snow.chainshop.framework.common.util.collection.MapUtils;
import com.snow.chainshop.module.product.api.spu.dto.ProductSpuRespDTO;
import com.snow.chainshop.module.promotion.api.combination.dto.CombinationRecordCreateReqDTO;
import com.snow.chainshop.module.promotion.api.combination.dto.CombinationRecordRespDTO;
import com.snow.chainshop.module.promotion.controller.admin.combination.vo.activity.CombinationActivityCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.combination.vo.activity.CombinationActivityRespVO;
import com.snow.chainshop.module.promotion.controller.admin.combination.vo.activity.CombinationActivityUpdateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.combination.vo.product.CombinationProductBaseVO;
import com.snow.chainshop.module.promotion.controller.admin.combination.vo.product.CombinationProductRespVO;
import com.snow.chainshop.module.promotion.dal.dataobject.combination.CombinationActivityDO;
import com.snow.chainshop.module.promotion.dal.dataobject.combination.CombinationProductDO;
import com.snow.chainshop.module.promotion.dal.dataobject.combination.CombinationRecordDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static com.snow.chainshop.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * 拼团活动 Convert
 *
 * @author HUIHUI
 */
@Mapper
public interface CombinationActivityConvert {

    CombinationActivityConvert INSTANCE = Mappers.getMapper(CombinationActivityConvert.class);

    CombinationActivityDO convert(CombinationActivityCreateReqVO bean);

    CombinationActivityDO convert(CombinationActivityUpdateReqVO bean);

    CombinationActivityRespVO convert(CombinationActivityDO bean);

    CombinationProductRespVO convert(CombinationProductDO bean);

    default CombinationActivityRespVO convert(CombinationActivityDO activity, List<CombinationProductDO> products) {
        return convert(activity).setProducts(convertList2(products));
    }

    List<CombinationActivityRespVO> convertList(List<CombinationActivityDO> list);

    PageResult<CombinationActivityRespVO> convertPage(PageResult<CombinationActivityDO> page);

    default PageResult<CombinationActivityRespVO> convertPage(PageResult<CombinationActivityDO> page,
                                                              List<CombinationProductDO> productList,
                                                              List<ProductSpuRespDTO> spuList) {
        Map<Long, ProductSpuRespDTO> spuMap = convertMap(spuList, ProductSpuRespDTO::getId);
        PageResult<CombinationActivityRespVO> pageResult = convertPage(page);
        pageResult.getList().forEach(item -> {
            MapUtils.findAndThen(spuMap, item.getSpuId(), spu -> {
                item.setSpuName(spu.getName());
                item.setPicUrl(spu.getPicUrl());
            });
            item.setProducts(convertList2(productList));
        });
        return pageResult;
    }

    List<CombinationProductRespVO> convertList2(List<CombinationProductDO> productDOs);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "activityId", source = "activity.id"),
            @Mapping(target = "spuId", source = "activity.spuId"),
            @Mapping(target = "skuId", source = "product.skuId"),
            @Mapping(target = "combinationPrice", source = "product.combinationPrice"),
            @Mapping(target = "activityStartTime", source = "activity.startTime"),
            @Mapping(target = "activityEndTime", source = "activity.endTime")
    })
    CombinationProductDO convert(CombinationActivityDO activity, CombinationProductBaseVO product);

    default List<CombinationProductDO> convertList(List<? extends CombinationProductBaseVO> products, CombinationActivityDO activity) {
        return CollectionUtils.convertList(products, item -> convert(activity, item).setActivityStatus(activity.getStatus()));
    }

    default List<CombinationProductDO> convertList(List<CombinationProductBaseVO> updateProductVOs,
                                                   List<CombinationProductDO> products, CombinationActivityDO activity) {
        Map<Long, Long> productMap = convertMap(products, CombinationProductDO::getSkuId, CombinationProductDO::getId);
        return CollectionUtils.convertList(updateProductVOs, updateProductVO -> convert(activity, updateProductVO)
                .setId(productMap.get(updateProductVO.getSkuId()))
                .setActivityStatus(activity.getStatus()));
    }

    CombinationRecordDO convert(CombinationRecordCreateReqDTO reqDTO);

    List<CombinationRecordRespDTO> convert(List<CombinationRecordDO> bean);

}
