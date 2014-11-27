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
public class alquilerFactura {
    private int id;
    private String dpo_factura;
    private int id_cliente;
    private String fecha;
    private String hechaPor;
    private int id_usuario;
    private int monto,balance;
    private boolean pagada;
    
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

    public int getMonto() {
        return monto;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
    
     
    public void insertar_alquiler_factura(String informacion) throws Exception{
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        String sql="INSERT INTO public.t_alquiler_factura(f_tipo_factura,f_id_t_cliente,f_id_t_usuarios,f_fecha,f_hecha_por,f_monto,f_balance,f_pagada)";
        sql+="VALUES(?,?,?,?,?,?,?,?)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setString(1,dpo_factura);
        p.setInt(2, id_cliente);
        p.setInt(3, id_usuario);
        p.setString(4, fecha);
        p.setString(5, hechaPor);
        p.setInt(6,monto);
        p.setInt(6,balance);
        p.setBoolean(7,pagada);
        p.execute();
        
        }
    
    
}
