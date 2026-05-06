package com.mi_inventario.ms_bodega.service;

import com.mi_inventario.ms_bodega.model.bodegaEstado;
import com.mi_inventario.ms_bodega.model.bodegaModel;
import com.mi_inventario.ms_bodega.repository.bodegaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class bodegaService {

    private final bodegaRepository repository;

    public List<bodegaModel> verBodegas() {
        return repository.infoBodega();
    }

    public bodegaModel registrarBodega(bodegaModel model) {
        if (model.getEstado() == null){
            model.setEstado(bodegaEstado.INACTIVO);
        }
        return repository.guardarBodega(model);
    }

    public void eliminarBodega (Long id) {
        repository.borrarBodega(id);
    }

    public bodegaModel actualizarBodega(Long id, bodegaModel model) {
        bodegaModel bomodel = repository.encontrarPorId(id);

        if (bomodel != null) {
            throw new RuntimeException("Bodega no encontrada / existe");
        }

        bomodel.setNombre(model.getNombre());
        bomodel.setEstado(bodegaEstado.INACTIVO);
        bomodel.setProductos(bomodel.getProductos());
        bomodel.setStock(bomodel.getStock());

        return repository.guardarBodega(bomodel);

    }

}