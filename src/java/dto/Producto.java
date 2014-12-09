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
public class Producto {
    private int f_id;
    private String f_nombre;
    private String f_descripcion;
    private int f_costo;
    private int f_precio_venta;
    private int f_precio_alquiler;
    private String f_alquiler_venta;
    private String f_cantidad_alquiler;
    private String f_cantidad_venta;
    private String f_dias_recuperacion;
    /*---------Getters and Setters--------------*/
    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
    /*-------------------------------------------*/
    public String getF_nombre() {
        return f_nombre;
    }

    public void setF_nombre(String f_nombre) {
        this.f_nombre = f_nombre;
    }
     /*-------------------------------------------*/
    public String getF_descripcion() {
        return f_descripcion;
    }
    
    public void setF_descripcion(String f_descripcion) {
        this.f_descripcion = f_descripcion;
    }
     /*-------------------------------------------*/
    public int getF_costo() {
        return f_costo;
    }

    public void setF_costo(int f_costo) {
        this.f_costo = f_costo;
    }
     /*-------------------------------------------*/
    public int getF_precio_venta() {
        return f_precio_venta;
    }

    public void setF_precio_venta(int f_precio_venta) {
        this.f_precio_venta = f_precio_venta;
    }
     /*-------------------------------------------*/
    public int getF_precio_alquiler() {
        return f_precio_alquiler;
    }

    public void setF_precio_alquiler(int f_precio_alquiler) {
        this.f_precio_alquiler = f_precio_alquiler;
    }
     /*-------------------------------------------*/
    public String getF_alquiler_venta() {
        return f_alquiler_venta;
    }

    public void setF_alquiler_venta(String f_alquiler_venta) {
        this.f_alquiler_venta = f_alquiler_venta;
    }
     /*-------------------------------------------*/
    public String getF_cantidad_alquiler() {
        return f_cantidad_alquiler;
    }

    public void setF_cantidad_alquiler(String f_cantidad_alquiler) {
        this.f_cantidad_alquiler = f_cantidad_alquiler;
    }
     /*-------------------------------------------*/
    public String getF_cantidad_venta() {
        return f_cantidad_venta;
    }

    public void setF_cantidad_venta(String f_cantidad_venta) {
        this.f_cantidad_venta = f_cantidad_venta;
    }
     /*-------------------------------------------*/
    public String getF_dias_recuperacion() {
        return f_dias_recuperacion;
    }

    public void setF_dias_recuperacion(String f_dias_recuperacion) {
        this.f_dias_recuperacion = f_dias_recuperacion;
    }

    /*-----------------------****************---Prepared Statement---******************--------------------*/ 
    
    public String insertar_t_productos(String informacion) throws Exception {
        
        DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
        String sql="INSERT INTO public.t_productos(f_nombre,f_descripcion,f_costo,f_precio_venta,f_precio_alquiler,f_alquiler_venta,f_cantidad_alquiler,f_cantidad_venta,f_dias_recuperacion)";       
        sql+="VALUES(?,?,?,?,?,?,?,?,?)";    
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Producto info = json.fromJson(informacion, Producto.class);
            
            p.setString(1, info.getF_nombre());
            p.setString(2, info.getF_descripcion());
            p.setInt(3, info.getF_costo());
            p.setInt(4, info.getF_precio_venta());
            p.setInt(5, info.getF_precio_alquiler());
            p.setString(6, info.getF_alquiler_venta());
            
            p.setString(7, info.getF_cantidad_alquiler());
            p.setString(8,info.getF_cantidad_venta());
            p.setString(9,info.getF_dias_recuperacion());
            p.execute();
            
            dbase.CerrarConexion();
            return "1";
        }catch(SQLException e){
           return"-1"+" "+ e.getMessage();
        }
    }
   
}
