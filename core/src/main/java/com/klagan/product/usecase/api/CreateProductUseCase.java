package com.klagan.product.usecase.api;

import com.klagan.product.entity.ProductCore;

public interface CreateProductUseCase {
    ProductCore execute(ProductCore productCore);
}
