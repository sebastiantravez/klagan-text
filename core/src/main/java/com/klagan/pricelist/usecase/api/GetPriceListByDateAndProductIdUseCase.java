package com.klagan.pricelist.usecase.api;

import com.klagan.pricelist.entity.PriceListCore;

import java.text.ParseException;
import java.util.List;

public interface GetPriceListByDateAndProductIdUseCase {
    List<PriceListCore> execute(String date, Long productId, Long brandId) throws ParseException;
}
