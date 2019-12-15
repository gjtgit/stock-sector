package com.gao.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.StockPriceEntity;

@FeignClient(name="service-company",fallback=CompanyClientHystric.class, url="http://localhost:8082")
public interface CompanyClient {
    
    @RequestMapping(path="/sectorcompanies",method = RequestMethod.GET)
    public List<CompanyEntity> getCompanyListBySectorId(@RequestParam Long sectorId);

}
