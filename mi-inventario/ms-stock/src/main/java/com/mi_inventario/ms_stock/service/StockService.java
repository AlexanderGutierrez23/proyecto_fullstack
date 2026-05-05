package com.mi_inventario.ms_stock.service;

import com.mi_inventario.ms_stock.repository.StockRepository;
import com.mi_inventario.ms_stock.model.stockmodel;
import com.mi_inventario.ms_stock.model.Estadostock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    //  GET
    public List<stockmodel> verStock() {
        return stockRepository.findAll();
    }

    //  POST
    public stockmodel registrarStock(stockmodel stock) {
        stock.setEstado(calcularEstado(stock.getCantidad()));
        return stockRepository.save(stock);
    }

    //  DELETE
    public void eliminarStock(Long id) {
        stockRepository.deleteById(id);
    }

    //  UPDATE
    public stockmodel actualizarStock(Long id, stockmodel nuevo) {
        stockmodel stock = stockRepository.findById(id);

        if (stock == null) {
            throw new RuntimeException("Stock no encontrado");
        }

        stock.setProducto(nuevo.getProducto());
        stock.setCantidad(nuevo.getCantidad());
        stock.setEstado(calcularEstado(nuevo.getCantidad()));

        return stockRepository.save(stock);
    }

    // Lógica automática de estado
    private Estadostock calcularEstado(int cantidad) {
        if (cantidad == 0) return Estadostock.AGOTADO;
        if (cantidad < 5) return Estadostock.BAJO_STOCK;
        if (cantidad > 100) return Estadostock.SOBRE_STOCK;
        return Estadostock.DISPONIBLE;
    }


}
