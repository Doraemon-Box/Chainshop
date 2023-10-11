package com.snow.chainshop.module.system.api.social;

import com.snow.chainshop.module.system.api.social.dto.SocialUserBindReqDTO;
import com.snow.chainshop.module.system.api.social.dto.SocialUserRespDTO;
import com.snow.chainshop.module.system.api.social.dto.SocialUserUnbindReqDTO;
import com.snow.chainshop.module.system.service.social.SocialUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 社交用户的 API 实现类
 *
 * @author Chainshop
 */
@Service
@Validated
public class SocialUserApiImpl implements SocialUserApi {

    @Resource
    private SocialUserService socialUserService;

    @Override
    public String getAuthorizeUrl(Integer type, String redirectUri) {
        return socialUserService.getAuthorizeUrl(type, redirectUri);
    }

    @Override
    public String bindSocialUser(SocialUserBindReqDTO reqDTO) {
        return socialUserService.bindSocialUser(reqDTO);
    }

    @Override
    public void unbindSocialUser(SocialUserUnbindReqDTO reqDTO) {
        socialUserService.unbindSocialUser(reqDTO.getUserId(), reqDTO.getUserType(),
                reqDTO.getType(), reqDTO.getUnionId());
    }

    @Override
    public SocialUserRespDTO getSocialUser(Integer userType, Integer type, String code, String state) {
       return socialUserService.getSocialUser(userType, type, code, state);
    }

}
