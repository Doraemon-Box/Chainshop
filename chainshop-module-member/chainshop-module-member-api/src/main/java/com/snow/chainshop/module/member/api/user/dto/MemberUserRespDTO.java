package com.snow.chainshop.module.member.api.user.dto;

import com.snow.chainshop.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * 用户信息 Response DTO
 *
 * @author Chainshop
 */
@Data
public class MemberUserRespDTO {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 帐号状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 手机
     */
    private String mobile;

}
