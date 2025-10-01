package com.example.examen.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdenDto {

    private LocalDateTime fecha;
    private Double total;
    private SucursalDto sucursal;
    private List<ProductoDto> productos;

}
