package com.mi_inventario.ms_bodega.controller;

import com.mi_inventario.ms_bodega.model.bodegaModel;
import com.mi_inventario.ms_bodega.service.bodegaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodega")
public class bodegaController {

    private final bodegaService bodegaService;

    public bodegaController(bodegaService borepo) {
        this.bodegaService = borepo;
    }

    @GetMapping
    public List<bodegaModel> verBodega() {
        return bodegaService.verBodegas();
    }

    @PutMapping("/{id}")
    public bodegaModel actualizaBodega(@PathVariable Long id, @RequestBody bodegaModel Model) {
        return bodegaService.actualizarBodega(id, Model);
    }

    @DeleteMapping("/{id}")
    public void eliminaBodega(@PathVariable Long id) {
        bodegaService.eliminarBodega(id);
    }

    @PostMapping("/{id}")
    public bodegaModel registraBodega(@RequestBody bodegaModel Model) {
        return bodegaService.registrarBodega(Model);
    }

}
