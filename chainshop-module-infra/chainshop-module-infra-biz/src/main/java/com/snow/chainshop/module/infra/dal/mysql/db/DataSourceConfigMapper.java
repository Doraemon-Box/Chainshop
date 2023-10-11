package com.snow.chainshop.module.infra.dal.mysql.db;

import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author Chainshop
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
