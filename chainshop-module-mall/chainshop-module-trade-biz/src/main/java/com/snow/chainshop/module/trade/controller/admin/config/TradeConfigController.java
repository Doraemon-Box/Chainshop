package com.snow.chainshop.module.trade.controller.admin.config;

import com.snow.chainshop.framework.common.pojo.CommonResult;
import com.snow.chainshop.module.trade.controller.admin.config.vo.TradeConfigRespVO;
import com.snow.chainshop.module.trade.controller.admin.config.vo.TradeConfigSaveReqVO;
import com.snow.chainshop.module.trade.convert.config.TradeConfigConvert;
import com.snow.chainshop.module.trade.dal.dataobject.config.TradeConfigDO;
import com.snow.chainshop.module.trade.service.config.TradeConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.snow.chainshop.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 交易中心配置")
@RestController
@RequestMapping("/trade/config")
@Validated
public class TradeConfigController {

    @Resource
    private TradeConfigService tradeConfigService;

    @PutMapping("/save")
    @Operation(summary = "更新交易中心配置")
    @PreAuthorize("@ss.hasPermission('trade:config:save')")
    public CommonResult<Boolean> updateConfig(@Valid @RequestBody TradeConfigSaveReqVO updateReqVO) {
        tradeConfigService.saveTradeConfig(updateReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得交易中心配置")
    @PreAuthorize("@ss.hasPermission('trade:config:query')")
    public CommonResult<TradeConfigRespVO> getConfig() {
        TradeConfigDO config = tradeConfigService.getTradeConfig();
        return success(TradeConfigConvert.INSTANCE.convert(config));
    }

}
