package com.example.examen.mapper;

import org.mapstruct.Mapper;

import com.example.examen.dto.ProductoDto;
import com.example.examen.entidades.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toEntity(ProductoDto dto);
}
