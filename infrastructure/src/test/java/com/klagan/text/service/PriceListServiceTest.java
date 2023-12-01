package com.klagan.text.service;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.product.entity.ProductCore;
import com.klagan.text.entities.PriceList;
import com.klagan.text.entities.Product;
import com.klagan.text.repository.PriceListRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceListServiceTest {

    @InjectMocks
    private PriceListService priceListService;

    @Mock
    private PriceListRepository priceListRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void GivenProductPriceListWhenGetPricesThenReturnListPricesSuccess() {
        PriceList priceList = PriceList.builder()
                .priceListId(1L)
                .startDate(LocalDateTime.now().plusHours(1))
                .endDate(LocalDateTime.now().plusDays(1))
                .price(BigDecimal.valueOf(12.34))
                .priority(1)
                .curr("EUR")
                .product(Product.builder()
                        .productId(1L)
                        .code("34355")
                        .name("Product A")
                        .build())
                .build();
        when(priceListRepository.findByDatesAndProductCode(any(), anyString())).thenReturn(Arrays.asList(priceList));
        PriceListCore priceListCore = new PriceListCore();
        ProductCore productCore = new ProductCore();
        productCore.setCode("34355");
        priceListCore.setProductCore(productCore);
        when(modelMapper.map(any(), eq(PriceListCore.class))).thenReturn(priceListCore);
        when(modelMapper.map(any(), eq(ProductCore.class))).thenReturn(productCore);
        List<PriceListCore> response = priceListService.getPriceListByDatesAndProduct(LocalDateTime.now(), "34355");
        Assertions.assertThat(response).isNotEmpty();
        verify(priceListRepository).findByDatesAndProductCode(any(), any());
    }
}