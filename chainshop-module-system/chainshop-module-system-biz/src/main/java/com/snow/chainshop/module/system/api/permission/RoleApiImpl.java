package com.snow.chainshop.module.system.api.permission;

import com.snow.chainshop.module.system.service.permission.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 角色 API 实现类
 *
 * @author Chainshop
 */
@Service
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public void validRoleList(Collection<Long> ids) {
        roleService.validateRoleList(ids);
    }
}
