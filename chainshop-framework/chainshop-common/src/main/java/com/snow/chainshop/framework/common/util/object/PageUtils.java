package com.snow.chainshop.framework.common.util.object;

import com.snow.chainshop.framework.common.pojo.PageParam;

/**
 * {@link com.snow.chainshop.framework.common.pojo.PageParam} 工具类
 *
 * @author Chainshop
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
