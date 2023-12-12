package com.klagan.text.configuration;

import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.api.GetPriceListByDateAndProductIdUseCase;
import com.klagan.pricelist.usecase.impl.GetPriceListByDateAndProductIdUseCaseImpl;
import com.klagan.product.ports.gateway.ProductGateway;
import com.klagan.product.usecase.api.CreateProductUseCase;
import com.klagan.product.usecase.impl.CreateProductUseCaseImpl;
import com.klagan.text.util.GlobalMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAppText {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
    @Bean
    public GlobalMapper globalMapper() {
        GlobalMapper globalMapper = new GlobalMapper();
        return globalMapper;
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    @Bean
    public GetPriceListByDateAndProductIdUseCase getPriceListByDateAndProductIdUseCase(PriceListGateway priceListGateway) {
        return new GetPriceListByDateAndProductIdUseCaseImpl(priceListGateway);
    }
}
