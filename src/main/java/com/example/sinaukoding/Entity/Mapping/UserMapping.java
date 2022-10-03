package com.example.sinaukoding.Entity.Mapping;

import com.example.sinaukoding.Entity.Users;
import com.example.sinaukoding.Entity.dto.ResponsAuthDTO;
import com.example.sinaukoding.Entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapping {
    UserMapping instance = Mappers.getMapper(UserMapping.class);

    Users toEntity(UserDTO dto);

    UserDTO toDto(Users param);

    List<UserDTO> toListDto(List<Users> data);

    ResponsAuthDTO fromEntityToResponseDto(Users data);

    ResponsAuthDTO fromDtoToResponseDto(UserDTO data);

}
