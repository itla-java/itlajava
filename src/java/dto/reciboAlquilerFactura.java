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
public class reciboAlquilerFactura {
    private int id;
    private int idAlquilerFactura;
    private String tipoFacturaAlquilerFactura;
    private int idCliente;

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

    public String getTipoFacturaAlquilerFactura() {
        return tipoFacturaAlquilerFactura;
    }

    public void setTipoFacturaAlquilerFactura(String tipoFacturaAlquilerFactura) {
        this.tipoFacturaAlquilerFactura = tipoFacturaAlquilerFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
