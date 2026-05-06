package com.mi_inventario.ms_productos.controller;

import com.mi_inventario.ms_productos.model.productosModel;
import com.mi_inventario.ms_productos.repository.productosRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class productosController {

    private final productosRepository proRepo;

    public productosController(productosRepository pro) {
        this.proRepo = pro;
    }

    @GetMapping
    public List<productosModel> verProductos() {
        return proRepo.infoProductos();
    }

    @PutMapping("/{id}")
    public productosModel actualizar(@PathVariable Long id, @RequestBody productosModel pro) {
        productosModel proM = proRepo.encontrarPorId(id);
        if (proM != null) {
            proM.setNombre(pro.getNombre());
            proM.setUnidad(pro.getUnidad());
            proM.setEstado(pro.getEstado());
            proM.setFechaVencimiento(LocalDate.now());
        }
        return null;
    }
}