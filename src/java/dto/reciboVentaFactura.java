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
public class reciboVentaFactura {
    private int f_id;
    private int f_id_t_cliente;
    private String f_concepto;
    private String f_fecha;
    private int f_monto;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getF_id_t_cliente() {
        return f_id_t_cliente;
    }

    public void setF_id_t_cliente(int f_id_t_cliente) {
        this.f_id_t_cliente = f_id_t_cliente;
    }

    public String getF_concepto() {
        return f_concepto;
    }

    public void setF_concepto(String f_concepto) {
        this.f_concepto = f_concepto;
    }

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public int getF_monto() {
        return f_monto;
    }

    public void setF_monto(int f_monto) {
        this.f_monto = f_monto;
    }
    
    
    public String insertar_recibo_venta_fact(String informacion) throws Exception{
    
         DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
        String sql="INSERT INTO public.t_recibo_venta_factura (f_id_t_cliente,f_concepto,f_monto)";
        sql+="VALUES (?,?,?)";
      try{
        Gson json = new Gson();
       reciboVentaFactura info = json.fromJson(informacion,reciboVentaFactura.class);
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        
        p.setInt(1, info.getF_id_t_cliente());
        p.setString(2,info.getF_concepto());
        p.setInt(3, info.getF_monto());
        p.execute();
        dbase.CerrarConexion();
        return "1";
      }catch(SQLException e){
          return "-1 "+e.getMessage();
      }
    
    }
    
    
}
