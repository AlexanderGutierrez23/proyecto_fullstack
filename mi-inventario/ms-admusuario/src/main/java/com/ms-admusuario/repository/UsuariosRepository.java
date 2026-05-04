package com.example.ms-admusuario.repository;

import com.example.ADMUsuarios.model.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuariosRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Guardar
    public Usuarios guardar(Usuarios usuarios) {
        entityManager.persist(usuarios);
        return usuarios;
    }

    //Listar
    public List<Usuarios> listar(){
        return entityManager
                .createQuery("FROM Usarios",Usuarios.class)
                .getResultList();
    }

    //Buscar por id
    public Usuarios buscar(Long id) {
        return entityManager.find(Usuarios.class, id);
    }

    //Actualizar
    public  Usuarios actualizar(Usuarios usuarios) {
        return entityManager.merge(usuarios);
    }

    //Eliminar
    public Usuarios eliminar(long id) {
        Usuarios usuarios = buscar(id);
        if (usuarios != null) {
            entityManager.remove(usuarios);
        }
        return usuarios;
    }



}
