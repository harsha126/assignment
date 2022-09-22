package com.test.assignment.services;

import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDTO getSuppliersById(Long id) {
        return supplierMapper.supplierToSupplierDTO(supplierRepository.findById(id).get());
    }

    @Override
    public SupplierDTO getSuppliersByName(String name) {
        return supplierMapper.supplierToSupplierDTO(supplierRepository.findByName(name));
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplier -> {
            SupplierDTO supplierDTO = supplierMapper.supplierToSupplierDTO(supplier);
            supplierDTO.setInventoryUrl("/api/v1/suppliers/"+supplier.getId());
            return supplierDTO;
        }).collect(Collectors.toList());
    }

}
