package com.springboot.app.productos.repository;

import com.springboot.app.commons.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
