package com.mi_inventario.ms_categoria.service;
import com.mi_inventario.ms_categoria.repository.CategoriaRepository;
import com.mi_inventario.ms_categoria.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public void guardarCategoria(Categoria categoria){
        categoriaRepo.agregarCategoria(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepo.listarCategorias();
    }

    public Categoria buscarCategoria(Long id){
        return categoriaRepo.buscarCategoria(id);
    }

    public void modificarCategoria(Categoria categoria){
        categoriaRepo.editarCategoria(categoria);
    }

    public void eliminarCategoria(Long id){
        categoriaRepo.eliminarCategoria(id);
    }
}
