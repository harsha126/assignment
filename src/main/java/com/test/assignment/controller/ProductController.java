package com.test.assignment.controller;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.ProductListDTO;
import com.test.assignment.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<ProductListDTO> getAllProducts(){
        return new ResponseEntity<ProductListDTO>(new ProductListDTO(productService.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String name){
        try{
            Long al = Long.parseLong(name);
            return new ResponseEntity<ProductDTO>(productService.getProductById(al),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ProductDTO>(productService.getProductByName(name),HttpStatus.OK);
        }
    }
}
