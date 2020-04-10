package com.sjl.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sjl.gulimall.product.entity.AttrEntity;
import com.sjl.gulimall.product.service.AttrAttrgroupRelationService;
import com.sjl.gulimall.product.service.AttrService;
import com.sjl.gulimall.product.service.CategoryService;
import com.sjl.gulimall.product.vo.AttrRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjl.gulimall.product.entity.AttrGroupEntity;
import com.sjl.gulimall.product.service.AttrGroupService;
import com.sjl.common.utils.PageUtils;
import com.sjl.common.utils.R;


/**
 * 属性分组
 *
 * @author songjilong
 * @email 2606587750@qq.com
 * @date 2020-04-01 23:18:20
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttrService attrService;
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 获取属性与属性分组关联数据
     * @param attrGroupId 属性分组id
     * @return
     */
    @GetMapping("/{attrgroupId}/attr/relation")
    public R getAttrGroupRelation(@PathVariable("attrgroupId") Long attrGroupId) {
        List<AttrEntity> data = attrService.getAttrGroupRelation(attrGroupId);
        return R.ok().put("data", data);
    }

    /**
     * 批量删除属性与属性分组关联数据
     * @param vos 删除需要的参数数组
     * @return
     */
    @PostMapping("/attr/relation/delete")
    public R deleteAttrGroupRelation(@RequestBody AttrRelationVo[] vos) {
        attrAttrgroupRelationService.deleteAttrGroupRelation(vos);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId) {
        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long[] catelogPath = categoryService.findCatelogPath(attrGroup.getCatelogId());
        attrGroup.setCatelogPath(catelogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
