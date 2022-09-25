package com.test.assignment.services;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO getSuppliersById(Long id);
    SupplierDTO getSuppliersByName(String name);

    List<SupplierDTO> getAllSuppliers();

    List<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name);

    List<ProductDTO> getAllProductsNotExpiredById(Long id);
    List<ProductDTO> getAllProductsNotExpiredByName(String name);

    List<ProductDTO> getAllProducts(String name, boolean bool);
}
