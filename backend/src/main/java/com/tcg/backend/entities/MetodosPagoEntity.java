package com.tcg.backend.entities;
import java.sql.Date;
public class MetodosPagoEntity {

    private int id_metodo_de_pago;
    private String tipo_de_pago;
    private String banco;
    private String nombre_titular;
    private int numero_tarjeta;
    private Date fecha_vencimiento;
    private int codigo_seguridad;
    private int rut_titular;


    public MetodosPagoEntity() {
        this.id_metodo_de_pago = -1;
        this.tipo_de_pago = null;
        this.banco = null;
        this.nombre_titular = null;
        this.numero_tarjeta = -1;
        this.fecha_vencimiento = null;
        this.codigo_seguridad = -1;
        this.rut_titular = -1;
    }

    public MetodosPagoEntity(int id_metodo_de_pago, String tipo_de_pago,
                             String banco, String nombre_titular, int numero_tarjeta,
                             Date fecha_vencimiento, int codigo_seguridad, int rut_titular) {
        this.id_metodo_de_pago = id_metodo_de_pago;
        this.tipo_de_pago = tipo_de_pago;
        this.banco = banco;
        this.nombre_titular = nombre_titular;
        this.numero_tarjeta = numero_tarjeta;
        this.fecha_vencimiento = fecha_vencimiento;
        this.codigo_seguridad = codigo_seguridad;
        this.rut_titular = rut_titular;
    }

    public int getId_metodo_de_pago() {
        return id_metodo_de_pago;
    }

    public void setId_metodo_de_pago(int id_metodo_de_pago) {
        this.id_metodo_de_pago = id_metodo_de_pago;
    }

    public String getTipo_de_pago() {
        return tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        this.tipo_de_pago = tipo_de_pago;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public int getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(int numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCodigo_seguridad() {
        return codigo_seguridad;
    }

    public void setCodigo_seguridad(int codigo_seguridad) {
        this.codigo_seguridad = codigo_seguridad;
    }

    public int getRut_titular() {
        return rut_titular;
    }

    public void setRut_titular(int rut_titular) {
        this.rut_titular = rut_titular;
    }
}
