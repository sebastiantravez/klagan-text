package com.klagan.text.service;

import com.klagan.product.entity.ProductCore;
import com.klagan.product.ports.gateway.ProductGateway;
import com.klagan.text.entities.Product;
import com.klagan.text.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductGateway {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public ProductCore create(ProductCore productCore) {
        Product product = modelMapper.map(productCore, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductCore.class);
    }

    @Override
    public Optional<ProductCore> getProductCoreByCode(String code) {
        Product product = productRepository.findByCode(code).orElse(null);
        return product != null ? Optional.of(modelMapper.map(product, ProductCore.class)) : Optional.empty();
    }
}
