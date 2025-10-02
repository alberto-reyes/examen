package com.example.examen.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NuevaOrdenRequest {

    private Long sucursalId;
    @Valid
    @NotNull(message = "se requieren productos")
    @NotEmpty(message = "se requieren productos")
    private List<ProductoDto> productos;

}
