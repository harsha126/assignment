package com.test.assignment.services;

import com.test.assignment.api.v1.model.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO getSuppliersById(Long id);
    SupplierDTO getSuppliersByName(String name);

    List<SupplierDTO> getAllSuppliers();
}
