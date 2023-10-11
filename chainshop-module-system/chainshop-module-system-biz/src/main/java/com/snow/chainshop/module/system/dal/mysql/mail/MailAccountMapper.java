package com.snow.chainshop.module.system.dal.mysql.mail;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.framework.mybatis.core.mapper.BaseMapperX;
import com.snow.chainshop.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.snow.chainshop.framework.mybatis.core.query.QueryWrapperX;
import com.snow.chainshop.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import com.snow.chainshop.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}
