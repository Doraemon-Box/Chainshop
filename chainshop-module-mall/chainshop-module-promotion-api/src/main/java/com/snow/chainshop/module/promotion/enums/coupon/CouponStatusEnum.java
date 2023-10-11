package com.snow.chainshop.module.promotion.enums.coupon;

import com.snow.chainshop.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 优惠劵状态枚举
 *
 * @author Chainshop
 */
@AllArgsConstructor
@Getter
public enum CouponStatusEnum implements IntArrayValuable {

    UNUSED(1, "未使用"),
    USED(2, "已使用"),
    EXPIRE(3, "已过期"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CouponStatusEnum::getStatus).toArray();

    /**
     * 值
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}
