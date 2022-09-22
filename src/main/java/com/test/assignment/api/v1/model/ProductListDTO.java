package com.test.assignment.api.v1.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductListDTO {
    List<ProductDTO> productList;
}
