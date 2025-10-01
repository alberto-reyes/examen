package com.example.examen.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NuevaOrdenRequest {

    private Long sucursalId;
    private List<ProductoDto> productos;

}
