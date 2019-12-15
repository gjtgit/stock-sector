package com.gao.demo.model;

import java.util.Date;

import javax.persistence.Column;

public class SectorStockPriceVo {
    private Long sectorId;
    private String stockExchange;
    private double curPrice;
    private Date curDate;
    public Long getSectorId() {
        return sectorId;
    }
    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }
    public String getStockExchange() {
        return stockExchange;
    }
    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }
    public double getCurPrice() {
        return curPrice;
    }
    public void setCurPrice(double curPrice) {
        this.curPrice = curPrice;
    }
    public Date getCurDate() {
        return curDate;
    }
    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }
    
}
