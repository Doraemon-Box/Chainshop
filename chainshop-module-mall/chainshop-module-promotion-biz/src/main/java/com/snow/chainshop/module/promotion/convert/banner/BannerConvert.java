package com.snow.chainshop.module.promotion.convert.banner;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.banner.vo.BannerCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.banner.vo.BannerRespVO;
import com.snow.chainshop.module.promotion.controller.admin.banner.vo.BannerUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.banner.BannerDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BannerConvert {

    BannerConvert INSTANCE = Mappers.getMapper(BannerConvert.class);

    List<BannerRespVO> convertList(List<BannerDO> list);

    PageResult<BannerRespVO> convertPage(PageResult<BannerDO> pageResult);

    BannerRespVO convert(BannerDO banner);

    BannerDO convert(BannerCreateReqVO createReqVO);

    BannerDO convert(BannerUpdateReqVO updateReqVO);

}
