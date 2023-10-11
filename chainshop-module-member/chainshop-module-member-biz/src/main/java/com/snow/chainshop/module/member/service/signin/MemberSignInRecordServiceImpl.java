package com.snow.chainshop.module.member.service.signin;

import com.snow.chainshop.framework.common.pojo.PageParam;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.member.api.user.MemberUserApi;
import com.snow.chainshop.module.member.api.user.dto.MemberUserRespDTO;
import com.snow.chainshop.module.member.controller.admin.signin.vo.record.MemberSignInRecordPageReqVO;
import com.snow.chainshop.module.member.dal.dataobject.signin.MemberSignInRecordDO;
import com.snow.chainshop.module.member.dal.mysql.signin.MemberSignInRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

import static com.snow.chainshop.framework.common.util.collection.CollectionUtils.convertSet;

/**
 * 签到记录 Service 实现类
 *
 * @author Chainshop
 */
@Service
@Validated
public class MemberSignInRecordServiceImpl implements MemberSignInRecordService {

    @Resource
    private MemberSignInRecordMapper memberSignInRecordMapper;

    @Resource
    private MemberUserApi memberUserApi;

    @Override
    public PageResult<MemberSignInRecordDO> getSignInRecordPage(MemberSignInRecordPageReqVO pageReqVO) {
        // 根据用户昵称查询出用户 ids
        Set<Long> userIds = null;
        if (StringUtils.isNotBlank(pageReqVO.getNickname())) {
            List<MemberUserRespDTO> users = memberUserApi.getUserListByNickname(pageReqVO.getNickname());
            // 如果查询用户结果为空直接返回无需继续查询
            if (CollectionUtils.isEmpty(users)) {
                return PageResult.empty();
            }
            userIds = convertSet(users, MemberUserRespDTO::getId);
        }
        // 分页查询
        return memberSignInRecordMapper.selectPage(pageReqVO, userIds);
    }

    @Override
    public PageResult<MemberSignInRecordDO> getSignRecordPage(Long userId, PageParam pageParam) {
        return memberSignInRecordMapper.selectPage(userId, pageParam);
    }

}
