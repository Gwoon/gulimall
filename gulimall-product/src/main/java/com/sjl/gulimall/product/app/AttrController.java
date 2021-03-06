package com.sjl.gulimall.product.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sjl.gulimall.product.entity.ProductAttrValueEntity;
import com.sjl.gulimall.product.vo.AttrRespVo;
import com.sjl.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjl.gulimall.product.service.AttrService;
import com.sjl.common.utils.PageUtils;
import com.sjl.common.utils.R;


/**
 * 商品属性
 *
 * @author songjilong
 * @email 2606587750@qq.com
 * @date 2020-04-01 23:18:20
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 更新spu属性
     */
    @RequestMapping("/update/{spuId}")
    public R updateAttrValueBySpuId(@PathVariable("spuId") Long spuId,
                                    @RequestBody List<ProductAttrValueEntity> attrValues) {
        attrService.updateAttrValueBySpuId(spuId, attrValues);

        return R.ok();
    }

    /**
     * 获取spu属性
     */
    @RequestMapping("/base/listforspu/{spuId}")
    public R listAttrValueForSpu(@PathVariable("spuId") Long spuId) {
        List<ProductAttrValueEntity> spuInfo = attrService.listAttrValueForSpu(spuId);

        return R.ok().put("data", spuInfo);
    }

    /**
     * 根据分类获取属性
     */
    @RequestMapping("/{attrType}/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("attrType") String attrType,
                  @PathVariable("catelogId") Long catelogId) {
        PageUtils page = attrService.queryBaseAttrPage(params, attrType, catelogId);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId) {
        AttrRespVo attrInfo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", attrInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attrVo) {
        attrService.saveAttr(attrVo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attrVo) {
        attrService.updateAttr(attrVo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
