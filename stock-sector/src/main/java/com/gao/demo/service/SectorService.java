package com.gao.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.SectorEntity;
import com.gao.demo.model.AvgStockPriceVo;
import com.gao.demo.model.SectorStockPriceVo;
import com.gao.demo.repository.SectorRepo;

@Service
public class SectorService {
    
    Logger logger = LoggerFactory.getLogger(SectorService.class);
    
    @Autowired
    private SectorRepo sectorRepo;
    
    @Autowired
    private CompanyClient companyClient;
    
    @Autowired
    private StockPriceClient stockPriceClient;
    
    public SectorEntity findById(Long id) throws Exception{
        SectorEntity sectorEntity = null;
        try {
            Optional<SectorEntity> u = sectorRepo.findById(id);
            if(u.isPresent()) {
                sectorEntity = u.get();
            }
            return sectorEntity;
        }catch(Exception e) {
            throw new Exception(e);
        }
    }
    
    public List<SectorEntity> getSectorList() throws Exception{
        return sectorRepo.findAll();
    }
    
    public List<CompanyEntity> getCompanyListBySectorId(Long sectorId) throws Exception{
        logger.info("--- call service-company ---");
        return this.companyClient.getCompanyListBySectorId(sectorId);
    }
    
    public List<AvgStockPriceVo> getSectorStockPriceByIdAndExAndPeriod(Long sectorId, String stockExchange, String fromDate, String toDate) throws Exception{
        logger.info("--- sectorService.getSectorStockPriceByIdAndExAndPeriod service ---");
        List<AvgStockPriceVo> splist = new ArrayList<AvgStockPriceVo>();
        
        List<CompanyEntity> comList = getCompanyListBySectorId(sectorId);
        List<Long> comidList = new ArrayList<Long>();
        if(comList!=null) {
            for(CompanyEntity com:comList) {
                Long comId = com.getId();
                comidList.add(comId);
            }
        }
        if(comidList.size()>0) {
            splist = stockPriceClient.getStockPriceByComIdListAndExAndPeriod(comidList, stockExchange, fromDate, toDate);
        }
        
        return splist;
    }
    
}
