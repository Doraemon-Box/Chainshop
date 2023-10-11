package com.snow.chainshop.module.promotion.dal.mysql.seckill.seckillactivity;

import cn.hutool.core.util.ObjectUtil;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityPageReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.seckill.seckillactivity.SeckillActivityDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 秒杀活动 Mapper
 *
 * @author halfninety
 */
@Mapper
public interface SeckillActivityMapper extends BaseMapperX<SeckillActivityDO> {

    default PageResult<SeckillActivityDO> selectPage(SeckillActivityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SeckillActivityDO>()
                .likeIfPresent(SeckillActivityDO::getName, reqVO.getName())
                .eqIfPresent(SeckillActivityDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SeckillActivityDO::getCreateTime, reqVO.getCreateTime())
                .apply(ObjectUtil.isNotNull(reqVO.getConfigId()), "FIND_IN_SET(" + reqVO.getConfigId() + ",time_ids) > 0")
                .orderByDesc(SeckillActivityDO::getId));
    }

    default List<SeckillActivityDO> selectListByStatus(Integer status) {
        return selectList(new LambdaQueryWrapperX<SeckillActivityDO>()
                .eqIfPresent(SeckillActivityDO::getStatus, status));
    }

}
