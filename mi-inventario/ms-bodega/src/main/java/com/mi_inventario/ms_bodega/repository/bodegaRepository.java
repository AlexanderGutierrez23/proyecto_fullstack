package com.mi_inventario.ms_bodega.repository;

import com.mi_inventario.ms_bodega.model.bodegaModel;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class bodegaRepository {

    private EntityManager em;

    public List<bodegaModel> infoBodega () {
        return em
                .createQuery("SELECT b FROM bodegaModel b", bodegaModel.class)
                .getResultList();
    }

    public bodegaModel guardarBodega (bodegaModel bmodel) {
        if (bmodel.getId() == null) {
            em.persist(bmodel);
            return bmodel;
        }
        return em.merge(bmodel);
    }

    public bodegaModel encontrarPorId (Long id) {
        return em.find(bodegaModel.class, id);
    }

    public void borrarBodega (Long id) {
        bodegaModel model = em.find(bodegaModel.class, id);
        if (model != null) {
            em.remove(model);
        }
    }

}
