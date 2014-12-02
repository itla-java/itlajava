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
    private int f_id;
    private int f_id_t_alquiler_factura;
    private String f_tipo_factura_t_alquiler_factura;
    private String f_descripcion;
    private int f_monto;
    private String f_hecho_por;
    private boolean f_pagado;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getF_id_t_alquiler_factura() {
        return f_id_t_alquiler_factura;
    }

    public void setF_id_t_alquiler_factura(int f_id_t_alquiler_factura) {
        this.f_id_t_alquiler_factura = f_id_t_alquiler_factura;
    }

    public String getF_tipo_factura_t_alquiler_factura() {
        return f_tipo_factura_t_alquiler_factura;
    }

    public void setF_tipo_factura_t_alquiler_factura(String f_tipo_factura_t_alquiler_factura) {
        this.f_tipo_factura_t_alquiler_factura = f_tipo_factura_t_alquiler_factura;
    }

    public String getF_descripcion() {
        return f_descripcion;
    }

    public void setF_descripcion(String f_descripcion) {
        this.f_descripcion = f_descripcion;
    }

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }

    public String getF_hecho_por() {
        return f_hecho_por;
    }

    public void setF_hecho_por(String f_hecho_por) {
        this.f_hecho_por = f_hecho_por;
    }

    public boolean isF_pagado() {
        return f_pagado;
    }

    public void setF_pagado(boolean f_pagado) {
        this.f_pagado = f_pagado;
    }

   
    public void insertar_recargos(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2", "itlajava", "12345678@itla");
        
        String sql;
        
        sql="INSERT INTO public.t_recargos(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_descripcion,f_monto,f_hecho_por,f_pagado)";
        sql+="VALUES (?,?,?,?,?,?)";
        
        Gson json = new Gson();
       recargos info = json.fromJson(informacion,recargos.class);
        
        PreparedStatement p  = DB.conexion.prepareStatement(sql);
        p.setInt(1, f_id_t_alquiler_factura);
        p.setString(2,f_tipo_factura_t_alquiler_factura);
        p.setString(3,f_descripcion);
        p.setInt(4, f_monto);
        p.setString(5, f_hecho_por);
        p.setBoolean(6, f_pagado);
        p.execute();
        
    
    }
    
    
}
