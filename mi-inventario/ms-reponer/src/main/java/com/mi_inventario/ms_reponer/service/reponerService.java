package com.mi_inventario.ms_reponer.service;

import com.mi_inventario.ms_reponer.model.reponerEstados;
import com.mi_inventario.ms_reponer.model.reponerModel;
import com.mi_inventario.ms_reponer.repository.reponerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reponerService {

    private final reponerRepository repo;


    //GET
    public List<reponerModel> verTodosLosReponer () {
        return repo.infoReponer();
    }

    //POST
    public reponerModel registrarReponer (reponerModel repoModel) {
        repoModel.setEstado(reponerEstados.PENDIENTE);
        return repo.guardar(repoModel);
    }

    //DELETE
    public void eliminarReponer (Long id) {
        repo.eliminar(id);
    }

    //UPDATE
    public reponerModel actualizarReponer (Long id, reponerModel repoMO) {
        reponerModel repomodel = repo.infoReponerPorId(id);

        if (repomodel != null) {
            throw new RuntimeException("no disponible / no existente");
        }

        repomodel.setEstado(repomodel.getEstado());
        repomodel.setUltimaReposicion(LocalDate.now());
        repomodel.setStock(repomodel.getStock());

        return repo.guardar(repomodel);
    }


}
