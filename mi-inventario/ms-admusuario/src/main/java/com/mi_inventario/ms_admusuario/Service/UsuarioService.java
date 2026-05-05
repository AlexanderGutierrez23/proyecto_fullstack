package com.mi_inventario.ms_admusuario.Service;

import com.mi_inventario.ms_admusuario.Model.UsuarioModelo;
import com.mi_inventario.ms_admusuario.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // BUSCAR
    public List<UsuarioModelo> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    // REGISTRAR
    public UsuarioModelo registrarUsuario(UsuarioModelo usuario) {
        usuario.setFechaRegistro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    // ELIMINAR
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    //  ACTUALIZAR
    public UsuarioModelo actualizarUsuario(Long id, UsuarioModelo nuevo) {
        UsuarioModelo usuario = usuarioRepository.findById(id);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        usuario.setNombre(nuevo.getNombre());
        usuario.setApellido(nuevo.getApellido());
        usuario.setRut(nuevo.getRut());
        usuario.setCorreo(nuevo.getCorreo());
        usuario.setEstado(nuevo.getEstado());
        usuario.setTipoTrabajo(nuevo.getTipoTrabajo());
        usuario.setTipo(nuevo.getTipo());
        usuario.setSueldo(nuevo.getSueldo());

        return usuarioRepository.save(usuario);
    }
}
