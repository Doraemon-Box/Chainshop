package com.snow.chainshop.module.promotion.controller.app.bargain;

import com.snow.chainshop.framework.common.pojo.CommonResult;
import com.snow.chainshop.module.promotion.controller.app.bargain.vo.help.AppBargainHelpCreateReqVO;
import com.snow.chainshop.module.promotion.controller.app.bargain.vo.help.AppBargainHelpRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.snow.chainshop.framework.common.pojo.CommonResult.success;

@Tag(name = "用户 App - 砍价助力")
@RestController
@RequestMapping("/promotion/bargain-help")
@Validated
public class AppBargainHelpController {

    @PostMapping("/create")
    @Operation(summary = "创建砍价助力", description = "给拼团记录砍一刀") // 返回结果为砍价金额，单位：分
    public CommonResult<Long> createBargainHelp(@RequestBody AppBargainHelpCreateReqVO reqVO) {
         return success(20L);
    }

    @GetMapping("/list")
    @Operation(summary = "获得砍价助力列表")
    // TODO 芋艿：swagger
    public CommonResult<List<AppBargainHelpRespVO>> getBargainHelpList(@RequestParam("recordId") Long recordId) {
        List<AppBargainHelpRespVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AppBargainHelpRespVO vo = new AppBargainHelpRespVO();
            vo.setNickname("用户" + i);
            vo.setAvatar("https://www.iocoder.cn/avatar/" + i + ".jpg");
            vo.setReducePrice((i + 1) * 100);
            vo.setCreateTime(LocalDateTime.now());
            list.add(vo);
        }
        return success(list);
    }

}
