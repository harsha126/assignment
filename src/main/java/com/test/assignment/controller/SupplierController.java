package com.test.assignment.controller;

import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.ProductListDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.api.v1.model.SupplierListDTO;
import com.test.assignment.domain.Supplier;
import com.test.assignment.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/suppliers/")
@Slf4j
public class SupplierController {
    private final SupplierService  supplierService;
    private final SupplierMapper supplierMapper;


    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }
    @GetMapping
    public Page<SupplierDTO> getAllSuppliers(@RequestParam(name = "size",defaultValue = "5") int size,
                                                           @RequestParam(name = "page",defaultValue = "0") int page){
        return supplierService.getAllSuppliers(PageRequest.of(page,size));
    }

//    @GetMapping
//    public Page<SupplierListDTO> getAllSuppliers(@RequestParam(name = "page",defaultValue = "0") int page,
//                                                 @RequestParam(name = "size",defaultValue = "10") int size){
//        return new SupplierListDTO(supplierService.getAllSuppliers(page,size, PageRequest.of(page,size)));
//    }
    @GetMapping({"{name}"})
    public Page<ProductDTO> getSupplier(@PathVariable String name,
                                        @RequestParam(name = "exp",defaultValue = "false") boolean bool,
                                        @RequestParam(name = "size",defaultValue = "5") int size,
                                        @RequestParam(name = "page",defaultValue = "0") int page){
        System.out.println("------------------runnning =-------------------");

            return supplierService.getAllProducts(name,bool,PageRequest.of(page,size));

    }

    @GetMapping({"{name}/{prod}"})
    public Page<ProductDTO> getSupplier(@PathVariable String name, @PathVariable String prod,
                                                      @RequestParam(name = "size",defaultValue = "5") int size,
                                                      @RequestParam(name = "page",defaultValue = "0") int page){
        try{
            Long al = Long.parseLong(name);
            return supplierService.getAllProductsBySupplierIdAndProductName(name,prod.toUpperCase(),PageRequest.of(page, size));
        }
        catch (Exception e){
            System.out.println("Enter valid id");
        }
        return supplierService.getAllProductsBySupplierNameAndProductName(name,prod.toUpperCase(),PageRequest.of(page,size));

    }






}
