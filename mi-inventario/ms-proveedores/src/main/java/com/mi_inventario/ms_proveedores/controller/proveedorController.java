package com.mi_inventario.ms_proveedores.controller;

import com.mi_inventario.ms_proveedores.model.proveedorModel;
import com.mi_inventario.ms_proveedores.repository.proveedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class proveedorController {

    private final proveedorRepository proRepo;

    public proveedorController(proveedorRepository proRepo) {
        this.proRepo = proRepo;
    }

    @GetMapping
    public List<proveedorModel> verProveedores() {
        return proRepo.infoProveedor();
    }

    @PutMapping("/{id}")
    public proveedorModel actualizaProveedore(@PathVariable long id, @RequestBody proveedorModel pro) {
        proveedorModel model = proRepo.buscarProveedorPorId(id);
        if (model != null) {
            model.setNombre(pro.getNombre());
            model.setDescripcion(pro.getDescripcion());
            model.setEmpresa(pro.getEmpresa());
            model.setEstado(pro.getEstado());
            return proRepo.guardarProveedor(model);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminaProveedore(@PathVariable long id) {
        proRepo.eliminar(id);
    }
}

