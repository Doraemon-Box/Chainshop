package com.snow.chainshop.module.trade.controller.app.brokerage.vo.record;

import com.snow.chainshop.framework.common.pojo.PageParam;
import com.snow.chainshop.framework.common.validation.InEnum;
import com.snow.chainshop.module.trade.enums.brokerage.BrokerageRecordBizTypeEnum;
import com.snow.chainshop.module.trade.enums.brokerage.BrokerageRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "应用 App - 分销记录分页 Request VO")
@Data
public class AppBrokerageRecordPageReqVO extends PageParam {

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = BrokerageRecordBizTypeEnum.class, message = "业务类型必须是 {value}")
    private Integer bizType;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = BrokerageRecordStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

}
