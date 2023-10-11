package com.snow.chainshop.module.infra.convert.logger;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.snow.chainshop.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.snow.chainshop.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import com.snow.chainshop.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
