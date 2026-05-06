package com.mi_inventario.ms_reportes.Repository;

import com.mi_inventario.ms_reportes.Model.Reporte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ReporteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reporte> encontrarReporte() {
        return entityManager
                .createQuery("SELECT v FROM Reporte v",  Reporte.class)
                .getResultList();
    }

    public Reporte guardarReporte(Reporte cat) {
        if (cat.getId() == null){
            entityManager.persist(cat);
            return cat;
        } else {
            return entityManager.merge(cat);
        }
    }

    public Reporte actualizar (Reporte r) {
        return entityManager.merge(r);
    }

    public void borrarReporte (Long id) {
        Reporte cat = entityManager.find(Reporte.class, id);
        if (cat != null) {
            entityManager.remove(cat);
        }
    }
}
