package com.example.examen.mapper;

import org.mapstruct.Mapper;

import com.example.examen.dto.OrdenDto;
import com.example.examen.entidades.Orden;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    OrdenDto toDto(Orden orden);

}
