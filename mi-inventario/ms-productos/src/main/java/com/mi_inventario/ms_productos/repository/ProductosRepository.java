package com.mi_inventario.ms_productos.repository;
import com.mi_inventario.ms_productos.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import  org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductosRepository {

    @PersistenceContext
    private EntityManager em;

     //guardar
     public Producto guardar(Producto producto) {
         em.persist(producto);
         return producto;
     }

     //listar
     public List<Producto> listarProducto() {
         return em
                 .createQuery("from Producto ", Producto.class)
                 .getResultList();
     }
    //VerProductos
    public Producto verProducto(Long id){return em.find(Producto.class, id);}

    //ModProductos
    public Producto modProducto(Producto producto) {return em.merge(producto);}

    //EliProductos
    public Producto eliProducto(Long id){
         Producto producto = verProducto(id);
         if(producto != null){
             em.remove(producto);
         }
         return producto;
    }
}
