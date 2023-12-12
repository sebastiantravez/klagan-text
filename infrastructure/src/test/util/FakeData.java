package com.klagan.util;

import com.klagan.pricelist.entity.BrandCore;
import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.product.entity.ProductCore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FakeData {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public PriceListCore priceListCore1() {
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-14 00:00:00", formatter);
        LocalDateTime endDate1 = LocalDateTime.parse("2020-12-31 23:59:59", formatter);

        PriceListCore priceListCore = new PriceListCore();
        BrandCore brandCore = new BrandCore();
        brandCore.setBrandId(1L);
        priceListCore.setBrandCore(brandCore);
        priceListCore.setStartDate(startDate1);
        priceListCore.setEndDate(endDate1);
        priceListCore.setPriceListId(1L);
        ProductCore productCore = new ProductCore();
        productCore.setProductId(35455L);
        priceListCore.setProductCore(productCore);
        priceListCore.setPriority(0);
        priceListCore.setPrice(BigDecimal.valueOf(35.50));
        priceListCore.setCurr("EUR");

        return priceListCore;
    }

    public PriceListCore priceListCore2() {
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-14 15:00:00", formatter);
        LocalDateTime endDate1 = LocalDateTime.parse("2020-06-14 18:30:00", formatter);

        PriceListCore priceListCore = new PriceListCore();
        BrandCore brandCore = new BrandCore();
        brandCore.setBrandId(1L);
        priceListCore.setBrandCore(brandCore);
        priceListCore.setStartDate(startDate1);
        priceListCore.setEndDate(endDate1);
        priceListCore.setPriceListId(2L);
        ProductCore productCore = new ProductCore();
        productCore.setProductId(35455L);
        priceListCore.setProductCore(productCore);
        priceListCore.setPriority(1);
        priceListCore.setPrice(BigDecimal.valueOf(25.45));
        priceListCore.setCurr("EUR");

        return priceListCore;
    }

    public PriceListCore priceListCore3() {
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-15 00:00:00", formatter);
        LocalDateTime endDate1 = LocalDateTime.parse("2020-06-15 11:00:00", formatter);

        PriceListCore priceListCore = new PriceListCore();
        BrandCore brandCore = new BrandCore();
        brandCore.setBrandId(1L);
        priceListCore.setBrandCore(brandCore);
        priceListCore.setStartDate(startDate1);
        priceListCore.setEndDate(endDate1);
        priceListCore.setPriceListId(3L);
        ProductCore productCore = new ProductCore();
        productCore.setProductId(35455L);
        priceListCore.setProductCore(productCore);
        priceListCore.setPriority(1);
        priceListCore.setPrice(BigDecimal.valueOf(30.50));
        priceListCore.setCurr("EUR");

        return priceListCore;
    }

    public PriceListCore priceListCore4() {
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-15 16:00:00", formatter);
        LocalDateTime endDate1 = LocalDateTime.parse("2020-12-31 23:59:59", formatter);

        PriceListCore priceListCore = new PriceListCore();
        BrandCore brandCore = new BrandCore();
        brandCore.setBrandId(1L);
        priceListCore.setBrandCore(brandCore);
        priceListCore.setStartDate(startDate1);
        priceListCore.setEndDate(endDate1);
        priceListCore.setPriceListId(4L);
        ProductCore productCore = new ProductCore();
        productCore.setProductId(35455L);
        priceListCore.setProductCore(productCore);
        priceListCore.setPriority(1);
        priceListCore.setPrice(BigDecimal.valueOf(38.95));
        priceListCore.setCurr("EUR");

        return priceListCore;
    }
}
