package com.snow.chainshop.module.system.framework.datapermission.config;

import com.snow.chainshop.module.system.dal.dataobject.dept.DeptDO;
import com.snow.chainshop.module.system.dal.dataobject.user.AdminUserDO;
import com.snow.chainshop.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的数据权限 Configuration
 *
 * @author Chainshop
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer() {
        return rule -> {
            // dept
            rule.addDeptColumn(AdminUserDO.class);
            rule.addDeptColumn(DeptDO.class, "id");
            // user
            rule.addUserColumn(AdminUserDO.class, "id");
        };
    }

}
