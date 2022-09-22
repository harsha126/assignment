package com.test.assignment.services;

import com.test.assignment.api.v1.model.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long id);
    ProductDTO getProductByName(String Name);
    List<ProductDTO> getAllProducts();
}
