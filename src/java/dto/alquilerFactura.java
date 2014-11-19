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
public class alquilerFactura {
    private int id;
    private String dpo_factura;
    private int id_cliente;
    private String fecha;
    private String hechaPor;
    private int id_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpo_factura() {
        return dpo_factura;
    }

    public void setDpo_factura(String dpo_factura) {
        this.dpo_factura = dpo_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHechaPor() {
        return hechaPor;
    }

    public void setHechaPor(String hechaPor) {
        this.hechaPor = hechaPor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
