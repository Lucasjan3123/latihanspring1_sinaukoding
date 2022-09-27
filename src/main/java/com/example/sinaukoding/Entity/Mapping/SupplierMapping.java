package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Supplier;
import com.example.sinaukoding.Entity.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapping {
    SupplierMapping instance= Mappers.getMapper(SupplierMapping.class);
    Supplier toEntity(SupplierDTO dto);
    SupplierDTO toDto(Supplier param);

    List<SupplierDTO> toListDto(List<Supplier> supplierList);
}
