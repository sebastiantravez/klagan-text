package com.klagan.text.configuration;

import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.pricelist.usecase.api.GetPriceListUseCaseByDateAndProductCode;
import com.klagan.pricelist.usecase.impl.GetPriceListUseCaseByDateAndProductCodeImpl;
import com.klagan.product.ports.gateway.ProductGateway;
import com.klagan.product.usecase.api.CreateProductUseCase;
import com.klagan.product.usecase.impl.CreateProductUseCaseImpl;
import com.klagan.text.util.GlobalMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

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
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    @Bean
    public GetPriceListUseCaseByDateAndProductCode getPriceListUseCaseByDateAndProductCode(PriceListGateway priceListGateway) {
        return new GetPriceListUseCaseByDateAndProductCodeImpl(priceListGateway);
    }
}