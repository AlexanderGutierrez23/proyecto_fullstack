package com.mi_inventario.ms_categoria.repository;

import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.*;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.mi_inventario.ms_categoria.model.categoriaModel;

import java.util.List;

@Repository
@Transactional
public class categoriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<categoriaModel> encontrarCategoria() {
        return entityManager
                .createQuery("SELECT v FROM categoriaModel v",  categoriaModel.class)
                .getResultList();
    }

    public categoriaModel guardarCategoria(categoriaModel cat) {
        if (cat.getId() == null){
            entityManager.persist(cat);
            return cat;
        } else {
            return entityManager.merge(cat);
        }
    }

    public categoriaModel encontrarPorId(Long id) {
        return entityManager.find(categoriaModel.class, id);
    }

    public void borrarCategoria (Long id) {
        categoriaModel cat = entityManager.find(categoriaModel.class, id);
        if (cat != null) {
            entityManager.remove(cat);
        }
    }

}