package com.example.examen.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.examen.dto.ProductoDto;
import com.example.examen.entidades.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toEntity(ProductoDto dto);

    ProductoDto toDto(Producto producto);
    
    @Mapping(target = "id", ignore = true)
    void update(ProductoDto productoDto, @MappingTarget Producto producto);
}
