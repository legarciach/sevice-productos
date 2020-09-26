package com.springboot.app.productos.controllers;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/listar")
    public List<Producto> listas(){
        return service.findAll();
    }

    @GetMapping("/ver/{id}")
    public  Producto detalle(@PathVariable Long id){
        return service.findById(id);
    }

}
