package com.sjl.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjl.common.utils.PageUtils;
import com.sjl.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author songjilong
 * @email 2606587750@qq.com
 * @date 2020-04-02 01:09:01
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

