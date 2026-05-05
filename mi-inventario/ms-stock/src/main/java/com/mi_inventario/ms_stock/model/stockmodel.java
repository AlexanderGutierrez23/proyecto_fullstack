package com.mi_inventario.ms_stock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class stockmodel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column (name = "producto") private String producto;

    @NotNull
    @Column (name = "cantidad") private Integer cantidad;

    @NotNull
    @Column (name = "estado") private Estadostock estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Estadostock getEstado() {
        return estado;
    }

    public void setEstado(Estadostock estado) {
        this.estado = estado;
    }
}
