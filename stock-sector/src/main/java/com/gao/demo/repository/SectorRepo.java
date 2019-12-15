package com.gao.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gao.demo.entity.CompanyEntity;
import com.gao.demo.entity.SectorEntity;
import com.gao.demo.entity.StockPriceEntity;

@Repository
public interface SectorRepo extends JpaRepository<SectorEntity,Long>{
    
//    @Query("select c from CompanyEntity c, SectorEntity s where c.sectorId=s.id and s.sectorName=?1")
//    public List<CompanyEntity> getCompanyListBySectorName(String sectorName);

//    @Query("select sp from StockPriceEntity sp, CompanyEntity c, SectorEntity s " + 
//            "where c.id = sp.companyId and c.sectorId=s.id and s.id=?1 and sp.curDate>=?2 and sp.curDate<=?3")
//    public List<StockPriceEntity> getSectorStockPrice(Long sectorId, Date fromDate, Date toDate);

}
