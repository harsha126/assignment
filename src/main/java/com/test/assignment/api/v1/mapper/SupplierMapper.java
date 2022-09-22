package com.test.assignment.api.v1.mapper;

import com.test.assignment.api.v1.model.SupplierDTO;
import com.test.assignment.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "inventories",target = "inventories")
    SupplierDTO supplierToSupplierDTO(Supplier supplier);

}
