package com.mi_inventario.ms_productos.controller;

import com.mi_inventario.ms_productos.model.productosModel;
import com.mi_inventario.ms_productos.service.productosService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class productosController {

    private final productosService proSer;

    public productosController(productosService pro) {
        this.proSer = pro;
    }

    @GetMapping
    public List<productosModel> verProductos() {
        return proSer.verProductos();
    }

    @PutMapping("/{id}")
    public productosModel actualizar(@PathVariable Long id, @RequestBody productosModel pro) {
        productosModel proM = proSer.actualizarProducto(id, pro);
        if (proM != null) {
            proM.setNombre(pro.getNombre());
            proM.setUnidad(pro.getUnidad());
            proM.setEstado(pro.getEstado());
            proM.setFechaVencimiento(LocalDate.now());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proSer.eliminarProducto(id);
    }

    @PostMapping("/{id}")
    public productosModel registrarProducto(@RequestBody productosModel pro) {
        return proSer.registrarProducto(pro);
    }
}