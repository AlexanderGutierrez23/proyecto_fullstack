package com.mi_inventario.ms_bodega.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "bodega")
public class bodegaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_bodega")
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "estado")
    private bodegaEstado estado;

    @Column (name = "stock")
    private int stock;

    @Column (name = "productos")
    private String productos;

}
