package com.test.assignment.services;

import com.test.assignment.api.v1.mapper.ProductMapper;
import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.domain.Supplier;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    private final ProductMapper productMapper;
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper, ProductMapper productMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
        this.productMapper = productMapper;
    }

    @Override
    public SupplierDTO getSuppliersById(Long id) {
        return supplierMapper.supplierToSupplierDTO(supplierRepository.findById(id).get());
    }

    @Override
    public SupplierDTO getSuppliersByName(String name) {
        return supplierMapper.supplierToSupplierDTO(supplierRepository.findByName(name).get());
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplier -> {
            SupplierDTO supplierDTO = supplierMapper.supplierToSupplierDTO(supplier);
            supplierDTO.setInventoryUrl("/api/v1/suppliers/"+supplier.getId());
            return supplierDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name) {
        return supplierRepository.findAll(name,Long.parseLong(id)).stream()
                .map(productMapper::productToProductDTO).collect(Collectors.toList());
    }

//    @Override
//    public List<ProductDTO> getAllProductsNotExpiredById(Long id) {
//        return null;
//    }

    @Override
    public List<ProductDTO> getAllProductsNotExpiredById(Long id) {
        return supplierRepository.findAll(id,new Date()).stream()
                .map(productMapper::productToProductDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsNotExpiredByName(String name) {
        return supplierRepository.findAll(name).stream()
                .map(productMapper::productToProductDTO).collect(Collectors.toList());
    }

//    @Override
//    public List<ProductDTO> getAllProducts(String name, boolean bool) {
//        return null;
//    }

    @Override
    public List<ProductDTO> getAllProducts(String name, boolean bool) {
        Optional<Supplier> optionalSupplier;
        try{
            Long al = Long.parseLong(name);
            if(bool){
                System.out.println("----------------------went ----------------------");
                return supplierRepository.findAll(al,new Date()).stream().map(productMapper::productToProductDTO).collect(Collectors.toList());
            }
            else{
                return supplierRepository.findAllById(al).stream().map(productMapper::productToProductDTO).collect(Collectors.toList());
            }
        }
        catch (Exception e){
            if(bool){
                return supplierRepository.findAll(name).stream().map(productMapper::productToProductDTO).collect(Collectors.toList());
            }
            else{
                return supplierRepository.findAllByName(name).stream().map(productMapper::productToProductDTO).collect(Collectors.toList());
            }
        }

    }

}
