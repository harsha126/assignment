package com.test.assignment.api.v1.mapper;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "code",target = "code")
    @Mapping(source = "company",target = "company")
    @Mapping(source = "name",target = "name")
    ProductDTO productToProductDTO(Product product);
}
