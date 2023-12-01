package com.klagan.pricelist.usecase.impl;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.api.GetPriceListByDateAndProductCodeUseCase;
import com.klagan.product.exception.ProductException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
            List<PriceListCore> priceLists = priceListGateway.getPriceListByDatesAndProduct(dateFinal, productCode);

            //TODO ordena descendentemente por fechas
            Comparator<PriceListCore> comparatorDate = Comparator
                    .comparing(PriceListCore::getStartDate)
                    .thenComparing(PriceListCore::getEndDate).reversed();

            //TODO ordena descendentemente, tomando como prioridad el 1
            Comparator<PriceListCore> comparatorPriority = Comparator
                    .comparing(PriceListCore::getPriority, Comparator.reverseOrder());

            Collections.sort(priceLists, comparatorDate);
            Collections.sort(priceLists, comparatorPriority);

            return priceLists;
        } catch (Exception e) {
            String message = "Error getting product prices list for product code:" + productCode;
            logger.info(message);
            throw new ProductException(message);
        }
    }

}
