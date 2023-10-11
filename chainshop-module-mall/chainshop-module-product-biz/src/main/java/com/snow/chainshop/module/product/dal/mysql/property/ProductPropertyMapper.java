package com.snow.chainshop.module.product.dal.mysql.property;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyListReqVO;
import com.snow.chainshop.module.product.controller.admin.property.vo.property.ProductPropertyPageReqVO;
import com.snow.chainshop.module.product.dal.dataobject.property.ProductPropertyDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPropertyMapper extends BaseMapperX<ProductPropertyDO> {

    default PageResult<ProductPropertyDO> selectPage(ProductPropertyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPropertyDO>()
                .likeIfPresent(ProductPropertyDO::getName, reqVO.getName())
                .betweenIfPresent(ProductPropertyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductPropertyDO::getId));
    }

    default ProductPropertyDO selectByName(String name) {
        return selectOne(ProductPropertyDO::getName, name);
    }

    default List<ProductPropertyDO> selectList(ProductPropertyListReqVO listReqVO) {
        return selectList(new LambdaQueryWrapperX<ProductPropertyDO>()
                .eqIfPresent(ProductPropertyDO::getName, listReqVO.getName()));
    }

}
