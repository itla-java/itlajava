/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;

/**
 *
 * @author Estudiante
 */
public class Respuesta {
    
    private int id;
    private String mensaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /*Metodo que vuelve un objeot a Json
    Made by José Aníbal Moronta*/
    public String ToJson(Object objeto){
    
        Gson json = new Gson();
        String respuesta = json.toJson(objeto);
        return respuesta;
    }
    
}
