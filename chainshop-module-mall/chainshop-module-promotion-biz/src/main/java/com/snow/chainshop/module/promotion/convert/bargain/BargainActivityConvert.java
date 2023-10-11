package com.snow.chainshop.module.promotion.convert.bargain;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityBaseVO;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityRespVO;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.bargain.BargainActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 拼团活动 Convert
 *
 * @author HUIHUI
 */
@Mapper
public interface BargainActivityConvert {

    BargainActivityConvert INSTANCE = Mappers.getMapper(BargainActivityConvert.class);

    BargainActivityDO convert(BargainActivityBaseVO bean);

    BargainActivityDO convert(BargainActivityUpdateReqVO bean);

    BargainActivityRespVO convert(BargainActivityDO bean);

    List<BargainActivityRespVO> convertList(List<BargainActivityDO> list);

    PageResult<BargainActivityRespVO> convertPage(PageResult<BargainActivityDO> page);

}
