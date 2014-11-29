/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import dto.cliente;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import java.sql.SQLException;
import com.google.gson.Gson;
import db.DB;
import dto.Producto;
import dto.Respuesta;
import  java.sql.ResultSet;
import dto.cliente;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaTray;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juan Luis Hiciano
 */
@Path("cliente")
public class Webservice_Cliente {

    String host="localhost";
    String db="itla";
    String user="adminm7xt8zn";
    String pass="JaQc2-sekn7A";
    ArrayList<cliente> list= new ArrayList<cliente>();
    Gson json = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebserviceClient
     */
    public Webservice_Cliente() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebserviceClient
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WebserviceClient
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    
    /*Metodo que inserta un cliente*/
    @POST
    @Path("/insertar_cliente/{informacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_cliente(@PathParam("informacion") String informacion ) throws Exception {
      
            cliente cliente = new cliente();
            
            cliente.insertar_cliente(informacion);
    }
    /*fin del metodo made by:José Aníbal Moronta Mejía*/
    
    
    @GET
    @Produces("application/json")
    @Path("/getcliente")
    public String getCliente() throws Exception
    {
          //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql="Select * from t_cliente ;";
        try{
        ResultSet rs=dbase.execSelect(sql);
        while(rs.next())
        {
            cliente cliente1= new cliente();
            
            cliente1.setId(rs.getInt(1));
            cliente1.setNombre(rs.getString(2));
            cliente1.setApellido(rs.getString(3));
            cliente1.setDireccion(rs.getString(4));
            cliente1.setCedula(rs.getString(5));
            cliente1.setTelefono1(rs.getString(6));
            cliente1.setTelefono2(rs.getString(7));
            cliente1.setEmail(rs.getString(8));
            
            //asigno el rs a la lista
            list.add(cliente1);
            
            
            
        }
        }
        catch(Exception e)
        {
            //si falla un error de base de datos
            return "-1: Error de la base de datos ";
        }
        
         //convierto la lista a Gson
        String Gson=json.toJson(list);
        
        //retorno el json
        return Gson;
    }
    
    
    
    
    //metodo que busca el cliente epor nombre o apellido//
    @GET
    @Path("/getcliente_nombre_apellido/{token}/{id}")
    @Produces("application/json")
    public String getCliente_nombre_apellido(@PathParam("id") String id,@PathParam("token") String token) throws Exception
    {
        Respuesta respon = new Respuesta();
        ArrayList<cliente> lista = new ArrayList<cliente>();
        
      //instancie el objeto de DB
        DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       //Verificamos si el token esta activo 
       
        CheckToken ver = new CheckToken();
       
       
       if (!ver.checktocken(dbase, token)){
       
           { respon.setId(-1);
         respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
         String json1=json.toJson(respon);
         return json1;              
       }    
       
       
       }
       
       
                 
       //realizo el sql de busqueda
        String sql="select * from public.t_cliente where f_nombre ilike '%"+id+"%' or f_apellido ilike '%"+id+"%';";   
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            while (rs.next())
             {
                cliente cliente = new cliente();
                
                cliente.setId(rs.getInt(1));//id
                cliente.setNombre(rs.getString(2));//nombre
                cliente.setApellido(rs.getString(3));//apellido
                cliente.setDireccion(rs.getString(4));//direccion
                cliente.setCedula(rs.getString(5));//cedula
                cliente.setTelefono1(rs.getString(6));//telefono1
                cliente.setTelefono2(rs.getString(7));//telefono2
                cliente.setEmail(rs.getString(8));//email
                
                
                //asigno elrs a la lista
                lista.add(cliente);
            }
        } catch (Exception e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             String json1=json.toJson(respon);
             return json1;          
        }
         //convierto la lista a Gson
        String json1=json.toJson(lista);
        respon.setId(1);
        respon.setMensaje(json1);
        json1=json.toJson(respon);         
        //retorno el json
        return json1;     
    }
    
    //fin del metodo que busca el cliente epor nombre o apellido madeby:José Aníbal Moronta//
    
}
