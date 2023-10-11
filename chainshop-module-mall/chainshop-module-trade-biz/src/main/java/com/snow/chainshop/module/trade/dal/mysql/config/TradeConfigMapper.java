package com.snow.chainshop.module.trade.dal.mysql.config;

import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.module.trade.dal.dataobject.config.TradeConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易中心配置 Mapper
 *
 * @author owen
 */
@Mapper
public interface TradeConfigMapper extends BaseMapperX<TradeConfigDO> {

}
