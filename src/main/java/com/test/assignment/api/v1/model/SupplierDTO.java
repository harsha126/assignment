package com.test.assignment.api.v1.model;

import com.test.assignment.domain.Inventory;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SupplierDTO {
    private Long id;
    private String name;
    private Set<Inventory> inventories;
    private String inventoryUrl;
}
