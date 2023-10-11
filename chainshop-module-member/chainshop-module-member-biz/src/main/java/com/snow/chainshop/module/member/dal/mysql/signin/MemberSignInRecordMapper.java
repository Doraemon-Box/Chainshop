package com.snow.chainshop.module.member.dal.mysql.signin;

import com.snow.chainshop.framework.common.pojo.PageParam;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.module.member.controller.admin.signin.vo.record.MemberSignInRecordPageReqVO;
import com.snow.chainshop.module.member.dal.dataobject.signin.MemberSignInRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * 签到记录 Mapper
 *
 * @author Chainshop
 */
@Mapper
public interface MemberSignInRecordMapper extends BaseMapperX<MemberSignInRecordDO> {

    default PageResult<MemberSignInRecordDO> selectPage(MemberSignInRecordPageReqVO reqVO, Set<Long> userIds) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberSignInRecordDO>()
                .inIfPresent(MemberSignInRecordDO::getUserId, userIds)
                .eqIfPresent(MemberSignInRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberSignInRecordDO::getDay, reqVO.getDay())
                .betweenIfPresent(MemberSignInRecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberSignInRecordDO::getId));
    }

    default PageResult<MemberSignInRecordDO> selectPage(Long userId, PageParam pageParam) {
        return selectPage(pageParam, new LambdaQueryWrapperX<MemberSignInRecordDO>()
                .eq(MemberSignInRecordDO::getUserId, userId)
                .orderByDesc(MemberSignInRecordDO::getId));
    }

}
