package com.snow.chainshop.module.promotion.convert.seckill.seckillconfig;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.seckill.vo.config.SeckillConfigCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.seckill.vo.config.SeckillConfigRespVO;
import com.snow.chainshop.module.promotion.controller.admin.seckill.vo.config.SeckillConfigSimpleRespVO;
import com.snow.chainshop.module.promotion.controller.admin.seckill.vo.config.SeckillConfigUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.seckill.seckillconfig.SeckillConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 秒杀时段 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface SeckillConfigConvert {

    SeckillConfigConvert INSTANCE = Mappers.getMapper(SeckillConfigConvert.class);

    SeckillConfigDO convert(SeckillConfigCreateReqVO bean);

    SeckillConfigDO convert(SeckillConfigUpdateReqVO bean);

    SeckillConfigRespVO convert(SeckillConfigDO bean);

    List<SeckillConfigRespVO> convertList(List<SeckillConfigDO> list);

    List<SeckillConfigSimpleRespVO> convertList1(List<SeckillConfigDO> list);

    PageResult<SeckillConfigRespVO> convertPage(PageResult<SeckillConfigDO> page);

}
