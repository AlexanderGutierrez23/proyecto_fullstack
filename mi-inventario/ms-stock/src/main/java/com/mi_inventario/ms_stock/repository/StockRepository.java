package com.mi_inventario.ms_stock.repository;

import com.mi_inventario.ms_stock.model.stockmodel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //Obtener
    public List<stockmodel> findAll () {
        return entityManager
                .createQuery("SELECT s FROM stockmodel s", stockmodel.class)
                .getResultList();
    }

    //Guardar
    public stockmodel save (stockmodel stock) {
        if (stock.getId() == null) {
            entityManager.persist(stock);
            return stock;
        }else {
            return entityManager.merge(stock);
        }
    }

    //Buscar por id
    public stockmodel findById(long id) {
        return entityManager.find(stockmodel.class,id);
    }

    //Eliminar
    public void deleteById(long id) {
        stockmodel stock = entityManager.find(stockmodel.class, id);
        if (stock != null) {
            entityManager.remove(stock);
        }
    }
}
