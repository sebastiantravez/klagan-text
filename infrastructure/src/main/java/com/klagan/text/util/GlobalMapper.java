package com.klagan.text.util;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.product.entity.ProductCore;
import com.klagan.text.dto.BrandDto;
import com.klagan.text.dto.PriceListDto;
import com.klagan.text.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class GlobalMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PriceListDto priceListDtoFromCoreEntity(PriceListCore priceListCore) {
        PriceListDto priceListDto = modelMapper.map(priceListCore, PriceListDto.class);
        priceListDto.setProduct(modelMapper.map(priceListCore.getProductCore(), ProductDto.class));
        priceListDto.setBrand(modelMapper.map(priceListCore.getBrandCore(), BrandDto.class));
        return priceListDto;
    }

    public List<PriceListDto> priceListDtoFromCoreEntities(List<PriceListCore> priceListCores) {
        return priceListCores.stream().map(this::priceListDtoFromCoreEntity).collect(Collectors.toList());
    }

    public ProductCore productCoretoCoreEntity(ProductDto productDto) {
        return modelMapper.map(productDto, ProductCore.class);
    }

    public ProductDto productDtoFromCoreEntity(ProductCore productCore) {
        return modelMapper.map(productCore, ProductDto.class);
    }
}
