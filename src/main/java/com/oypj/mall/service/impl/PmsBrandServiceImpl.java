package com.oypj.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.oypj.mall.mapper.PmsBrandMapper;
import com.oypj.mall.mbg.model.PmsBrand;
import com.oypj.mall.mbg.model.PmsBrandExample;
import com.oypj.mall.service.PmsBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper,PmsBrand> implements PmsBrandService {


    @Override
    public List<PmsBrand> listAllBrand() {
        return list();
    }

    @Override
    public int createBrand(PmsBrand brand) {
        boolean isSave = save(brand);
        if(isSave) return 1;
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        boolean isUpdated = updateById(brand);
        if(isUpdated) return 1;
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
