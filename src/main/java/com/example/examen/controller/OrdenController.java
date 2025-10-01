package com.example.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.dto.NuevaOrdenRequest;
import com.example.examen.dto.OrdenDto;
import com.example.examen.service.OrdenService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orden")
@AllArgsConstructor
public class OrdenController {


    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<OrdenDto> nuevaOrden(@RequestBody NuevaOrdenRequest request) {
        var response = ordenService.nuevaOrden(request);
        return ResponseEntity.ok(response);
    }

}
