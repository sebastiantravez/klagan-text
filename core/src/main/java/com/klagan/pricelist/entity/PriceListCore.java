package com.klagan.pricelist.entity;

import com.klagan.product.entity.ProductCore;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceListCore {
    private Long priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private Integer priority;
    private String curr;
    private ProductCore productCore;

    public PriceListCore() {
    }

    public PriceListCore(Long priceListId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, Integer priority, String curr, ProductCore productCore) {
        this.priceListId = priceListId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.priority = priority;
        this.curr = curr;
        this.productCore = productCore;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public ProductCore getProductCore() {
        return productCore;
    }

    public void setProductCore(ProductCore productCore) {
        this.productCore = productCore;
    }
}

