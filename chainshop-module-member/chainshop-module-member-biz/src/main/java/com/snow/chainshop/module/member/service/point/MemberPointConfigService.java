package com.snow.chainshop.module.member.service.point;

import com.snow.chainshop.module.member.controller.admin.point.vo.config.MemberPointConfigSaveReqVO;
import com.snow.chainshop.module.member.dal.dataobject.point.MemberPointConfigDO;

import javax.validation.Valid;

/**
 * 会员积分配置 Service 接口
 *
 * @author QingX
 */
public interface MemberPointConfigService {

    /**
     * 保存会员积分配置
     *
     * @param saveReqVO 更新信息
     */
    void savePointConfig(@Valid MemberPointConfigSaveReqVO saveReqVO);

    /**
     * 获得会员积分配置
     *
     * @return 积分配置
     */
    MemberPointConfigDO getPointConfig();

}
