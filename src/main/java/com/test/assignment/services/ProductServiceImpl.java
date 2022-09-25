package com.test.assignment.services;

import com.test.assignment.api.v1.mapper.ProductMapper;
import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductDTO> getProductById(Long id, Pageable pageable) {
        return productRepository.findById(id , pageable)
                .map(product -> {
                    ProductDTO productDTO = productMapper.productToProductDTO(product);
                    productDTO.setBatchUrl("/api/v1/Batches/"+product.getId());
                    return productDTO;
                });
    }


    @Override
    public Page<ProductDTO> getProductByName(String Name, Pageable pageable) {
        return productRepository.findByName(Name , pageable)
                .map(product -> {
                    ProductDTO productDTO = productMapper.productToProductDTO(product);
                    productDTO.setBatchUrl("/api/v1/Batches/"+product.getId());
                    return productDTO;
                });
    }

//    @Override
//    public Page<ProductDTO> getAllProducts() {
//        return productRepository.findAll().stream().map(product -> {
//            ProductDTO productDTO = productMapper.productToProductDTO(product);
//            productDTO.setBatchUrl("/api/v1/Batches/"+product.getId());
//            return productDTO;
//        }).collect(Collectors.toList());
//    }

    @Override
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(product -> {
                    ProductDTO productDTO = productMapper.productToProductDTO(product);
                    productDTO.setBatchUrl("/api/v1/Batches/"+product.getId());
                    return productDTO;
                });
    }
}
