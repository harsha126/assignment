package com.test.assignment.api.v1.mapper;

import com.test.assignment.api.v1.model.BatchDTO;
import com.test.assignment.domain.Batch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BatchMapper {
    BatchMapper INSTANCE = Mappers.getMapper(BatchMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "batchId",target = "batchId")
    @Mapping(source = "stock",target = "stock")
    @Mapping(source = "deal",target = "deal")
    @Mapping(source = "free",target = "free")
    @Mapping(source = "mrp",target = "mrp")
    @Mapping(source = "rate",target = "rate")
    @Mapping(source = "expDate",target = "expDate")
    @Mapping(source = "product",target = "product")
    BatchDTO inventoryToInventoryDTO(Batch batch);
}
