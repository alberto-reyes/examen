package com.example.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.dto.ProductoDto;
import com.example.examen.entidades.Producto;
import com.example.examen.mapper.ProductoMapper;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoService {

    private OrdenRepository ordenRepository;
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;

    @Transactional
    public ProductoDto actualizarProducto(Long id, ProductoDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el producto con id " + id));
        productoMapper.update(dto, producto);

        var productoActualizado = productoRepository.save(producto);

        var orden = ordenRepository.findById(producto.getOrden().getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la orden con id " + id));

        List<Producto> productosOrden = productoRepository.findByOrden(orden);

        double totalOrden = productosOrden.stream().mapToDouble(Producto::getPrecio).sum();

        orden.setTotal(totalOrden);
        ordenRepository.save(orden);

        return productoMapper.toDto(productoActualizado);

    }

}
