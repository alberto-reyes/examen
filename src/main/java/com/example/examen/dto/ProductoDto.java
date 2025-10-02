package com.example.examen.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    @NotBlank(message = "no puede estar vacío ni ser nulo")
    private String codigo;
    
    @NotBlank(message = "no puede estar vacío ni ser nulo")
    private String descripcion;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "el precio debe ser mayor a 0")
    private Double precio;

}
