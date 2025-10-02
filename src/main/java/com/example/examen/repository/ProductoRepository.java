package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entidades.Orden;
import com.example.examen.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    List<Producto> findByOrden(Orden orden);

}
