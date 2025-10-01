package com.example.examen.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.dto.NuevaOrdenRequest;
import com.example.examen.dto.OrdenDto;
import com.example.examen.entidades.Orden;
import com.example.examen.entidades.Producto;
import com.example.examen.mapper.OrdenMapper;
import com.example.examen.mapper.ProductoMapper;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.ProductoRepository;
import com.example.examen.repository.SucursalRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdenService {

    private OrdenRepository ordenRepository;
    private SucursalRepository sucursalRepository;
    private ProductoRepository productoRepository;

    private OrdenMapper ordenMapper;
    private ProductoMapper productoMapper;

    @Transactional
    public OrdenDto nuevaOrden(NuevaOrdenRequest request){

        Double total = 0.0;

        var sucursal = sucursalRepository.findById(request.getSucursalId()).orElse(null);

        Orden orden = new Orden();
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

}
