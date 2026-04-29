package com.mi_inventario.ms_productos.service;
import com.mi_inventario.ms_productos.repository.ProductosRepository;
import com.mi_inventario.ms_productos.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductosRepository repo;

    public Producto verProducto (Long id){ return repo.verProducto(id);}

    public Producto modificarProducto(Producto producto){return repo.modProducto(producto);}

    public void  RegistrarProducto(Producto producto){
        repo.guardar(producto);
    }

    public List<Producto> ListarProductos(){
        return repo.listarProducto();
    }

    public void eliminarProducto(Long id){ repo.eliProducto(id);}
}
