package com.inventas.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "codigo_ccc")
    private String codigoCamaraComercio;

    private Long telefono;

    private Long celular;

    private String correo;

    @Column(name = "cod_invima")
    private String codigoInvima;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoCamaraComercio() {
        return codigoCamaraComercio;
    }

    public void setCodigoCamaraComercio(String codigoCamaraComercio) {
        this.codigoCamaraComercio = codigoCamaraComercio;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigoInvima() {
        return codigoInvima;
    }

    public void setCodigoInvima(String codigoInvima) {
        this.codigoInvima = codigoInvima;
    }
}
