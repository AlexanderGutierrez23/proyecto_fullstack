package com.example.ms-admusuario.controller;

import com.example.ms-admusuario.service.UsuarioService;
import com.example.ms-admusuario.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public  String guardar (@RequestBody Usuarios u) {
        service.guardar(u);
        return "Usuario Guardado";
    }

    @PostMapping
    public List<Usuarios> listar() {
        return service.listar();
    }

    @PostMapping("/{id}")
    public Usuarios buscar(@PathVariable long id) {
        return service.buscar(id);
    }
     @PostMapping
    public  String actualizar (@RequestBody Usuarios u) {
        service.actualizar(u);
        return  "Usuario actualizado";
    }

     @PostMapping("/{id}")
    public String eliminar (@PathVariable  long id) {
          service.eliminar(id);
          return "Usuario Eliminado";
     }

}
