package com.snow.chainshop.module.product.controller.app.spu;

import com.snow.chainshop.framework.common.pojo.CommonResult;
import com.snow.chainshop.framework.common.pojo.PageResult;
import com.snow.chainshop.module.product.controller.app.spu.vo.AppProductSpuDetailRespVO;
import com.snow.chainshop.module.product.controller.app.spu.vo.AppProductSpuPageRespVO;
import com.snow.chainshop.module.product.controller.app.spu.vo.AppProductSpuPageReqVO;
import com.snow.chainshop.module.product.convert.spu.ProductSpuConvert;
import com.snow.chainshop.module.product.dal.dataobject.sku.ProductSkuDO;
import com.snow.chainshop.module.product.dal.dataobject.spu.ProductSpuDO;
import com.snow.chainshop.module.product.enums.spu.ProductSpuStatusEnum;
import com.snow.chainshop.module.product.service.sku.ProductSkuService;
import com.snow.chainshop.module.product.service.spu.ProductSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.snow.chainshop.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.snow.chainshop.framework.common.pojo.CommonResult.success;
import static com.snow.chainshop.module.product.enums.ErrorCodeConstants.SPU_NOT_ENABLE;
import static com.snow.chainshop.module.product.enums.ErrorCodeConstants.SPU_NOT_EXISTS;

@Tag(name = "用户 APP - 商品 SPU")
@RestController
@RequestMapping("/product/spu")
@Validated
public class AppProductSpuController {

    @Resource
    private ProductSpuService productSpuService;
    @Resource
    private ProductSkuService productSkuService;

    @GetMapping("/list")
    @Operation(summary = "获得商品 SPU 列表")
    @Parameters({
            @Parameter(name = "recommendType", description = "推荐类型", required = true), // 参见 AppProductSpuPageReqVO.RECOMMEND_TYPE_XXX 常量
            @Parameter(name = "count", description = "数量", required = true)
    })
    public CommonResult<List<AppProductSpuPageRespVO>> getSpuList(
            @RequestParam("recommendType") String recommendType,
            @RequestParam(value = "count", defaultValue = "10") Integer count) {
        List<ProductSpuDO> list = productSpuService.getSpuList(recommendType, count);
        return success(ProductSpuConvert.INSTANCE.convertListForGetSpuList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品 SPU 分页")
    public CommonResult<PageResult<AppProductSpuPageRespVO>> getSpuPage(@Valid AppProductSpuPageReqVO pageVO) {
        PageResult<ProductSpuDO> pageResult = productSpuService.getSpuPage(pageVO);
        return success(ProductSpuConvert.INSTANCE.convertPageForGetSpuPage(pageResult));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "获得商品 SPU 明细")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<AppProductSpuDetailRespVO> getSpuDetail(@RequestParam("id") Long id) {
        // 获得商品 SPU
        ProductSpuDO spu = productSpuService.getSpu(id);
        if (spu == null) {
            throw exception(SPU_NOT_EXISTS);
        }
        if (!ProductSpuStatusEnum.isEnable(spu.getStatus())) {
            throw exception(SPU_NOT_ENABLE);
        }

        // 查询商品 SKU
        List<ProductSkuDO> skus = productSkuService.getSkuListBySpuId(spu.getId());
        // 拼接
        return success(ProductSpuConvert.INSTANCE.convertForGetSpuDetail(spu, skus));
    }

}
