/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HiraldoTran
 */
public class ventaFactura {
    private int f_id;
    private String f_tipo_factura;
    private int f_id_t_cliente;
    private int f_id_t_usuario;
    private int f_monto;
    private int f_id_orden;
    private String f_fecha;
    private String f_hecha_por;
    private int f_balance;
    private boolean f_pagada;

     public int getF_id(){
        
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_tipo_factura() {
        return f_tipo_factura;
    }

    public void setF_tipo_factura(String f_tipo_factura) {
        this.f_tipo_factura = f_tipo_factura;
    }

    public int getF_id_t_cliente() {
        return f_id_t_cliente;
    }

    public void setF_id_t_cliente(int f_id_t_cliente) {
        this.f_id_t_cliente = f_id_t_cliente;
    }

    public int getF_id_t_usuario() {
        return f_id_t_usuario;
    }

    public void setF_id_t_usuario(int f_id_t_usuario) {
        this.f_id_t_usuario = f_id_t_usuario;
    }

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }

    public int getF_id_orden() {
        return f_id_orden;
    }

    public void setF_id_orden(int f_id_orden) {
        this.f_id_orden = f_id_orden;
    }

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public String getF_hecha_por() {
        return f_hecha_por;
    }

    public void setF_hecha_por(String f_hecha_por) {
        this.f_hecha_por = f_hecha_por;
    }

    public int getF_balance() {
        return f_balance;
    }

    public void setF_balance(int f_balance) {
        this.f_balance = f_balance;
    }

    public boolean getF_pagada() {
        return f_pagada;
    }

    /*Getter's and Setter's */
    public void setF_pagada(boolean f_pagada) {   
        this.f_pagada = f_pagada;
    }

    /*----------------------------------------------------------------*/
    public String insertar_venta_factura(String informacion) throws Exception {
        DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
        String sql="INSERT INTO public.t_venta_factura(f_tipo_factura,f_id_t_cliente,f_id_t_usuarios,f_monto,f_id_orden,f_hecha_por,f_balance,f_pagada)";
        sql+="VALUES(?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        Gson json = new Gson();
        ventaFactura info = json.fromJson(informacion, ventaFactura.class);
        
        p.setString(1, info.getF_tipo_factura());
        p.setInt(2,info.getF_id_t_cliente());
        p.setInt(3, info.getF_id_t_usuario());
        p.setInt(4, info.getF_monto());
        p.setInt(5,info.getF_id_orden());
        
        p.setString(6, info.getF_hecha_por());
        p.setInt(7, info.getF_balance());
        p.setBoolean(8,info.getF_pagada());
        p.execute();
        return "1";
        }catch(SQLException e){
            return "-1 "+e.getMessage();
        }
    }
   
}
