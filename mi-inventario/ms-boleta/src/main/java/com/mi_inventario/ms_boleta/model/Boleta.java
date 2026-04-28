package com.mi_inventario.ms_boleta.model;

import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleta {

    private Long id;

    private LocalDate fecha;
    private ESTADO estado;
    private METODO_PAGO metodoPago;
    private double monto;

    /*
    RECORDATORIO: AGREGAR EL ADMUSUARIO CUANDO ESTE LISTO :(
    TAMBIEN EN CASO DE QUE LOMBOK NO FUNCIONE :)
    28/04/2026 - buhduoc
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }

    public METODO_PAGO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(METODO_PAGO metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
