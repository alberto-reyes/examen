package com.example.examen.service;

import org.springframework.stereotype.Service;

import com.example.examen.dto.SucursalDto;
import com.example.examen.mapper.SucursalMapper;
import com.example.examen.repository.SucursalRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SucursalService {

    private SucursalRepository sucursalRepository;
    private SucursalMapper sucursalMapper;

    public SucursalDto nuevaSucursal(SucursalDto dto) {
        var sucursal = sucursalMapper.toEntity(dto);
        var nuevaSucursal = sucursalRepository.save(sucursal);

        return sucursalMapper.toDto(nuevaSucursal);

    }

}
