package com.mi_inventario.ms_categoria.controller;
import com.mi_inventario.ms_categoria.service.CategoriaService;
import com.mi_inventario.ms_categoria.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaSer;

    @PostMapping
    public String guardar(@RequestBody Categoria categoria){
        categoriaSer.guardarCategoria(categoria);
        return "Categoria guardada correctamente";
    }

    @PostMapping
    public List<Categoria> listar(){
        return categoriaSer.listarCategorias();
    }

    @PostMapping("/{id}")
    public Categoria buscar(@PathVariable long id){
        return categoriaSer.buscarCategoria(id);
    }

    @PostMapping
    public String actualizar(@RequestBody Categoria categoria){
        categoriaSer.modificarCategoria(categoria);
        return "Categoria modificada correctamente";
    }

    @PostMapping("/{id}")
    public String eliminar(@PathVariable long id){
        categoriaSer.eliminarCategoria(id);
        return "Categoria eliminada correctamente";
    }
}
