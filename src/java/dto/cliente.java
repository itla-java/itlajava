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
public class cliente {
    private int f_id; 
    private String f_nombre;
    private String f_apellido;
    private String f_direccion;
    private String f_cedula;
    private String f_telefono1;
    private String f_telefono2;
    private String f_email;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_nombre() {
        return f_nombre;
    }

    public void setF_nombre(String f_nombre) {
        this.f_nombre = f_nombre;
    }

    public String getF_apellido() {
        return f_apellido;
    }

    public void setF_apellido(String f_apellido) {
        this.f_apellido = f_apellido;
    }

    public String getF_direccion() {
        return f_direccion;
    }

    public void setF_direccion(String f_direccion) {
        this.f_direccion = f_direccion;
    }

    public String getF_cedula() {
        return f_cedula;
    }

    public void setF_cedula(String f_cedula) {
        this.f_cedula = f_cedula;
    }

    public String getF_telefono1() {
        return f_telefono1;
    }

    public void setF_telefono1(String f_telefono1) {
        this.f_telefono1 = f_telefono1;
    }

    public String getF_telefono2() {
        return f_telefono2;
    }

    public void setF_telefono2(String f_telefono2) {
        this.f_telefono2 = f_telefono2;
    }

    public String getF_email() {
        return f_email;
    }

    public void setF_email(String f_email) {
        this.f_email = f_email;
    }


    
   public void insertar_cliente(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql = "INSERT INTO public.t_cliente(f_nombre,f_apellido,f_direccion,f_cedula,f_telefono1,f_telefono2,f_email)";
        sql+="VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        Gson json = new Gson();
       cliente info = json.fromJson(informacion, cliente.class);
       
        p.setString(1, info.getF_nombre());
        p.setString(2,info.getF_apellido());
        p.setString(3, info.getF_direccion());
        p.setString(4, info.getF_cedula());
        p.setString(5, info.getF_telefono1());
        p.setString(6, info.getF_telefono2());
        p.setString(7, info.getF_email());
        p.execute();
        
        dbase.CerrarConexion();

    }
    
    
}
