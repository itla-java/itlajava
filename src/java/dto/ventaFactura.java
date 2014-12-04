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
public class ventaFactura {
    private int id;
    private String tpo_factura;
    private int id_cliente;
    private int id_usuario;
    private int f_monto;
    private int id_orden;
    private String fecha;
    private String hechaPor;
    private int f_balance;
    private boolean f_pagada;

    /*Getter's and Setter's */
    public String getTpo_factura() {
        return tpo_factura;
    }

    public void setTpo_factura(String tpo_factura) {
        this.tpo_factura = tpo_factura;
    }
    /*----------------------------------------------------------------*/

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }
     /*----------------------------------------------------------------*/

    public int getF_balance() {
        return f_balance;
    }

    public void setF_balance(int f_balance) {
        this.f_balance = f_balance;
    }
     /*----------------------------------------------------------------*/

    public boolean getF_pagada() {
        return f_pagada;
    }

    public void setF_pagada(boolean f_pagada) {
        this.f_pagada = f_pagada;
    }
     /*----------------------------------------------------------------*/
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     /*----------------------------------------------------------------*/

    public String getDpo_factura() {
        return tpo_factura;
    }

    public void setDpo_factura(String dpo_factura) {
        this.tpo_factura = dpo_factura;
    }
     /*----------------------------------------------------------------*/

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
     /*----------------------------------------------------------------*/

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }
     /*----------------------------------------------------------------*/

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     /*----------------------------------------------------------------*/

    public String getHechaPor() {
        return hechaPor;
    }

    public void setHechaPor(String hechaPor) {
        this.hechaPor = hechaPor;
    }
     /*----------------------------------------------------------------*/

    
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    /*----------------------------------------------------------------*/
     public void insertar_detalle_venta_factura(String informacion) throws Exception{
        
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        String sql="INSERT INTO public.t_venta_factura(f_tipo_factura,f_id_t_cliente,f_id_t_usuarios,f_monto,f_id_orden,f_fecha,f_hecha_por,f_balance,f_pagada)";
        sql+="VALUES(?,?,?,?,?,?,?,?,?)";    
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        Gson json = new Gson();
        ventaFactura info = json.fromJson(informacion, ventaFactura.class);
        p.setInt(1, id);
        p.setString(2, tpo_factura);
        p.setInt(3, id_cliente);
        p.setInt(4, id_usuario);
        p.setInt(5, f_monto);
        p.setInt(6, id_orden);
        p.setString(7, fecha);
        p.setString(8, hechaPor);
        p.setInt(9, f_balance);
        p.setBoolean(10, f_pagada);
        p.execute();
    }
   
}
