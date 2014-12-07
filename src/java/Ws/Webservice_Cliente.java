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
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juan Luis Hiciano
 */
@Path("cliente")
public class Webservice_Cliente {

    /*String host="localhost";
    String db="itla";
    String user="adminm7xt8zn";
    String pass="JaQc2-sekn7A";*/
    
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
    @Path("/insertar_cliente")
    @Produces("application/json")
    public String insertar_cliente(
            @FormParam("token")String token,
            @FormParam("informacion") String informacion) throws Exception {
      
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if(ctoken.checktocken2(token)==0)
        {
            respo.setId(2);
            respo.setMensaje("El token fue desactivado,Comuniquese con el Administrador");
            return respo.ToJson(respo);
        }
        cliente cliente = new cliente();
        cliente.insertar_cliente(informacion);// llamando el metodo con Prepared Statement
        
        respo.setId(1);
        respo.setMensaje("Hecho");
        return respo.ToJson(respo);
        
        
    }
    /*fin del metodo made by:José Aníbal Moronta Mejía*/
    
    
    @GET
    @Produces("application/json")
    @Path("/getcliente/{token}/{id_cliente}")
    public String getCliente(
            @PathParam("token") String token,
            @PathParam("id_cliente") String id) throws Exception
    {
        Respuesta respo  = new Respuesta();
        

        DB dbase = new DB("itla2","itlajava","12345678@itla");
        CheckToken ctoken = new CheckToken();
        
        if (ctoken.checktocken2(token)==0)
        {
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);  
        }

          
       
        
        String sql="Select * from t_cliente where f_id="+id+";";
        ResultSet rs=dbase.execSelect(sql);
        
        try
        {
            if(!rs.next())
            {
                     
                respo.setId(0);
                respo.setMensaje("No hay registros actualmente en la base de datos");
                return respo.ToJson(respo);
            }
            while(rs.next())
            {
                cliente cliente1= new cliente();
           
                cliente1.setF_id(rs.getInt(1));
                cliente1.setF_nombre(rs.getString(2));
                cliente1.setF_apellido(rs.getString(3));
                cliente1.setF_direccion(rs.getString(4));
                cliente1.setF_cedula(rs.getString(5));
                cliente1.setF_telefono1(rs.getString(6));
                cliente1.setF_telefono2(rs.getString(7));
                cliente1.setF_email(rs.getString(8));
                
                respo.setId(1);
                respo.setMensaje(respo.ToJson(cliente1));
            }
       
        }
        catch(SQLException e)
        {
            // error de base de datos
            respo.setId(-1);
            respo.setMensaje("error de la base de datos "+e.getMessage()+" ");
            return respo.ToJson(respo); 
        }
        
    
            dbase.CerrarConexion();
            return respo.ToJson(respo);//retorna el cliente que se iso en el while.
            //fin del metodo cliente que busca por id Maded By José Aníbal moronta
    }
    
    
    @POST //Metodo para el servlet by Juan Luis Hiciano*************************
    @Produces("application/json")
    @Path("/getcliente")
    public String getCliente(
            @FormParam("id") String id) throws Exception 
    {
        Respuesta respo  = new Respuesta();
        

        DB dbase = new DB("itla2","itlajava","12345678@itla"); //instancie el objeto de DB

       
        String sql="Select * from t_cliente where f_id="+id+";";// query
        ResultSet rs=dbase.execSelect(sql);
        
        try
        {
            if(!rs.next())
            {
                     
                respo.setId(0);
                respo.setMensaje("No hay registros actualmente en la base de datos");
                return respo.ToJson(respo);
            }
            while(rs.next())
            {
                cliente cliente1= new cliente();
           
                cliente1.setF_id(rs.getInt(1));
                cliente1.setF_nombre(rs.getString(2));
                cliente1.setF_apellido(rs.getString(3));
                cliente1.setF_direccion(rs.getString(4));
                cliente1.setF_cedula(rs.getString(5));
                cliente1.setF_telefono1(rs.getString(6));
                cliente1.setF_telefono2(rs.getString(7));
                cliente1.setF_email(rs.getString(8));
                
                respo.setId(1);
                respo.setMensaje(respo.ToJson(cliente1));
            }
       
        }
        catch(SQLException e)
        {
            // error de base de datos
            respo.setId(-1);
            respo.setMensaje("error de la base de datos "+e.getMessage()+" ");
            return respo.ToJson(respo); 
        }
        
    
            dbase.CerrarConexion();
            return respo.ToJson(respo);//returna el cliente que se iso en el while.
            //fin del metodo cliente que busca por id Maded By Juan L Hiciano
    }
    
    
    
    
    //metodo que busca el cliente por nombre//
    @GET
    @Path("/getcliente_nombre_apellido/{token}/{nombre}")
    @Produces("application/json")
    public String getCliente_nombre_apellido(
            @PathParam("token") String token,
            @PathParam("nombre") String nombre) throws Exception
    {
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
        ArrayList<cliente> lista = new ArrayList<cliente>();
        
      
        DB dbase = new DB("itla2","itlajava","12345678@itla");//instancie el objeto de DB
          
      
       if (check.checktocken2(token)==0) //Verificamos si el token esta activo 
        {
            respon.setId(2);
            respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
            return respon.ToJson(respon);
                    
        }    
       
       
        String sql="select * from public.t_cliente where f_nombre ilike '%"+nombre+"%';";  //query 
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);  
            if(!rs.next())
            {
                respon.setId(0);
                respon.setMensaje("No hay registros actualmente en la base de datos");
                return respon.ToJson(respon);
                 
            }
            while (rs.next())
            {
                   
                 
                cliente cliente = new cliente();
                
                cliente.setF_id(rs.getInt(1));//id
                cliente.setF_nombre(rs.getString(2));//nombre
                cliente.setF_apellido(rs.getString(3));//apellido
                cliente.setF_direccion(rs.getString(4));//direccion
                cliente.setF_cedula(rs.getString(5));//cedula
                cliente.setF_telefono1(rs.getString(6));//telefono1
                cliente.setF_telefono2(rs.getString(7));//telefono2
                cliente.setF_email(rs.getString(8));//email
                
                
                //asigno elrs a la lista
                lista.add(cliente);
                   
            }
        } 
        catch (Exception e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);
                  
        }
        respon.setId(1);
        respon.setMensaje(respon.ToJson(lista)); //convierto la lista a Gson             
        dbase.CerrarConexion();
        return respon.ToJson(respon);   //retorno el json   
    }
    
    //fin del metodo que busca el cliente por nombre o apellido madeby:José Aníbal Moronta//
    
}
