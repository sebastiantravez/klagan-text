package com.klagan.text.controller;

import com.klagan.product.entity.ProductCore;
import com.klagan.product.usecase.api.CreateProductUseCase;
import com.klagan.text.dto.ProductDto;
import com.klagan.text.util.GlobalMapper;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final GlobalMapper globalMapper;

    @PostMapping("/create-product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductCore productCore = createProductUseCase.execute(globalMapper.productCoretoCoreEntity(productDto));
        return new ResponseEntity<>(globalMapper.productDtoFromCoreEntity(productCore), HttpStatus.OK);
    }

}
