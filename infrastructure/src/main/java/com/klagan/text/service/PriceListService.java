package com.klagan.text.service;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.ports.gateway.PriceListGateway;
import com.klagan.product.entity.ProductCore;
import com.klagan.text.entities.PriceList;
import com.klagan.text.repository.PriceListRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceListService implements PriceListGateway {

    private final PriceListRepository priceListRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PriceListCore> getPriceListByDatesAndProduct(LocalDateTime date, String productCode) {
        List<PriceList> priceLists = priceListRepository.findByDatesAndProductCode(date, productCode);
        return priceLists.stream().map(this::buildPriceList).collect(Collectors.toList());
    }

    private PriceListCore buildPriceList(PriceList priceList) {
        PriceListCore priceListCore = modelMapper.map(priceList, PriceListCore.class);
        priceListCore.setProductCore(modelMapper.map(priceList.getProduct(), ProductCore.class));
        return priceListCore;
    }
}
