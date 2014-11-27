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
public class cliente {
    private int id; 
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String telefono1;
    private String telefono2;
    private String email;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void insertar_cliente(String informacion) throws Exception{
    
    
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql = "INSERT INTO public.t_cliente(f_nombre,f_apellido,f_direccion,f_cedula,f_telefono1,f_telefono2,f_email)";
        sql+="VALUES (?,?,?,?,?,?,?,?)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        
        p.setString(1, nombre);
        p.setString(2, apellido);
        p.setString(3, direccion);
        p.setString(4, cedula);
        p.setString(5, telefono1);
        p.setString(6, telefono2);
        p.setString(7, email);
        p.execute();

    }
    
    
}
