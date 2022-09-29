package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Pembayaran;
import com.example.sinaukoding.Entity.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapping {
    PembayaranMapping instance= Mappers.getMapper(PembayaranMapping.class);
    Pembayaran toEntity(PembayaranDTO dto);
    PembayaranDTO toDto(Pembayaran param);

    List<PembayaranDTO> toListDto(List<Pembayaran> pembayaranList);

}
