package com.mi_inventario.ms_categoria.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class categoriaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Long id;

    @Column (name = "estado")
    private categoriaEstados estado;

}
