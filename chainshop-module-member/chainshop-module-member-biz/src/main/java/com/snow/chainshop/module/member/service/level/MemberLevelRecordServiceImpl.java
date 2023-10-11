package com.snow.chainshop.module.member.service.level;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.member.controller.admin.level.vo.record.MemberLevelRecordPageReqVO;
import com.snow.chainshop.module.member.dal.dataobject.level.MemberLevelRecordDO;
import com.snow.chainshop.module.member.dal.mysql.level.MemberLevelRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 会员等级记录 Service 实现类
 *
 * @author owen
 */
@Service
@Validated
public class MemberLevelRecordServiceImpl implements MemberLevelRecordService {

    @Resource
    private MemberLevelRecordMapper levelLogMapper;

    @Override
    public MemberLevelRecordDO getLevelRecord(Long id) {
        return levelLogMapper.selectById(id);
    }

    @Override
    public PageResult<MemberLevelRecordDO> getLevelRecordPage(MemberLevelRecordPageReqVO pageReqVO) {
        return levelLogMapper.selectPage(pageReqVO);
    }

    @Override
    public void createLevelRecord(MemberLevelRecordDO levelRecord) {
        levelLogMapper.insert(levelRecord);
    }

}
