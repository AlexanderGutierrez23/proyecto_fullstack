package com.mi_inventario.ms_ventas.controller;

import com.mi_inventario.ms_ventas.model.ventasModel;
import com.mi_inventario.ms_ventas.service.ventasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class ventasController {

    private final ventasService ventasService;

    public ventasController(ventasService ventasService) {
        this.ventasService = ventasService;
    }

    // OBTENER
    @GetMapping
    public List<ventasModel> verVenta() {
        return ventasService.verVenta();
    }

    // REGISTRAR O GUARDAR
    @PostMapping
    public ventasModel registrarVenta(@RequestBody ventasModel venta) {
        return ventasService.registrarVenta(venta);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliVenta(@PathVariable Long id) {
        ventasService.eliVenta(id);
    }

    //  ACTUALIZAR
    @PutMapping("/{id}")
    public ventasModel actualizarVenta(@PathVariable Long id, @RequestBody ventasModel venta) {
        return ventasService.actualizarVenta(id, venta);
    }
}
