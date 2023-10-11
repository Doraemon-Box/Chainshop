package com.snow.chainshop.module.product.convert.property;

import cn.hutool.core.collection.CollUtil;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.common.util.collection.CollectionUtils;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyAndValueRespVO;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyCreateReqVO;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyRespVO;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyUpdateReqVO;
import com.snow.chainshop.module.product.dal.dataobject.property.ProductPropertyDO;
import com.snow.chainshop.module.product.dal.dataobject.property.ProductPropertyValueDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.snow.chainshop.framework.common.pojo.CommonResult.success;

/**
 * 属性项 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface ProductPropertyConvert {

    ProductPropertyConvert INSTANCE = Mappers.getMapper(ProductPropertyConvert.class);

    ProductPropertyDO convert(ProductPropertyCreateReqVO bean);

    ProductPropertyDO convert(ProductPropertyUpdateReqVO bean);

    ProductPropertyRespVO convert(ProductPropertyDO bean);

    List<ProductPropertyRespVO> convertList(List<ProductPropertyDO> list);

    PageResult<ProductPropertyRespVO> convertPage(PageResult<ProductPropertyDO> page);

    default List<ProductPropertyAndValueRespVO> convertList(List<ProductPropertyDO> keys, List<ProductPropertyValueDO> values) {
        Map<Long, List<ProductPropertyValueDO>> valueMap = CollectionUtils.convertMultiMap(values, ProductPropertyValueDO::getPropertyId);
        return CollectionUtils.convertList(keys, key -> {
            ProductPropertyAndValueRespVO respVO = convert02(key);
            // 如果属性值为空value不为null,返回空列表
            if (CollUtil.isEmpty(values)) {
                respVO.setValues(Collections.emptyList());
            }else {
                respVO.setValues(convertList02(valueMap.get(key.getId())));
            }
            return respVO;
        });
    }
    ProductPropertyAndValueRespVO convert02(ProductPropertyDO bean);
    List<ProductPropertyAndValueRespVO.Value> convertList02(List<ProductPropertyValueDO> list);

}
