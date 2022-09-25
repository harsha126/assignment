package com.test.assignment.services;

import com.test.assignment.api.v1.mapper.ProductMapper;
import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productMapper.productToProductDTO(productRepository.findById(id).get());
    }

    @Override
    public ProductDTO getProductByName(String Name) {
        return productMapper.productToProductDTO(productRepository.findByName(Name)) ;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(product -> {
            ProductDTO productDTO = productMapper.productToProductDTO(product);
            productDTO.setBatchUrl("/api/v1/Batches/"+product.getId());
            return productDTO;
        }).collect(Collectors.toList());
    }
}
