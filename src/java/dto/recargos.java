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
public class recargos {
    private int id;
    private int idAlquilerFactura;
    private int tipoFacturaAlquilerFactura;
    private String descripcion;
    private int monto;
    private String hechoPor;
    private boolean pagado;

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

    public int getTipoFacturaAlquilerFactura() {
        return tipoFacturaAlquilerFactura;
    }

    public void setTipoFacturaAlquilerFactura(int tipoFacturaAlquilerFactura) {
        this.tipoFacturaAlquilerFactura = tipoFacturaAlquilerFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getHechoPor() {
        return hechoPor;
    }

    public void setHechoPor(String hechoPor) {
        this.hechoPor = hechoPor;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    
}
