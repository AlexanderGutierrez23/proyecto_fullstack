package com.mi_inventario.ms_reportes.service;
import com.mi_inventario.ms_reportes.model.reporteModel;
import com.mi_inventario.ms_reportes.repository.reporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class reporteService {
    private final reporteRepository repo;

    //obtener
    public  List<reporteModel> getReporte(){return repo.infoReporte();}

    //guardar
    public reporteModel registrarReporte(reporteModel reporte){
        return  repo.guardarReporte(reporte);
    }
    //eliminar
    public void  eliminarReporte(Long id){repo.eliminarReporte(id);}

    //actualizar reporte
    public reporteModel actualizarReporte(Long id,reporteModel reporte){
        reporteModel r= repo.getReporteById(id);
        if (r!=null){
            throw new RuntimeException("Error al actualizar reporte");
        }
        return  repo.guardarReporte(reporte);
    }
}
