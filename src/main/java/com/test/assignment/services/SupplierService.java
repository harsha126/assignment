package com.test.assignment.services;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {
//    SupplierDTO getSupplierById(Long id);
    Page<SupplierDTO> getSupplierById(Long id,Pageable pageable);
//    SupplierDTO getSupplierByName(String name);
    Page<SupplierDTO> getSupplierByName(String name,Pageable pageable);

//    List<SupplierDTO> getAllSuppliers();
    Page<SupplierDTO> getAllSuppliers(Pageable pageable);

//    List<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name);
    Page<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name,Pageable pageable);
//    List<ProductDTO> getAllProductsBySupplierNameAndProductName(String id, String name);
    Page<ProductDTO> getAllProductsBySupplierNameAndProductName(String id, String name,Pageable pageable);

//    List<ProductDTO> getAllProductsNotExpiredById(Long id);
    Page<ProductDTO> getAllProductsNotExpiredById(Long id,Pageable pageable);

//    List<ProductDTO> getAllProductsNotExpiredByName(String name);
    Page<ProductDTO> getAllProductsNotExpiredByName(String name,Pageable pageable);
//
//    List<ProductDTO> getAllProducts(String name, boolean bool);
    Page<ProductDTO> getAllProducts(String name, boolean bool,Pageable pageable);
}
