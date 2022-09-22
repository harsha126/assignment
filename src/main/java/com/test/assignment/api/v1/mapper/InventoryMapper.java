package com.test.assignment.api.v1.mapper;

import com.test.assignment.api.v1.model.InventoryDTO;
import com.test.assignment.domain.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "product",target = "product")
    @Mapping(source = "batch",target = "batch")
    @Mapping(source = "stock",target = "stock")
    @Mapping(source = "deal",target = "deal")
    @Mapping(source = "free",target = "free")
    @Mapping(source = "mrp",target = "mrp")
    @Mapping(source = "rate",target = "rate")
    @Mapping(source = "expDate",target = "expDate")
    InventoryDTO inventoryToInventoryDTO(Inventory inventory);
}
