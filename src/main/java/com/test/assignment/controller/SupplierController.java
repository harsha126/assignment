package com.test.assignment.controller;

import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.ProductListDTO;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.api.v1.model.SupplierListDTO;
import com.test.assignment.domain.Supplier;
import com.test.assignment.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
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
    public ResponseEntity<SupplierListDTO> getAllSuppliers(){
        return new ResponseEntity<SupplierListDTO>(new SupplierListDTO(supplierService.getAllSuppliers()), HttpStatus.OK);
    }
    @GetMapping({"{name}"})
    public ResponseEntity<ProductListDTO> getSupplier(@PathVariable String name,
                                                   @RequestParam(name = "exp",defaultValue = "false") boolean bool){
        System.out.println("------------------runnning =-------------------");

            return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProducts(name,bool)),HttpStatus.OK);

    }

    @GetMapping({"{name}/{prod}"})
    public ResponseEntity<ProductListDTO> getSupplier(@PathVariable String name, @PathVariable String prod){
        try{
            Long al = Long.parseLong(name);
            return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProductsBySupplierIdAndProductName(name,prod)),HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("Enter valid id");
        }
        return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProductsBySupplierIdAndProductName(name,prod)),HttpStatus.OK);

    }
//    @GetMapping({"{id}"})
//    public ResponseEntity<ProductListDTO> getProducts(@PathVariable Long id, @RequestParam(name = "exp",defaultValue = "false") boolean bool){
//        log.debug("WENT INTO BOOL CONTROLLER -------------------------------");
//        System.out.println("WENT INTO BOOL CONTROLLER -------------------------------");
//        return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProductsNotExpiredById(id)),HttpStatus.OK);
//    }





}
