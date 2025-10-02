package com.example.examen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.dto.SucursalDto;
import com.example.examen.service.SucursalService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    private SucursalService sucursalService;


    @PostMapping
    public ResponseEntity<SucursalDto> nuevaSucursal(@Valid @RequestBody SucursalDto request) {
        return ResponseEntity.ok(sucursalService.nuevaSucursal(request));
    }
    

}
