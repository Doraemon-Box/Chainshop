package com.snow.chainshop.module.member.api.level;

import com.snow.chainshop.module.member.enums.MemberExperienceBizTypeEnum;
import com.snow.chainshop.module.member.service.level.MemberLevelService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.snow.chainshop.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.snow.chainshop.module.member.enums.ErrorCodeConstants.EXPERIENCE_BIZ_NOT_SUPPORT;

/**
 * 会员等级 API 实现类
 *
 * @author owen
 */
@Service
@Validated
public class MemberLevelApiImpl implements MemberLevelApi {

    @Resource
    private MemberLevelService memberLevelService;

    @Override
    public void addExperience(Long userId, Integer experience, Integer bizType, String bizId) {
        MemberExperienceBizTypeEnum bizTypeEnum = MemberExperienceBizTypeEnum.getByType(bizType);
        if (bizTypeEnum == null) {
            throw exception(EXPERIENCE_BIZ_NOT_SUPPORT);
        }
        memberLevelService.addExperience(userId, experience, bizTypeEnum, bizId);
    }

}
