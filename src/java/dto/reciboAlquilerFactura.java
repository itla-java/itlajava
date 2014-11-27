/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import db.DB;
import java.sql.PreparedStatement;

/**
 *
 * @author HiraldoTran
 */

public class reciboAlquilerFactura {
    private int id;
    private int idAlquilerFactura;
    private String tipoFacturaAlquilerFactura;
    private int idCliente;
    private int monto;

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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
    public void insertar_recibo_alquiler_factura(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql="INSERT INTO public.t_recibo_alquiler_factura(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_cliente,f_monto)";
        sql+="VALUES(?,?,?,?)";
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setInt(1, idAlquilerFactura);
        p.setString(2, tipoFacturaAlquilerFactura);
        p.setInt(3, idCliente);
        p.setInt(4, monto);
        
        p.execute();
        
        
    }
    
}
