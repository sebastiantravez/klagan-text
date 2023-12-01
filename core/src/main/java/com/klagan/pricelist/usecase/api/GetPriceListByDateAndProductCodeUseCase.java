package com.klagan.pricelist.usecase.api;

import com.klagan.pricelist.entity.PriceListCore;

import java.text.ParseException;
import java.util.List;

public interface GetPriceListByDateAndProductCodeUseCase {
    List<PriceListCore> execute(String date, String productCode) throws ParseException;
}
