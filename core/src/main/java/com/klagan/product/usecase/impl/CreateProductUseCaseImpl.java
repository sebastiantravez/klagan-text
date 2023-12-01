package com.klagan.product.usecase.impl;

import com.klagan.product.entity.ProductCore;
import com.klagan.product.exception.ProductException;
import com.klagan.product.ports.gateway.ProductGateway;
import com.klagan.product.usecase.api.CreateProductUseCase;

import java.util.Optional;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductCore execute(ProductCore productCore) {
        Optional<ProductCore> productCoreOptional = productGateway.getProductCoreByCode(productCore.getCode());
        if (productCoreOptional.isPresent()) {
            throw new ProductException("This product exists");
        }
        return productGateway.create(productCore);
    }
}
