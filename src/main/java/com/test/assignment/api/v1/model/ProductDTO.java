package com.test.assignment.api.v1.model;

import com.test.assignment.domain.Supplier;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String code;
    private String company;
    private String suppliersUrl;
    private String name;
}
