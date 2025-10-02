package com.example.examen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.dto.ProductoDto;
import com.example.examen.service.ProductoService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> putMethodName(@PathVariable Long id, @RequestBody ProductoDto request) {
        var response = productoService.actualizarProducto(id, request);
        return ResponseEntity.ok(response);
    }

}
