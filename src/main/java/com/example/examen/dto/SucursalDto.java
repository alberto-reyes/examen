package com.example.examen.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalDto {

    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío ni ser nulo")
    private String nombre;
}
