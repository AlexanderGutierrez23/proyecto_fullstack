package com.mi_inventario.ms_productos.controller;
import com.mi_inventario.ms_productos.service.ProductoService;
import com.mi_inventario.ms_productos.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public String guardarProducto(@RequestBody Producto producto){
        productoService.RegistrarProducto(producto);
        return "Producto guardado exitosamente";
    }

    @PostMapping
    public List<Producto> listarProductos(){
        return  productoService.ListarProductos();
    }

    @PostMapping("/{id}")
    public Producto buscarProducto(@PathVariable long id){
        return productoService.verProducto(id);}

    @PostMapping
    public String actualizarProducto(@RequestBody Producto producto){
        productoService.modificarProducto(producto);
        return "Producto actualizado exitosamente";
    }

    @PostMapping("/{id}")
    public String eliminarProducto(@PathVariable long id){
        productoService.eliminarProducto(id);
        return "Producto eliminado exitosamente";
    }
}
