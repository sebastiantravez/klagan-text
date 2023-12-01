package com.klagan.product.ports.gateway;

import com.klagan.product.entity.ProductCore;

import java.util.Optional;

public interface ProductGateway {
    ProductCore create(ProductCore productCore);
    Optional<ProductCore> getProductCoreByCode(String code);
}
