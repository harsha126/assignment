package com.test.assignment.services;

import com.test.assignment.api.v1.model.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductDTO> getProductById(Long id,Pageable pageable);
    Page<ProductDTO> getProductByName(String Name,Pageable pageable);

    Page<ProductDTO> getAllProducts(Pageable pageable);
}
