package com.example.ms-admusuario.service;

import com.example.ADMUsuarios.repository.UsuariosRepository;
import com.example.ADMUsuarios.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository repo;

    public void guardar ( Usuarios u) {
        repo.guardar(u);
    }

    public List<Usuarios> listar() {
        return repo.listar();

    }

    public Usuarios buscar (long id) {
        return repo.buscar(id);
    }

    public void actualizar (Usuarios u) {
         repo.actualizar(u);
    }

    public void eliminar (long id) {
        repo.eliminar(id);
    }



}
