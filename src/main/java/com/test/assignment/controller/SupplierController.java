package com.test.assignment.controller;

import com.test.assignment.api.v1.mapper.SupplierMapper;
import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.api.v1.model.SupplierListDTO;
import com.test.assignment.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/suppliers/")
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
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable String name){
        try{
            Long al = Long.parseLong(name);
            return new ResponseEntity<SupplierDTO>(supplierService.getSuppliersById(al),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<SupplierDTO>(supplierService.getSuppliersByName(name),HttpStatus.OK);
        }
    }
}
