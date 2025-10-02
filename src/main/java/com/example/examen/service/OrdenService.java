package com.example.examen.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.examen.dto.NuevaOrdenRequest;
import com.example.examen.dto.OrdenDto;
import com.example.examen.dto.ProductoDto;
import com.example.examen.entidades.Orden;
import com.example.examen.mapper.OrdenMapper;
import com.example.examen.mapper.ProductoMapper;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.ProductoRepository;
import com.example.examen.repository.SucursalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class OrdenService {

    private OrdenRepository ordenRepository;
    private SucursalRepository sucursalRepository;
    private ProductoRepository productoRepository;

    private OrdenMapper ordenMapper;
    private ProductoMapper productoMapper;

    @Transactional
    public OrdenDto nuevaOrden(NuevaOrdenRequest request){
        var sucursal = sucursalRepository
            .findById(request.getSucursalId())
            .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada con id " + request.getSucursalId()));

        Double total = request.getProductos()
            .stream()
            .mapToDouble(ProductoDto::getPrecio)
            .sum();

        var orden = new Orden();
        orden.setFecha(LocalDateTime.now());
        orden.setSucursal(sucursal);
        orden.setTotal(total);
        
        var nuevaOrden = ordenRepository.save(orden);

        for(var productoDto: request.getProductos()){
            var producto = productoMapper.toEntity(productoDto);
            producto.setOrden(nuevaOrden);
            productoRepository.save(producto);
            total += productoDto.getPrecio();
        }

        ordenRepository.save(orden);

        return ordenMapper.toDto(nuevaOrden);

    }

    public OrdenDto consultaOrden(Long id) {
        var orden = ordenRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontro la orden con el id " + id));
        return ordenMapper.toDto(orden);
    }

}
