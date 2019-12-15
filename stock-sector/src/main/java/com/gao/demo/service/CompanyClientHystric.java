package com.gao.demo.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.StockPriceEntity;

@Component
public class CompanyClientHystric implements CompanyClient {
    
    Logger logger = LoggerFactory.getLogger(CompanyClientHystric.class);
 
    @Override
    public List<CompanyEntity>  getCompanyListBySectorId(Long sectorId) {
        logger.info("[error]:getCompanyListBySectorId --- Call service-company failed.");
        return null;
    }


}
