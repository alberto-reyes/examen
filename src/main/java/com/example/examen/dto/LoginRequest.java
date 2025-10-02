package com.example.examen.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "no puede estar vacío ni ser nulo")
    private String user;
    @NotBlank(message = "no puede estar vacío ni ser nulo")
    private String password;
    
}
