package com.klagan.product.entity;

import com.klagan.pricelist.entity.PriceListCore;

import java.util.List;

public class ProductCore {
    private Long productId;
    private String code;
    private String name;

    public ProductCore() {
    }

    public ProductCore(Long productId, String code, String name, List<PriceListCore> priceList) {
        this.productId = productId;
        this.code = code;
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
