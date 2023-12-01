package com.klagan.text.controller;

import com.klagan.pricelist.entity.PriceListCore;
import com.klagan.pricelist.usecase.api.GetPriceListUseCaseByDateAndProductCode;
import com.klagan.text.dto.PriceListDto;
import com.klagan.text.util.GlobalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/price-list")
@RequiredArgsConstructor
public class PriceListController {

    private final GetPriceListUseCaseByDateAndProductCode getPriceListUseCaseByDateAndProductCode;

    private final GlobalMapper globalMapper;

    @GetMapping("/get-prices")
    public ResponseEntity<List<PriceListDto>> getPricesByDates(@RequestParam("date") String date, @RequestParam("code") String code) throws ParseException {
        List<PriceListCore> priceListCores = getPriceListUseCaseByDateAndProductCode.execute(date, code);
        return new ResponseEntity<>(globalMapper.priceListDtoFromCoreEntities(priceListCores), HttpStatus.OK);
    }
}
