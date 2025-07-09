package com.oypj.mall.controller;

import com.oypj.mall.common.api.CommonPage;
import com.oypj.mall.common.api.CommonResult;
import com.oypj.mall.mbg.model.PmsBrand;
import com.oypj.mall.service.PmsBrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author oy
 * @description 品牌管理Controller
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */

@Tag(name = "pmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
@Slf4j
public class pmsBrandController {
    private final PmsBrandService brandService;

    @Operation(summary = "获取所有品牌列表")
    @GetMapping("listAll")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    @Operation(summary = "添加商品")
    @PostMapping("/create")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }
    @Operation(summary = "更新指定id品牌信息")
    @PostMapping("/update/{id}")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            log.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @Operation(summary = "删除指定id的品牌")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @Operation(summary = "分页查询品牌列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @Operation(summary = "获取指定id的品牌详情")
    @GetMapping("/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        PmsBrand brand = brandService.getBrand(id);
        return CommonResult.success(brand);
    }
}
