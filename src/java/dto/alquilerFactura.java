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
    private int f_id;
    private String f_dpo_factura;
    private int f_id_cliente;
    private String f_fecha;
    private String f_hechaPor;
    private int f_id_usuario;
    private int f_monto,f_balance;
    private boolean f_pagada;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_dpo_factura() {
        return f_dpo_factura;
    }

    public void setF_dpo_factura(String f_dpo_factura) {
        this.f_dpo_factura = f_dpo_factura;
    }

    public int getF_id_cliente() {
        return f_id_cliente;
    }

    public void setF_id_cliente(int f_id_cliente) {
        this.f_id_cliente = f_id_cliente;
    }

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public String getF_hechaPor() {
        return f_hechaPor;
    }

    public void setF_hechaPor(String f_hechaPor) {
        this.f_hechaPor = f_hechaPor;
    }

    public int getF_id_usuario() {
        return f_id_usuario;
    }

    public void setF_id_usuario(int f_id_usuario) {
        this.f_id_usuario = f_id_usuario;
    }

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }

    public int getF_balance() {
        return f_balance;
    }

    public void setF_balance(int f_balance) {
        this.f_balance = f_balance;
    }

    public boolean isF_pagada() {
        return f_pagada;
    }

    public void setF_pagada(boolean f_pagada) {
        this.f_pagada = f_pagada;
    }
    
  
    
     
    public void insertar_alquiler_factura(String informacion) throws Exception{
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        String sql="INSERT INTO public.t_alquiler_factura(f_tipo_factura,f_id_t_cliente,f_id_t_usuarios,f_fecha,f_hecha_por,f_monto,f_balance,f_pagada)";
        sql+="VALUES(?,?,?,?,?,?,?,?)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setString(1,f_dpo_factura);
        p.setInt(2, f_id_cliente);
        p.setInt(3, f_id_usuario);
        p.setString(4, f_fecha);
        p.setString(5, f_hechaPor);
        p.setInt(6,f_monto);
        p.setInt(6,f_balance);
        p.setBoolean(7,f_pagada);
        p.execute();
        
        }
    
    
}
