package com.mi_inventario.ms_reportes.model;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Entity
@Table(name= "reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class reporteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reporte")
    @NotNull
    private Long id;

    @Column(name= "descripcion")
    @NotBlank
    private String descripcion;

    @Column(name= " fechaReporte")
    @NotNull
    private LocalDate fechaReporte;


}
