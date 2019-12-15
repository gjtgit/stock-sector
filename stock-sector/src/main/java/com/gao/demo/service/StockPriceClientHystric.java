package com.gao.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.gao.demo.entity.StockPriceEntity;
import com.gao.demo.model.AvgStockPriceVo;

@Component
public class StockPriceClientHystric implements StockPriceClient {
    
    Logger logger = LoggerFactory.getLogger(StockPriceClientHystric.class);
 
    @Override
    public List<StockPriceEntity>  getStockPriceByComIdAndExAndPeriod(Long sectorId, String stockExchange, String fromDate, String toDate) {
        logger.info("[error]:getStockPriceByComIdAndExAndPeriod --- Call service-upload failed.");
        return null;
    }
    
    public List<AvgStockPriceVo> getStockPriceByComIdListAndExAndPeriod(
            @RequestParam List<Long> companyIdList, @RequestParam String stockExchange,
            @RequestParam String fromDate, @RequestParam String toDate){
        logger.info("[error]:getStockPriceByComIdListAndExAndPeriod --- Call service-upload failed.");
        return null;
    }

}
