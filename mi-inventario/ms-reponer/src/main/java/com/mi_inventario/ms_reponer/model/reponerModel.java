package com.mi_inventario.ms_reponer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Entity
@Table (name = "reponer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class reponerModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_reponer")
    private Long id;

    @Column (name = "estado")
    private reponerEstados estado;

    @Column (name = "ultimaReposicion")
    private LocalDate ultimaReposicion;

    @Column (name = "stock")
    private int stock;

}