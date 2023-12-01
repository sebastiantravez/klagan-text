package com.klagan.pricelist.ports.gateway;

import com.klagan.pricelist.entity.PriceListCore;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceListGateway {
    List<PriceListCore> getPriceListByDatesAndProduct(LocalDateTime date, String productCode) throws ParseException;
}
