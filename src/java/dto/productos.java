/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author HiraldoTran
 */
public class productos {
    private int id;
    private String descripcion;
    private int costo;
    private int precioVenta;
    private int precioAlquiler;
    private String alquilerVenta;
    private String cantidadALquiler;
    private String cantidadVenta;
    private String diasRecuperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getAlquilerVenta() {
        return alquilerVenta;
    }

    public void setAlquilerVenta(String alquilerVenta) {
        this.alquilerVenta = alquilerVenta;
    }

    public String getCantidadALquiler() {
        return cantidadALquiler;
    }

    public void setCantidadALquiler(String cantidadALquiler) {
        this.cantidadALquiler = cantidadALquiler;
    }

    public String getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(String cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public String getDiasRecuperacion() {
        return diasRecuperacion;
    }

    public void setDiasRecuperacion(String diasRecuperacion) {
        this.diasRecuperacion = diasRecuperacion;
    }
    
    
}
