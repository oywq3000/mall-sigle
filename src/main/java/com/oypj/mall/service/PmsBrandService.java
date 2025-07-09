package com.oypj.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oypj.mall.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService extends IService<PmsBrand> {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
