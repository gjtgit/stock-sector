package com.gao.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.SectorEntity;
import com.gao.demo.model.AvgStockPriceVo;
import com.gao.demo.service.CompanyClient;
import com.gao.demo.service.SectorService;

@RestController
public class SectorController {
    
    Logger logger = LoggerFactory.getLogger(SectorController.class);
    
    @Autowired
    private SectorService sectorService;
    
    @Autowired
    private CompanyClient companyClient;
    
    @RequestMapping(path="/sectors/{id}",method=RequestMethod.GET)
    public SectorEntity getSectorDetails(@PathVariable Long id) throws Exception{
        return this.sectorService.findById(id);
    }
    
    @RequestMapping(path="/sectors",method=RequestMethod.GET)
    public List<SectorEntity> getSectorList() throws Exception{
        return this.sectorService.getSectorList();
    }
    
    //getList of Companies in a Sector
    @RequestMapping(path="/sectorcompanies/{sectorId}",method=RequestMethod.GET)
    public List<CompanyEntity> getCompanyListBySectorId(@PathVariable Long sectorId )throws Exception{
        List<CompanyEntity> l = this.sectorService.getCompanyListBySectorId(sectorId);
        return l;
    }
    
    @RequestMapping(path="/sectorprice/{sectorId}",method=RequestMethod.GET)
    public List<AvgStockPriceVo> getSectorStockPrice(@PathVariable Long sectorId, 
            @RequestParam String stockExchange, @RequestParam String fromDate, @RequestParam String toDate) throws Exception{
        List<AvgStockPriceVo> l = this.sectorService.getSectorStockPriceByIdAndExAndPeriod(sectorId, stockExchange, fromDate, toDate);
        return l;
    } 
    
    @PostMapping("/test")
    public String test(){
        return "{\"str\":\"from stock-sector post\"}";
    }
 
}
