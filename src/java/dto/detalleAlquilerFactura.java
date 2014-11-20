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
public class detalleAlquilerFactura {
    private int id;
    private int idAlquilerFactura;
    private int tipoFactura_alquilerFactura;
    private int idProducto;
    private String fechaSalida;
    private String fechaEntrada;
    private String cantidad;
    private int precio;
    private int costo;
    private int itbis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlquilerFactura() {
        return idAlquilerFactura;
    }

    public void setIdAlquilerFactura(int idAlquilerFactura) {
        this.idAlquilerFactura = idAlquilerFactura;
    }

    public int getTipoFactura_alquilerFactura() {
        return tipoFactura_alquilerFactura;
    }

    public void setTipoFactura_alquilerFactura(int tipoFactura_alquilerFactura) {
        this.tipoFactura_alquilerFactura = tipoFactura_alquilerFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getItbis() {
        return itbis;
    }

    public void setItbis(int itbis) {
        this.itbis = itbis;
    }
    
    
}
