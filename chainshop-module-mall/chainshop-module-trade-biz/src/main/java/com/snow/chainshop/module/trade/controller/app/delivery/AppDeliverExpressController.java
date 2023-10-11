package com.snow.chainshop.module.trade.controller.app.delivery;

import com.snow.chainshop.framework.common.enums.CommonStatusEnum;
import com.snow.chainshop.framework.common.pojo.CommonResult;
import com.snow.chainshop.module.trade.controller.app.delivery.vo.express.AppDeliveryExpressRespVO;
import com.snow.chainshop.module.trade.convert.delivery.DeliveryExpressConvert;
import com.snow.chainshop.module.trade.dal.dataobject.delivery.DeliveryExpressDO;
import com.snow.chainshop.module.trade.service.delivery.DeliveryExpressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

import static com.snow.chainshop.framework.common.pojo.CommonResult.success;

@Tag(name = "用户 App - 快递公司")
@RestController
@RequestMapping("/trade/delivery/express")
@Validated
public class AppDeliverExpressController {

    @Resource
    private DeliveryExpressService deliveryExpressService;

    @GetMapping("/list")
    @Operation(summary = "获得快递公司列表")
    public CommonResult<List<AppDeliveryExpressRespVO>> getDeliveryExpressList() {
        List<DeliveryExpressDO> list = deliveryExpressService.getDeliveryExpressListByStatus(CommonStatusEnum.ENABLE.getStatus());
        list.sort(Comparator.comparing(DeliveryExpressDO::getSort));
        return success(DeliveryExpressConvert.INSTANCE.convertList03(list));
    }

}
