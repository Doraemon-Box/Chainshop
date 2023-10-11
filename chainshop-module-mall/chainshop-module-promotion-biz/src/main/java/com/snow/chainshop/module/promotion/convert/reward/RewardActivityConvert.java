package com.snow.chainshop.module.promotion.convert.reward;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.reward.vo.RewardActivityCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.reward.vo.RewardActivityRespVO;
import com.snow.chainshop.module.promotion.controller.admin.reward.vo.RewardActivityUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.reward.RewardActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 满减送活动 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface RewardActivityConvert {

    RewardActivityConvert INSTANCE = Mappers.getMapper(RewardActivityConvert.class);

    RewardActivityDO convert(RewardActivityCreateReqVO bean);

    RewardActivityDO convert(RewardActivityUpdateReqVO bean);

    RewardActivityRespVO convert(RewardActivityDO bean);

    PageResult<RewardActivityRespVO> convertPage(PageResult<RewardActivityDO> page);

}
