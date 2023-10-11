package com.snow.chainshop.module.promotion.service.bargain;

import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityCreateReqVO;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityPageReqVO;
import com.snow.chainshop.module.promotion.controller.admin.bargain.vo.BargainActivityUpdateReqVO;
import com.snow.chainshop.module.promotion.dal.dataobject.bargain.BargainActivityDO;

import javax.validation.Valid;

/**
 * 砍价活动 Service 接口
 *
 * @author HUIHUI
 */
public interface BargainActivityService {

    /**
     * 创建砍价活动
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBargainActivity(@Valid BargainActivityCreateReqVO createReqVO);

    /**
     * 更新砍价活动
     *
     * @param updateReqVO 更新信息
     */
    void updateBargainActivity(@Valid BargainActivityUpdateReqVO updateReqVO);

    /**
     * 删除砍价活动
     *
     * @param id 编号
     */
    void deleteBargainActivity(Long id);

    /**
     * 获得砍价活动
     *
     * @param id 编号
     * @return 砍价活动
     */
    BargainActivityDO getBargainActivity(Long id);

    /**
     * 获得砍价活动分页
     *
     * @param pageReqVO 分页查询
     * @return 砍价活动分页
     */
    PageResult<BargainActivityDO> getBargainActivityPage(BargainActivityPageReqVO pageReqVO);


}
