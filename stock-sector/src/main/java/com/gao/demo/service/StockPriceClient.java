package com.gao.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gao.demo.entity.StockPriceEntity;
import com.gao.demo.model.AvgStockPriceVo;

@FeignClient(name="service-upload",fallback=StockPriceClientHystric.class, url="http://localhost:8081")
public interface StockPriceClient {
    
    @RequestMapping(path="/stockprice",method = RequestMethod.GET)
    public List<StockPriceEntity> getStockPriceByComIdAndExAndPeriod(
            @RequestParam Long companyId, @RequestParam String stockExchange,
            @RequestParam String fromDate, @RequestParam String toDate);
    
    @RequestMapping(path="/getStockPriceByComIdListAndExAndPeriod",method = RequestMethod.GET)
    public List<AvgStockPriceVo> getStockPriceByComIdListAndExAndPeriod(
            @RequestParam List<Long> companyIdList, @RequestParam String stockExchange,
            @RequestParam String fromDate, @RequestParam String toDate);
    
}
