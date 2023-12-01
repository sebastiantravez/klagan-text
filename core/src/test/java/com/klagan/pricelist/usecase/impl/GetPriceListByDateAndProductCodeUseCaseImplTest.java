package com.klagan.pricelist.usecase.impl;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.ports.gateway.PriceListGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPriceListByDateAndProductCodeUseCaseImplTest {

    @InjectMocks
    private GetPriceListByDateAndProductCodeUseCaseImpl getPriceListByDateAndProductCodeUseCase;

    @Mock
    private PriceListGateway priceListGateway;

    @Test
    void execute() throws ParseException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = now.format(formatter);
        when(priceListGateway.getPriceListByDatesAndProduct(any(), anyString())).thenReturn(Arrays.asList());
        List<PriceListCore> response = getPriceListByDateAndProductCodeUseCase.execute(date, "2342343");
        Assertions.assertTrue(response.isEmpty());
        verify(priceListGateway).getPriceListByDatesAndProduct(any(), anyString());
    }
}