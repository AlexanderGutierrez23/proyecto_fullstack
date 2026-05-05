package com.mi_inventario.ms_categoria.service;

import com.mi_inventario.ms_categoria.model.categoriaEstados;
import com.mi_inventario.ms_categoria.repository.categoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mi_inventario.ms_categoria.model.categoriaModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class categoriaService {

    private final categoriaRepository catRepo;

    public List<categoriaModel> verCategoria() {
        return catRepo.encontrarCategoria();
    }

    public categoriaModel registrarCategoria(categoriaModel cat) {
        if (cat.getEstado() == null) {
            cat.setEstado(categoriaEstados.INACTIVO);
        }
        return catRepo.guardarCategoria(cat);
    }

    public void eliminarCategoria(Long id){
        catRepo.borrarCategoria(id);
    }

    public categoriaModel actualizarCategoria(Long id, categoriaModel cat) {
        categoriaModel categoriaExistente = catRepo.encontrarPorId(id);

        if (categoriaExistente == null) {
            throw new RuntimeException("Categoria no encontrada");
        }

        categoriaExistente.setEstado(cat.getEstado());
        return catRepo.guardarCategoria(categoriaExistente);
    }

}
