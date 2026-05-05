package com.mi_inventario.ms_categoria.controller;

import com.mi_inventario.ms_categoria.model.categoriaModel;
import com.mi_inventario.ms_categoria.service.*;
import org.springframework.web.bind.annotation.*;
import com.mi_inventario.ms_categoria.repository.categoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class categoriaController {

    private final categoriaRepository catRepo;

    public categoriaController (categoriaRepository catRepo) {
        this.catRepo = catRepo;
    }

    @GetMapping
    public List<categoriaModel> verCategoria() {
        return catRepo.encontrarCategoria();
    }

    @PutMapping("/{id}")
    public categoriaModel actualizar (@PathVariable Long id, @RequestBody categoriaModel cat) {
        categoriaModel exis = catRepo.encontrarPorId(id);
        if (exis != null) {
            exis.setEstado(cat.getEstado());
            return catRepo.guardarCategoria(exis);
        }
        return null;
    }

}
