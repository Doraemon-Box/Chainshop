package com.snow.chainshop.module.infra.dal.mysql.logger;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import com.snow.chainshop.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import com.snow.chainshop.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * API 访问日志 Mapper
 *
 * @author Chainshop
 */
@Mapper
public interface ApiAccessLogMapper extends BaseMapperX<ApiAccessLogDO> {

    default PageResult<ApiAccessLogDO> selectPage(ApiAccessLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ApiAccessLogDO>()
                .eqIfPresent(ApiAccessLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ApiAccessLogDO::getUserType, reqVO.getUserType())
                .eqIfPresent(ApiAccessLogDO::getApplicationName, reqVO.getApplicationName())
                .likeIfPresent(ApiAccessLogDO::getRequestUrl, reqVO.getRequestUrl())
                .betweenIfPresent(ApiAccessLogDO::getBeginTime, reqVO.getBeginTime())
                .geIfPresent(ApiAccessLogDO::getDuration, reqVO.getDuration())
                .eqIfPresent(ApiAccessLogDO::getResultCode, reqVO.getResultCode())
                .orderByDesc(ApiAccessLogDO::getId)
        );
    }

    default List<ApiAccessLogDO> selectList(ApiAccessLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ApiAccessLogDO>()
                .eqIfPresent(ApiAccessLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ApiAccessLogDO::getUserType, reqVO.getUserType())
                .eqIfPresent(ApiAccessLogDO::getApplicationName, reqVO.getApplicationName())
                .likeIfPresent(ApiAccessLogDO::getRequestUrl, reqVO.getRequestUrl())
                .betweenIfPresent(ApiAccessLogDO::getBeginTime, reqVO.getBeginTime())
                .geIfPresent(ApiAccessLogDO::getDuration, reqVO.getDuration())
                .eqIfPresent(ApiAccessLogDO::getResultCode, reqVO.getResultCode())
                .orderByDesc(ApiAccessLogDO::getId)
        );
    }

}
