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
public class detalleVentaFactura {
   private int id;
   private int idVentaFactura;
   private String tipoFacturaVentaFactura;
   private int idProducto;
   private int precio;
   private int cantidad;
   private int costo;
   private int itbis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVentaFactura() {
        return idVentaFactura;
    }

    public void setIdVentaFactura(int idVentaFactura) {
        this.idVentaFactura = idVentaFactura;
    }

    public String getTipoFacturaVentaFactura() {
        return tipoFacturaVentaFactura;
    }

    public void setTipoFacturaVentaFactura(String tipoFacturaVentaFactura) {
        this.tipoFacturaVentaFactura = tipoFacturaVentaFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
