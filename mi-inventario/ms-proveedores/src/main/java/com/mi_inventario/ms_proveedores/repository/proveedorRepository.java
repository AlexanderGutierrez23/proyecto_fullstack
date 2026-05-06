package com.mi_inventario.ms_proveedores.repository;
import com.mi_inventario.ms_proveedores.model.proveedorModel;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
@Transactional
public class proveedorRepository {
    @PersistenceContext
    private EntityManager em;

    //obtener
    public List<proveedorModel> infoProveedor(){
        return em.createQuery("select  p from proveedorModel p", proveedorModel.class)
                .getResultList();
    }

    //guardar
    public proveedorModel guardarProveedor(proveedorModel pro){
        if(pro.getId()==null){
            em.persist(pro);
            return pro;
        }else{
            return em.merge(pro);
        }
    }

    //Buscar por id
    public proveedorModel buscarProveedorPorId(Long id){return em.find(proveedorModel.class,id);}

   //Eliminar
   public void eliminar (Long id){
        proveedorModel p = em.find(proveedorModel.class,id);
        if(p!=null){
            em.remove(p);
        }
   }
}
