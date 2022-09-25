package com.test.assignment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String company;
    @OneToMany(mappedBy = "product")
    @Builder.Default
    private Set<Batch> batches = new HashSet<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Supplier> suppliers = new HashSet<>();

}
