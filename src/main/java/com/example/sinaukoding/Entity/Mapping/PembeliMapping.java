package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Pembeli;
import com.example.sinaukoding.Entity.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapping {
    PembeliMapping instance= Mappers.getMapper(PembeliMapping.class);
    Pembeli toEntity(PembeliDTO dto);
    PembeliDTO toDto(Pembeli param);

    List<PembeliDTO> toListDto(List<Pembeli> pembeliList);
}
