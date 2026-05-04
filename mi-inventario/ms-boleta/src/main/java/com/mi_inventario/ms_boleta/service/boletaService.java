package com.mi_inventario.ms_boleta.service;

import com.mi_inventario.ms_boleta.model.Boleta;
import com.mi_inventario.ms_boleta.model.ESTADO;
import com.mi_inventario.ms_boleta.repository.boletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

@Service
public class boletaService {

    @Autowired
    private boletaRepository brep;

    private List<Boleta> obtenerInfo(){
        return this.brep.infoBoleta();
    }

    private Boleta crearBoleta(Boleta bo){
        bo.setFecha(LocalDate.now());
        if (bo.getEstado() == null){
            bo.setEstado(ESTADO.PENDIENTE);
        }
        return this.brep.registrarBoleta(bo);
    }

    private void eliminarBoleta(Long id) {
        this.brep.eliminarBoleta(id);
    }

}
