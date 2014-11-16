/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import db.DB;
import java.sql.PreparedStatement;

/**
 *
 * @author HiraldoTran
 */
public class recargos {
    private int id;
    private int idAlquilerFactura;
    private String tipoFacturaAlquilerFactura;
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

    public String getTipoFacturaAlquilerFactura() {
        return tipoFacturaAlquilerFactura;
    }

    public void setTipoFacturaAlquilerFactura(String tipoFacturaAlquilerFactura) {
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
    
    public void insertar_recargos(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2", "itlajava", "12345678@itla");
        
        String sql;
        
        sql="INSERT INTO public.t_recargos(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_descripcion,f_monto,f_hecho_por,f_pagado)";
        sql+="VALUES (?,?,?,?,?,?)";
        
        Gson json = new Gson();
       recargos info = json.fromJson(informacion,recargos.class);
        
        PreparedStatement p  = DB.conexion.prepareStatement(sql);
        p.setInt(1, idAlquilerFactura);
        p.setString(2,tipoFacturaAlquilerFactura);
        p.setString(3,descripcion);
        p.setInt(4, monto);
        p.setString(5, hechoPor);
        p.setBoolean(6, pagado);
        p.execute();
        
    
    }
    
    
}
