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
public class facturaRecibo {
    private int idVentaFactura;
    private String tipoFacturaVentaFactura;
    private int monto;
    private String fecha;
    private int idReciboVentaFactura;

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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdReciboVentaFactura() {
        return idReciboVentaFactura;
    }

    public void setIdReciboVentaFactura(int idReciboVentaFactura) {
        this.idReciboVentaFactura = idReciboVentaFactura;
    }
    
    
}
