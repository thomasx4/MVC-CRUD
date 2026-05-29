package com.crud.mvc.repository;

import com.crud.mvc.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    
    
    List<Producto> findByPrecioGreaterThan(Double precio);
    
    
    List<Producto> findByCantidadLessThan(Integer cantidad);
}