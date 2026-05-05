package com.mi_inventario.ms_stock.controller;

import com.mi_inventario.ms_stock.model.stockmodel;
import com.mi_inventario.ms_stock.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    //  OBTENER
    @GetMapping
    public List<stockmodel> verStock() {
        return stockService.verStock();
    }

    //  ENVIAR
    @PostMapping
    public stockmodel registrarStock(@RequestBody stockmodel stock) {
        return stockService.registrarStock(stock);
    }

    //  ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarStock(@PathVariable Long id) {
        stockService.eliminarStock(id);
    }

    //  ACTUALIZAR
    @PutMapping("/{id}")
    public stockmodel actualizarStock(@PathVariable Long id, @RequestBody stockmodel stock) {
        return stockService.actualizarStock(id, stock);
    }
}
