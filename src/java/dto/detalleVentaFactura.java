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
import javax.ws.rs.PathParam;

/**
 *
 * @author HiraldoTran
 */
public class detalleVentaFactura {
   private int f_id;
   private int f_id_t_venta_factura;
   private String f_tipo_Factura_t_venta_factura;
   private int f_id_t_Productos;
   private int f_precio;
   private int f_cantidad;
   private int f_costo;
   private int f_itbis;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getF_Id_t_venta_factura() {
        return f_id_t_venta_factura;
    }

    public void setId_t_venta_factura(int id_t_venta_factura) {
        this.f_id_t_venta_factura = id_t_venta_factura;
    }

    public String getF_tipo_Factura_t_venta_factura() {
        return f_tipo_Factura_t_venta_factura;
    }

    public void setF_tipo_Factura_t_venta_factura(String f_tipo_Factura_t_venta_factura) {
        this.f_tipo_Factura_t_venta_factura = f_tipo_Factura_t_venta_factura;
    }

    public int getF_id_t_Productos() {
        return f_id_t_Productos;
    }

    public void setF_id_t_Productos(int f_id_t_Productos) {
        this.f_id_t_Productos = f_id_t_Productos;
    }

    public int getF_precio() {
        return f_precio;
    }

    public void setF_precio(int f_precio) {
        this.f_precio = f_precio;
    }

    public int getF_cantidad() {
        return f_cantidad;
    }

    public void setF_cantidad(int f_cantidad) {
        this.f_cantidad = f_cantidad;
    }

    public int getF_costo() {
        return f_costo;
    }

    public void setF_costo(int f_costo) {
        this.f_costo = f_costo;
    }

    public int getF_itbis() {
        return f_itbis;
    }

    public void setF_itbis(int f_itbis) {
        this.f_itbis = f_itbis;
    }

    
   
    public String insertar_detalle_venta_factura(String informacion) throws Exception{
        
        DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");   
        String sql="INSERT INTO public.t_detalle_venta_factura(f_id_t_venta_factura,f_tipo_factura_t_venta_factura,f_id_t_productos,f_precio,f_cantidad,f_costo,f_itbis)";
        sql+="VALUES(?,?,?,?,?,?,?)";
        try{
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        Gson json = new Gson();
        detalleVentaFactura info = json.fromJson(informacion, detalleVentaFactura.class);
        p.setInt(1, info.getF_Id_t_venta_factura());
        p.setString(2, info.getF_tipo_Factura_t_venta_factura());
        p.setInt(3, info.getF_id_t_Productos());
        p.setInt(4, info.getF_precio());
        p.setInt(5, info.getF_cantidad());
        p.setInt(6, info.getF_costo());
        p.setInt(7, info.getF_itbis());
        p.execute();
        
        dbase.CerrarConexion();
        return "1";
        }catch(SQLException e){
            return "-1 "+e.getMessage();
        }
    
    }
   
}
