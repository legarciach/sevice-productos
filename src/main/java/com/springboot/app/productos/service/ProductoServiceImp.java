package com.springboot.app.productos.service;

import com.springboot.app.commons.models.entity.Producto;
import com.springboot.app.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto edit(Producto producto, Long id) {
        Producto productoDb = findById(id);
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        return repository.save(productoDb);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
