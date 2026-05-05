package com.mi_inventario.ms_admusuario.Controller;

import com.mi_inventario.ms_admusuario.Model.UsuarioModelo;
import com.mi_inventario.ms_admusuario.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // 🔍OBTENER
    @GetMapping
    public List<UsuarioModelo> buscarUsuarios() {
        return usuarioService.buscarUsuarios();
    }

    // REGISTRAR
    @PostMapping
    public UsuarioModelo registrarUsuario(@RequestBody UsuarioModelo usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public UsuarioModelo actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModelo usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }
}
