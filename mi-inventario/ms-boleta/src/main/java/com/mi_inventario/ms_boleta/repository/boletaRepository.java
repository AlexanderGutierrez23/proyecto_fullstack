package com.mi_inventario.ms_boleta.repository;

import com.mi_inventario.ms_boleta.model.Boleta;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class boletaRepository {

    private List<Boleta> repoBoleta = new ArrayList<>();
    private Long currentId = 1L;

    /*
    1 - Informacion Boleta / infoBoleta
    2 - Registra la boleta / registrarBoleta
    3 - Hacer consulta sobre una boleta / consultarBoleta
    4 - Eliminar Boleta SIMPLE / eliminarBoleta
    28/04/2026 - buhduoc

    Deberia haber una opcion de modificar Boleta? - buhduoc

     */

    public List<Boleta> infoBoleta(){
        return repoBoleta;
    }

    public Boleta registrarBoleta(Boleta bo){
        bo.setId(currentId++);
        repoBoleta.add(bo);
        return bo;
    }

    public Boleta consultarBoleta(Long id) {
        return repoBoleta.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminarBoleta(Long id) {
        repoBoleta.removeIf(b -> b.getId() == id);
    }

}
