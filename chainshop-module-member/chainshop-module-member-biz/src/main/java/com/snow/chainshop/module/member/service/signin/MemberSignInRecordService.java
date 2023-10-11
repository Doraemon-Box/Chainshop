package com.snow.chainshop.module.member.service.signin;

import com.snow.chainshop.framework.common.pojo.PageParam;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.member.controller.admin.signin.vo.record.MemberSignInRecordPageReqVO;
import com.snow.chainshop.module.member.dal.dataobject.signin.MemberSignInRecordDO;

/**
 * 签到记录 Service 接口
 *
 * @author Chainshop
 */
public interface MemberSignInRecordService {

    /**
     * 【管理员】获得签到记录分页
     *
     * @param pageReqVO 分页查询
     * @return 签到记录分页
     */
    PageResult<MemberSignInRecordDO> getSignInRecordPage(MemberSignInRecordPageReqVO pageReqVO);

    /**
     * 【会员】获得签到记录分页
     *
     * @param userId 用户编号
     * @param pageParam 分页查询
     * @return 签到记录分页
     */
    PageResult<MemberSignInRecordDO> getSignRecordPage(Long userId, PageParam pageParam);

}
