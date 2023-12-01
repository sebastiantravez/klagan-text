package com.klagan.pricelist.usecase.impl;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.api.GetPriceListByDateAndProductCodeUseCase;
import com.klagan.product.exception.ProductException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class GetPriceListByDateAndProductCodeUseCaseImpl implements GetPriceListByDateAndProductCodeUseCase {

    private static final Logger logger = Logger.getLogger(GetPriceListByDateAndProductCodeUseCaseImpl.class.getName());

    private final PriceListGateway priceListGateway;

    public GetPriceListByDateAndProductCodeUseCaseImpl(PriceListGateway priceListGateway) {
        this.priceListGateway = priceListGateway;
    }

    @Override
    public List<PriceListCore> execute(String date, String productCode) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);
            LocalDateTime localDateTime = localDate.atStartOfDay();
            LocalTime now = LocalTime.now();
            LocalDateTime dateFinal = localDateTime.withHour(now.getHour()).withMinute(now.getMinute());
            return priceListGateway.getPriceListByDatesAndProduct(dateFinal, productCode);
        } catch (Exception e) {
            String message = "Error getting product prices list for product code:" + productCode;
            logger.info(message);
            throw new ProductException(message);
        }
    }

}
