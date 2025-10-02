package com.example.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.examen.dto.NuevaOrdenRequest;
import com.example.examen.dto.OrdenDto;
import com.example.examen.service.OrdenService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orden")
@AllArgsConstructor
public class OrdenController {


    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<OrdenDto> nuevaOrden(@Valid @RequestBody NuevaOrdenRequest request, UriComponentsBuilder uriBuilder) {
        var response = ordenService.nuevaOrden(request);
        var uri = uriBuilder.path("/orden/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDto> consultarOrden(@PathVariable Long id){
        var response = ordenService.consultaOrden(id);
        return ResponseEntity.ok(response);
    }

}
