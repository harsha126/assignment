package com.test.assignment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @JsonManagedReference
    @ManyToMany(targetEntity = Product.class,fetch = FetchType.LAZY)
    @Builder.Default
    @JoinTable(name = "supplier_product",
            joinColumns = @JoinColumn(name = "supp_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id"))
    private Set<Product> products = new HashSet<>();
}
