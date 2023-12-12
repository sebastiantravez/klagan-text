package com.klagan.pricelist.entity;

public class BrandCore {
    private Long brandId;
    private String name;

    public BrandCore() {
    }

    public BrandCore(Long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
