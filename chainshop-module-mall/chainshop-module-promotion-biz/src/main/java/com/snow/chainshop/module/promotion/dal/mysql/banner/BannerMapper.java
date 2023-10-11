package com.snow.chainshop.module.promotion.dal.mysql.banner;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.module.promotion.controller.admin.banner.vo.BannerPageReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.banner.BannerDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Banner Mapper
 *
 * @author xia
 */
@Mapper
public interface BannerMapper extends BaseMapperX<BannerDO> {

    default PageResult<BannerDO> selectPage(BannerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BannerDO>()
                .likeIfPresent(BannerDO::getTitle, reqVO.getTitle())
                .eqIfPresent(BannerDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BannerDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BannerDO::getSort));
    }

}
