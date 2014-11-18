/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.cliente;
import db.DB;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import  java.sql.ResultSet;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * REST Web Service
 *
 * @author Estudiante
 */
@Path("producto")
public class wsproductos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsproductos
     */
    public wsproductos() {
    }
    
    //variables de la base de datos 
        String Host = "localhost";
        String Database ="itla";
        String User = "localhost";
        String Pass = "localhost";
        String sql;
        Gson json = new Gson();
        cliente cliente1 = new cliente();
        ArrayList<cliente> lista = new ArrayList<cliente>();
    /**
     * Retrieves representation of an instance of Ws.wsproductos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/getproducto")
    @Produces("application/json")
    public String getproducto(){
        //Asigne los parametros de onccion a la base de datos
        
        
        
        //instancie el objeto de DB
       DB dbase = new DB(Host,Database,User,Pass);
       
       //realizo el sql
       sql="select * from public.t.products";
       
         try{
      
       ResultSet rs = dbase.execSelect(sql);   
       while (rs.next()){
           cliente cliente = new cliente();
           
           cliente.setId(rs.getInt(1));
           cliente.setNombre(rs.getString(2));
           cliente.setApellido(rs.getString(3));
           cliente.setDireccion(rs.getString(4));
           cliente.setCedula(rs.getString(5));
           cliente.setTelefono1(rs.getString(6));
           cliente.setTelefono2(rs.getString(7));
           cliente.setEmail(rs.getString(8));
           
           lista.add(cliente);
       
       }
    } catch (Exception e) {
        //si falla un error de base de datos
            return "-1: Error de la base de datos ";
        }
        
        //convierto la lista a Gson
        String json1=json.toJson(lista);
        
        //retorno el json
        return json1;
    }


    /**
     * PUT method for updating or creating an instance of wsproductos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}