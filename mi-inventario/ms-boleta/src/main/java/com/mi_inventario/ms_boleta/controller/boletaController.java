package com.mi_inventario.ms_boleta.controller;

import com.mi_inventario.ms_boleta.model.Boleta;
import com.mi_inventario.ms_boleta.service.boletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping({"/boleta"})
public class boletaController {

    @Autowired
    private boletaService bserv;

    @GetMapping
    public List<Boleta> getBoletas() {
        return this.getBoletas();
    }

    @GetMapping({"/{id}"})
    public Boleta getBoletaPorId (@PathVariable Long id){
        return
    }



}
