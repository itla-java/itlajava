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

public class reciboAlquilerFactura {
    private int f_id;
    private int f_id_t_alquiler_factura;
    private String f_tipo_factura_t_alquiler_factura;
    private int f_id_t_cliente;
    private int f_monto;

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

    public int getF_id_t_cliente() {
        return f_id_t_cliente;
    }

    public void setF_id_t_cliente(int f_id_t_cliente) {
        this.f_id_t_cliente = f_id_t_cliente;
    }

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }

    
    
    public void insertar_recibo_alquiler_factura(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql="INSERT INTO public.t_recibo_alquiler_factura(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_cliente,f_monto)";
        sql+="VALUES(?,?,?,?)";
        
        Gson json = new Gson();
       reciboAlquilerFactura info = json.fromJson(informacion, reciboAlquilerFactura.class);
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setInt(1, f_id_t_alquiler_factura);
        p.setString(2, f_tipo_factura_t_alquiler_factura);
        p.setInt(3, f_id_t_cliente);
        p.setInt(4, f_monto);
        
        p.execute();
        
        
    }
    
}
