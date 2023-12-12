package com.klagan.text.service;

import com.klagan.product.entity.ProductCore;
import com.klagan.text.entities.Product;
import com.klagan.text.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;


    @Test
    void givenSaveProduct() {
        productService.create(new ProductCore());
        verify(productRepository).save(any());
    }

    @Test
    void givenGetProductCoreByCode() {
        when(productRepository.findByCode(any())).thenReturn(Optional.of(Product.builder().productId(1L).build()));
        productService.getProductCoreByCode("tets");
        verify(productRepository).findByCode(any());
    }
}