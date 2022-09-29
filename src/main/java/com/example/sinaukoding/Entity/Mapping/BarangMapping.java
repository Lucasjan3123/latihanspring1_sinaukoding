package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Barang;
import com.example.sinaukoding.Entity.dto.BarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface BarangMapping {
    BarangMapping instance= Mappers.getMapper(BarangMapping.class);
    Barang toEntity(BarangDTO dto);
    BarangDTO toDto(Barang param);

    List<BarangDTO>toListDto(List<Barang>barangList);

}
