package com.snow.chainshop.module.trade.enums.delivery;

import com.snow.chainshop.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 配送方式枚举
 *
 * @author Chainshop
 */
@Getter
@AllArgsConstructor
public enum DeliveryTypeEnum implements IntArrayValuable {

    NULL(0, "无需物流"),
    EXPRESS(1, "快递发货"),
    PICK_UP(2, "用户自提"),;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(DeliveryTypeEnum::getMode).toArray();

    /**
     * 配送方式
     */
    private final Integer mode;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}
