package com.test.assignment.services;

import com.test.assignment.api.v1.mapper.ProductMapper;
import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.domain.Supplier;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//    @Override
//    public SupplierDTO getSupplierById(Long id) {
//        return supplierMapper.supplierToSupplierDTO(supplierRepository.findById(id).get());
//    }

    @Override
    public Page<SupplierDTO> getSupplierById(Long id, Pageable pageable) {
        return supplierRepository.findById(id,pageable).map(supplierMapper::supplierToSupplierDTO);
    }



    @Override
    public Page<SupplierDTO> getSupplierByName(String name, Pageable pageable) {
        return supplierRepository.findByName(name,pageable).map(supplierMapper::supplierToSupplierDTO);
    }

    @Override
    public Page<SupplierDTO> getAllSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable).map(supplier -> {
            SupplierDTO supplierDTO = supplierMapper.supplierToSupplierDTO(supplier);
            supplierDTO.setInventoryUrl("/api/v1/suppliers/"+supplier.getId());
            return supplierDTO;
        });
    }

    @Override
    public Page<ProductDTO> getAllProductsBySupplierIdAndProductName(String id, String name,Pageable pageable) {
        return supplierRepository.findAll(name,Long.parseLong(id),pageable)
                .map(productMapper::productToProductDTO);
    }

    @Override
    public Page<ProductDTO> getAllProductsBySupplierNameAndProductName(String supp_name, String name,Pageable pageable) {
        return supplierRepository.findAll(name,supp_name,pageable)
                .map(productMapper::productToProductDTO);
    }


    @Override
    public Page<ProductDTO> getAllProductsNotExpiredById(Long id,Pageable pageable) {
        return supplierRepository.findAll(id,new Date(),pageable)
                .map(productMapper::productToProductDTO);
    }

    @Override
    public Page<ProductDTO> getAllProductsNotExpiredByName(String name,Pageable pageable) {
        return supplierRepository.findAll(name,pageable)
                .map(productMapper::productToProductDTO);
    }


    @Override
    public Page<ProductDTO> getAllProducts(String name, boolean bool,Pageable pageable) {
        Optional<Supplier> optionalSupplier;
        try{
            Long al = Long.parseLong(name);
            if(bool){
                System.out.println("----------------------went ----------------------");
                return supplierRepository.findAll(al,pageable).map(productMapper::productToProductDTO);
            }
            else{
                return supplierRepository.findAllById(al,pageable).map(productMapper::productToProductDTO);
            }
        }
        catch (Exception e){
            if(bool){
                return supplierRepository.findAll(name,pageable).map(productMapper::productToProductDTO);
            }
            else{
                return supplierRepository.findAllByName(name,pageable).map(productMapper::productToProductDTO);
            }
        }

    }

}
