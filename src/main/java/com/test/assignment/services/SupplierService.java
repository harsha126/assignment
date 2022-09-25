package com.test.assignment.services;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {
    Page<SupplierDTO> getSupplierById(Long id,Pageable pageable);
    Page<SupplierDTO> getSupplierByName(String name,Pageable pageable);

    Page<SupplierDTO> getAllSuppliers(Pageable pageable);

    Page<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name,Pageable pageable);
    Page<ProductDTO> getAllProductsBySupplierNameAndProductName(String id, String name,Pageable pageable);

    Page<ProductDTO> getAllProductsNotExpiredById(Long id,Pageable pageable);

    Page<ProductDTO> getAllProductsNotExpiredByName(String name,Pageable pageable);
//
    Page<ProductDTO> getAllProducts(String name, boolean bool,Pageable pageable);
}
