package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
