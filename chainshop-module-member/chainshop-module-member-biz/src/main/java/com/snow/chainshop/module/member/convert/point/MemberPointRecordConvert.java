package com.snow.chainshop.module.member.convert.point;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.common.util.collection.MapUtils;
import com.snow.chainshop.module.member.api.user.dto.MemberUserRespDTO;
import com.snow.chainshop.module.member.controller.admin.point.vo.recrod.MemberPointRecordRespVO;
import com.snow.chainshop.module.member.controller.app.point.vo.AppMemberPointRecordRespVO;
import com.snow.chainshop.module.member.dal.dataobject.point.MemberPointRecordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static com.snow.chainshop.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * 用户积分记录 Convert
 *
 * @author QingX
 */
@Mapper
public interface MemberPointRecordConvert {

    MemberPointRecordConvert INSTANCE = Mappers.getMapper(MemberPointRecordConvert.class);

    default PageResult<MemberPointRecordRespVO> convertPage(PageResult<MemberPointRecordDO> pageResult, List<MemberUserRespDTO> users) {
        PageResult<MemberPointRecordRespVO> voPageResult = convertPage(pageResult);
        // user 拼接
        Map<Long, MemberUserRespDTO> userMap = convertMap(users, MemberUserRespDTO::getId);
        voPageResult.getList().forEach(record -> MapUtils.findAndThen(userMap, record.getUserId(),
                memberUserRespDTO -> record.setNickname(memberUserRespDTO.getNickname())));
        return voPageResult;
    }
    PageResult<MemberPointRecordRespVO> convertPage(PageResult<MemberPointRecordDO> pageResult);

    PageResult<AppMemberPointRecordRespVO> convertPage02(PageResult<MemberPointRecordDO> pageResult);

}
