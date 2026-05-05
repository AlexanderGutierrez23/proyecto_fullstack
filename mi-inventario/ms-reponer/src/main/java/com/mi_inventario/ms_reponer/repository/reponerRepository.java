package com.mi_inventario.ms_reponer.repository;

import com.mi_inventario.ms_reponer.model.reponerModel;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Transactional
public class reponerRepository {

    @PersistenceContext
    private EntityManager em;


    //Obtener
    public List<reponerModel> infoReponer() {
        return em
                .createQuery("SELECT r FROM reponerModel r", reponerModel.class)
                .getResultList();
    }


    //Guardar
    public reponerModel guardar (reponerModel re) {
        if (re.getId() == null) {
            em.persist(re);
            return re;
        } else {
            return em.merge(re);
        }
    }


    //Buscar Por Id
    public reponerModel infoReponerPorId(Long id) {
        return em.find(reponerModel.class, id);
    }


    //Eliminar
    public void eliminar (Long id) {
        reponerModel re = em.find(reponerModel.class, id);
        if (re != null) {
            em.remove(re);
        }
    }

}