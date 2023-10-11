package com.snow.chainshop.module.member.convert.tag;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import com.snow.chainshop.module.member.controller.admin.tag.vo.MemberTagRespVO;
import com.snow.chainshop.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import com.snow.chainshop.module.member.dal.dataobject.tag.MemberTagDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员标签 Convert
 *
 * @author Chainshop
 */
@Mapper
public interface MemberTagConvert {

    MemberTagConvert INSTANCE = Mappers.getMapper(MemberTagConvert.class);

    MemberTagDO convert(MemberTagCreateReqVO bean);

    MemberTagDO convert(MemberTagUpdateReqVO bean);

    MemberTagRespVO convert(MemberTagDO bean);

    List<MemberTagRespVO> convertList(List<MemberTagDO> list);

    PageResult<MemberTagRespVO> convertPage(PageResult<MemberTagDO> page);

}
