package com.springboot.app.productos.controllers;

import com.springboot.app.commons.models.entity.Producto;
import com.springboot.app.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/listar")
    public List<Producto> listas() {
        return service.findAll();
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) throws Exception {
        //Prueba Hystrix
        /*
        if (true){
            throw new Exception("Problemas al cargar producto....");
        }
        */

        //Prueba Timeout
        /*
        try {
            Thread.sleep(2000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        */
        return service.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        return service.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@PathVariable Long id, @RequestBody Producto producto){
        Producto db = service.findById(id);
        db.setNombre(producto.getNombre());
        db.setPrecio(producto.getPrecio());
        return service.save(db);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        service.deleteById(id);
    }




}
