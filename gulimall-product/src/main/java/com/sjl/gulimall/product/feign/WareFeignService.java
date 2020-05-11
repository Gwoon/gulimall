package com.sjl.gulimall.product.feign;

import com.sjl.common.to.SkuHasStockTo;
import com.sjl.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author songjilong
 * @date 2020/5/11 15:00
 */
@FeignClient("gulimall-ware")
public interface WareFeignService {

    @GetMapping("/ware/waresku/hasstock")
    R<List<SkuHasStockTo>> getSkuHasStock(@RequestBody List<Long> skuIds);
}
