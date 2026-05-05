package com.mi_inventario.ms_admusuario.Repository;

import com.mi_inventario.ms_admusuario.Model.UsuarioModelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // OBTENER
    public List<UsuarioModelo> findAll() {
        return entityManager
                .createQuery("SELECT u FROM UsuarioModelo u", UsuarioModelo.class)
                .getResultList();
    }

    // GUARDAR
    public UsuarioModelo save(UsuarioModelo usuario) {
        if (usuario.getId() == null) {
            entityManager.persist(usuario);
            return usuario;
        } else {
            return entityManager.merge(usuario);
        }
    }

    // BUSCAR POR ID
    public UsuarioModelo findById(Long id) {
        return entityManager.find(UsuarioModelo.class, id);
    }

    // BORRAR
    public void deleteById(Long id) {
        UsuarioModelo usuario = entityManager.find(UsuarioModelo.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }
}
