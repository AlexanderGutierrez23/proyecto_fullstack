package com.example.ms-admusuario.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private int Telefono;
    private LocalDate fechaRegistro;
    private Double sueldo;
    private com.example.ms-admusuario.model.Tipo tipo;
    private com.example.ms-admusuario.model.Estado estado;
    private com.example.ms-admusuario.model.Tipo_Trabajo tipoTrabajo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public com.example.ms-admusuario.model.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(com.example.ms-admusuario.model.Tipo tipo) {
        this.tipo = tipo;
    }

    public com.example.ms-admusuario.model.Estado getEstado() {
        return estado;
    }

    public void setEstado(com.example.ms-admusuario.model.Estado estado) {
        this.estado = estado;
    }

    public com.example.ms-admusuario.model.Tipo_Trabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(com.example.ms-admusuario.model.Tipo_Trabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }
}
