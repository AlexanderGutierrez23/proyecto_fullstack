package com.mi_inventario.ms_ventas.service;

import com.mi_inventario.ms_ventas.model.ventasModel;
import com.mi_inventario.ms_ventas.model.EstadoVenta;
import com.mi_inventario.ms_ventas.repository.ventasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ventasService {

    private final ventasRepository ventasRepository;

    // OBTENER
    public List<ventasModel> verVenta() {
        return ventasRepository.findAll();
    }

    // GUARDAR
    public ventasModel registrarVenta(ventasModel venta) {
        if (venta.getEstado() == null) {
            venta.setEstado(EstadoVenta.PENDIENTE);
        }
        return ventasRepository.save(venta);
    }

    // ELIMINAR
    public void eliVenta(Long id) {
        ventasRepository.deleteById(id);
    }

    // ACTUALIZAR
    public ventasModel actualizarVenta(Long id, ventasModel nuevo) {
        ventasModel venta = ventasRepository.findById(id);

        if (venta == null) {
            throw new RuntimeException("Venta no encontrada");
        }

        venta.setProducto(nuevo.getProducto());
        venta.setTotal(nuevo.getTotal());
        venta.setEstado(nuevo.getEstado());

        return ventasRepository.save(venta);
    }
}
