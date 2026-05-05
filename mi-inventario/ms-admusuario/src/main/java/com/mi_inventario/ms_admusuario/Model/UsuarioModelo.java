package com.mi_inventario.ms_admusuario.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "rut", nullable = false, unique = true, length = 20)
    private String rut;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoUsuario estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_trabajo", nullable = false)
    private TipoTrabajo tipoTrabajo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoUsuario tipo;

    @Column(name = "sueldo", nullable = false)
    private Double sueldo;
}
