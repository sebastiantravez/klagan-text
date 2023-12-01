package com.klagan.pricelist.usecase.impl;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.api.GetPriceListUseCaseByDateAndProductCode;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetPriceListUseCaseByDateAndProductCodeImpl implements GetPriceListUseCaseByDateAndProductCode {

    private final PriceListGateway priceListGateway;

    public GetPriceListUseCaseByDateAndProductCodeImpl(PriceListGateway priceListGateway) {
        this.priceListGateway = priceListGateway;
    }

    @Override
    public List<PriceListCore> execute(String date, String productCode) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        LocalTime now = LocalTime.now();
        LocalDateTime dateFinal = localDateTime.withHour(now.getHour()).withMinute(now.getMinute());
        return priceListGateway.getPriceListByDatesAndProduct(dateFinal, productCode);
    }

}
