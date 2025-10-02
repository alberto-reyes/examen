package com.example.examen.mapper;

import org.mapstruct.Mapper;

import com.example.examen.dto.SucursalDto;
import com.example.examen.entidades.Sucursal;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalDto toDto(Sucursal sucursal);
    Sucursal toEntity(SucursalDto dto);
}
