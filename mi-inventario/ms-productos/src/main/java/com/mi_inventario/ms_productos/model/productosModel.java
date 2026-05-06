package com.mi_inventario.ms_productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "producto")
public class productosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "unidad")
    private int unidad;

    @Column(name = "estado")
    private productosEstados estado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    /*
    aqui va:
    private categoria
     */

}