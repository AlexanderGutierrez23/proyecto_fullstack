package com.mi_inventario.ms_reportes.repository;
import com.mi_inventario.ms_reportes.model.reporteModel;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
@Transactional
public class reporteRepository {
    @PersistenceContext
    private EntityManager em;

    //obtener
    public List <reporteModel> infoReporte(){
        return em.createQuery("select r from reporteModel r", reporteModel.class)
                .getResultList();
    }

    //guardar
    public reporteModel guardarReporte(reporteModel reporte){
        if(reporte.getId() == null){
            em.persist(reporte);
            return reporte;
        }else {
            em.merge(reporte);
            return reporte;
        }
    }

    //buscar por id
    public reporteModel getReporteById(Long id){return em.find(reporteModel.class,id);}

    //eliminar
    public void eliminarReporte(Long id){
        reporteModel reporte = em.find(reporteModel.class,id);
        if(reporte != null){
            em.remove(reporte);
        }
    }
}
