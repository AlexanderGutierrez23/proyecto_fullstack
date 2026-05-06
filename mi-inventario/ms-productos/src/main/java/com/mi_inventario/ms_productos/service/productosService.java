package com.mi_inventario.ms_productos.service;

import com.mi_inventario.ms_productos.model.productosEstados;
import com.mi_inventario.ms_productos.model.productosModel;
import com.mi_inventario.ms_productos.repository.productosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class productosService {

    private final productosRepository proRepo;

    public List<productosModel> verProductos() {
        return proRepo.infoProductos();
    }

    public productosModel registrarProducto(productosModel pro) {
        if (pro.getEstado() == null) {
            pro.setEstado(productosEstados.AGOTADO);
        }
        return proRepo.guardarProductos(pro);
    }

    public void eliminarProducto(Long id) {
        proRepo.borrarProductos(id);
    }

    public productosModel actualizarProducto(Long id, productosModel pro) {
        productosModel proM = proRepo.encontrarPorId(id);

        if (proM != null) {
            throw new RuntimeException("Producto no encontrado");
        }

        proM.setNombre(pro.getNombre());
        proM.setUnidad(pro.getUnidad());
        proM.setEstado(pro.getEstado());
        proM.setFechaVencimiento(LocalDate.now());

        return proRepo.guardarProductos(proM);
    }
}
