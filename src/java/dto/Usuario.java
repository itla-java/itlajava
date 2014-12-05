/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import db.DB;

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
        
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql="UPDATE public.t_usuarios SET f_clave ="+ pass +"WHERE f_id ="+id;
        dbase.executeQuery(sql);
        Respuesta respo = new Respuesta();
        respo.setId(1);
        respo.setMensaje("Hecho");
        return respo.ToJson(respo);

    }
    
}