package com.mi_inventario.ms_ventas.repository;

import com.mi_inventario.ms_ventas.model.ventasModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ventasRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // OBTENER
    public List<ventasModel> findAll() {
        return entityManager
                .createQuery("SELECT v FROM ventasModel v", ventasModel.class)
                .getResultList();
    }

    // GUARDAR
    public ventasModel save(ventasModel venta) {
        if (venta.getId() == null) {
            entityManager.persist(venta);
            return venta;
        } else {
            return entityManager.merge(venta);
        }
    }

    // BUSCAR POR ID
    public ventasModel findById(Long id) {
        return entityManager.find(ventasModel.class, id);
    }

    // ELIMINAR
    public void deleteById(Long id) {
        ventasModel venta = entityManager.find(ventasModel.class, id);
        if (venta != null) {
            entityManager.remove(venta);
        }
    }
}
