package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Transaksi;
import com.example.sinaukoding.Entity.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapping {
    TransaksiMapping instance= Mappers.getMapper(TransaksiMapping.class);
    Transaksi toEntity(TransaksiDTO dto);
    TransaksiDTO toDto(Transaksi param);

    List<TransaksiDTO> toListDto(List<Transaksi> transaksiList);
}
