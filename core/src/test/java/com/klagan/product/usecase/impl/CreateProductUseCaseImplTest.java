package com.klagan.product.usecase.impl;

import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.impl.GetPriceListByDateAndProductIdUseCaseImpl;
import com.klagan.product.entity.ProductCore;
import com.klagan.product.ports.gateway.ProductGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseImplTest {

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Mock
    private ProductGateway productGateway;

    @Test
    void givenCreateProduct() {
        when(productGateway.getProductCoreByCode(any())).thenReturn(Optional.empty());
        createProductUseCase.execute(new ProductCore());
        verify(productGateway).create(any());
    }
}