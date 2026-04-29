package com.mi_inventario.ms_categoria.repository;
import com.mi_inventario.ms_categoria.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CategoriaRepository {

    @PersistenceContext
    private EntityManager em;

    //Guardar
    public Categoria agregarCategoria(Categoria categoria){
        em.persist(categoria);
        return categoria;
    }

    //Listar
    public List<Categoria> listarCategorias(){
        return em.createQuery("FROM Categoria", Categoria.class)
                .getResultList();
    }

    //VerCategorias
    public Categoria buscarCategoria(Long id){
        return em.find(Categoria.class, id);
    }

    //ModificarCategorias
    public Categoria editarCategoria(Categoria categoria){return em.merge(categoria);
    }

    //EliminarCategoria
    public Categoria eliminarCategoria(Long id){
        Categoria categoria = buscarCategoria(id);
        if(categoria != null){
            em.remove(categoria);
        }
        return categoria;
    }
}
