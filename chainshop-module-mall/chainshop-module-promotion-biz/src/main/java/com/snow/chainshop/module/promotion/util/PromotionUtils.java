package com.snow.chainshop.module.promotion.util;

import com.snow.chainshop.framework.common.enums.CommonStatusEnum;
import com.snow.chainshop.framework.common.util.date.LocalDateTimeUtils;

import java.time.LocalDateTime;

/**
 * 活动工具类
 *
 * @author Chainshop
 */
public class PromotionUtils {

    /**
     * 根据时间，计算活动状态
     *
     * @param endTime 结束时间
     * @return 活动状态
     */
    public static Integer calculateActivityStatus(LocalDateTime endTime) {
        return LocalDateTimeUtils.beforeNow(endTime) ? CommonStatusEnum.DISABLE.getStatus() : CommonStatusEnum.ENABLE.getStatus();
    }

}
