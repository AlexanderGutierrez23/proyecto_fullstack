package com.mi_inventario.ms_proveedores.service;

import com.mi_inventario.ms_proveedores.model.proveedorModel;
import com.mi_inventario.ms_proveedores.model.estado;
import com.mi_inventario.ms_proveedores.repository.proveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class proveedorService {
    private final proveedorRepository repo;

    //Get
    public List<proveedorModel> verProveedores(){return repo.infoProveedor();}

    //Post
    public proveedorModel registrarProveedor(proveedorModel p){
        p.setEstado(estado.NO_DISPONIBLE);
        return repo.guardarProveedor(p);
    }
    //Delete
    public void eliminarProveedor(Long id){repo.eliminar(id);}

    //Update
    public proveedorModel actualizarProveedor(Long id, proveedorModel p){
        proveedorModel pModel = repo.buscarProveedorPorId(id);

        if (pModel!=null){
            throw new RuntimeException("no disponible/no existe" );
        }
        p.setEstado(p.getEstado());

        return repo.guardarProveedor(p);
    }
}
