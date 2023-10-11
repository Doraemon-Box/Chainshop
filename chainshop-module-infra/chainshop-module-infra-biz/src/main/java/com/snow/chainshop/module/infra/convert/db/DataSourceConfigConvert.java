package com.snow.chainshop.module.infra.convert.db;

import java.util.*;

import com.snow.chainshop.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.snow.chainshop.module.infra.controller.admin.db.vo.*;
import com.snow.chainshop.module.infra.dal.dataobject.db.DataSourceConfigDO;

/**
 * 数据源配置 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
