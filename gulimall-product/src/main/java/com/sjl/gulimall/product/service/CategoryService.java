package com.sjl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjl.common.utils.PageUtils;
import com.sjl.gulimall.product.entity.CategoryEntity;
import com.sjl.gulimall.product.vo.Catalog2Vo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author songjilong
 * @email 2606587750@qq.com
 * @date 2020-04-01 23:18:20
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    /**
     * 找到指定分类id的完整三级分类路径 [父、子、孙]
     * e.g.[2, 25, 225]
     * @param catelogId 当前id
     * @return
     */
    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);

    List<CategoryEntity> getLevel1Categories();

    Map<String, List<Catalog2Vo>> getCatalogJson();
}

