package com.mi_inventario.ms_proveedores.model;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "Proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class proveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    @NotNull
    private Long id;

    @Column(name="nombre")
    @NotBlank
    private String nombre;

    @Column(name= "descripcion")
    @NotBlank
    private String descripcion;

    @Column(name = "estado")
    @NotNull
    private estado estado;

    @Column(name ="Empresa")
    @NotNull
    private String empresa;

}
