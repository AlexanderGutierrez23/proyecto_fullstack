package com.mi_inventario.ms_productos.repository;
import com.mi_inventario.ms_productos.model.productosModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class productosRepository {

    @PersistenceContext
    private EntityManager em;

    public List<productosModel> infoProductos() {
        return em
                .createQuery("SELECT p FROM productosModel p", productosModel.class)
                .getResultList();
    }

    public productosModel guardarProductos(productosModel pro) {
        if (pro.getId() == null) {
            em.persist(pro);
            return pro;
        }
        return em.merge(pro);
    }

    public productosModel encontrarPorId(Long id) {
        return em.find(productosModel.class, id);
    }

    public void borrarProductos(Long id) {
        productosModel pro = em.find(productosModel.class, id);
        if (pro != null) {
            em.remove(pro);
        }
    }
}