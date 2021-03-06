package com.sjl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjl.common.utils.PageUtils;
import com.sjl.gulimall.product.entity.AttrEntity;
import com.sjl.gulimall.product.entity.ProductAttrValueEntity;
import com.sjl.gulimall.product.vo.AttrRespVo;
import com.sjl.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author songjilong
 * @email 2606587750@qq.com
 * @date 2020-04-01 23:18:20
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attrVo);

    PageUtils queryBaseAttrPage(Map<String, Object> params, String attrType, Long catelogId);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attrVo);

    List<AttrEntity> getAttrRelation(Long attrGroupId);

    PageUtils getAttrNoRelation(Map<String, Object> params, Long attrGroupId);

    List<ProductAttrValueEntity> listAttrValueForSpu(Long spuId);

    void updateAttrValueBySpuId(Long spuId, List<ProductAttrValueEntity> attrValues);

    /**
     * 查询可被检索的属性，返回其id集
     */
    List<Long> querySearchAttrIds(List<Long> attrIds);
}

