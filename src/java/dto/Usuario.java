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
 * @author COMPAQ
 */
public class Usuario {
    private int f_id;
    private String f_nombre;
    private String f_apellido;
    private String f_usuario;
    private String f_clave;
    private boolean f_proceso;
    private boolean f_activo;

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

    public String getF_usuario() {
        return f_usuario;
    }

    public void setF_usuario(String f_usuario) {
        this.f_usuario = f_usuario;
    }

    public String getF_clave() {
        return f_clave;
    }

    public void setF_clave(String f_clave) {
        this.f_clave = f_clave;
    }

    public boolean isF_proceso() {
        return f_proceso;
    }

   

    public void setF_proceso(boolean f_proceso) {
        this.f_proceso = f_proceso;
    }

    public boolean isF_activo() {
        return f_activo;
    }

    
    public void setF_activo(boolean f_activo) {
        this.f_activo = f_activo;
    }
    
    public String mod_pass(String pass, int id) throws Exception{
        
        DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
        
        String sql="UPDATE public.t_usuarios SET f_clave ='"+ pass +"' WHERE f_id ="+id;
        dbase.executeQuery(sql);
        Respuesta respo = new Respuesta();
        respo.setId(1);
        respo.setMensaje("Hecho");
        dbase.CerrarConexion();
        return respo.ToJson(respo);

    }
     public String insertar_t_usuarios(String informacion) throws Exception {
        
        DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
        String sql="INSERT INTO public.t_usuarios(f_nombre,f_apellido,f_usuario,f_clave,f_proceso,f_activo)";       
        sql+="VALUES(?,?,?,?,?,?)";    
        try{
            PreparedStatement p = DB.conexion.prepareStatement(sql);
            Gson json = new Gson();
            Usuario info = json.fromJson(informacion, Usuario.class);
            
            p.setString(1, info.getF_nombre());
            p.setString(2, info.getF_apellido());
            p.setString(3, info.getF_usuario());
            p.setString(4, info.getF_clave());
            p.setBoolean(5, info.isF_proceso());
            p.setBoolean(6, info.isF_activo());
            
           
            p.execute();
            
            dbase.CerrarConexion();
            return "1";
        }catch(SQLException e){
            return "-1"+ " "+e.getMessage();
        }
    }
    
}