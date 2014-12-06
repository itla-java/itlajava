/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;


import clases.CheckToken;
import dto.Producto;
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
import dto.Respuesta;
import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import clases.CheckToken;



/**
 * REST Web Service
 *
 * @author Estudiante
 */
@Path("producto")
public class Webservice_Producto {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsproductos
     */
    public Webservice_Producto() {
    }
    
   
    
    //variables de la base de datos token
       
        Gson json = new Gson();
        
    /**
     * Retrieves representation of an instance of Ws.Webservice_Producto
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }


    @GET
    @Path("/getproductoNombre/{token}/{nombre}")
    @Produces("application/json")
    public String getproduct_nombre(
            @PathParam("token") String token,
            @PathParam("nombre") String nombre) throws Exception
    {
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
      //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!check.checktocken2(token)) 
       { 
            respon.setId(2);
            respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
            return respon.ToJson(respon);
                        
       }            
                 
       //realizo el sql de busqueda
        String sql="select * from public.t_productos where f_nombre ilike '%"+nombre+"%';";   
  
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
                Producto producto = new Producto();
  
                producto.setF_id(rs.getInt(1)); //ID del producto
                producto.setF_nombre(rs.getString(2));
                producto.setF_descripcion(rs.getString(3)); 
                producto.setF_costo(rs.getInt(4));
                producto.setF_precio_venta(rs.getInt(5));
                producto.setF_precio_alquiler(rs.getInt(6));
                producto.setF_alquiler_venta(rs.getString(7));
                producto.setF_cantidad_alquiler(rs.getString(8));
                producto.setF_cantidad_venta(rs.getString(9));
                producto.setF_dias_recuperacion(rs.getString(10));
               
                lista.add(producto); //asigno elrs a la lista
            }
        } 
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);
                     
        }
         
        
        respon.setId(1);
        respon.setMensaje(respon.ToJson(lista));//convierto la lista a Gson
        dbase.CerrarConexion();
        return respon.ToJson(respon); //retorno el json        
        
          
    }
    
    
    
    
    
    @GET
    @Path("/getproductoId/{token}/{id}")
    @Produces("application/json")
    public String getproduct_id(
            @PathParam("token") String token,
            @PathParam("id") int id) throws Exception
    {
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
       
        
      //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!check.checktocken2(token)) 
       { 
            respon.setId(2);
            respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
            return respon.ToJson(respon);
                        
       }            
                 
       //realizo el sql de busqueda
        String sql="select * from public.t_productos where f_nombre ilike "+id+";";   
  
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
                Producto producto = new Producto();
  
                producto.setF_id(rs.getInt(1)); //ID del producto
                producto.setF_nombre(rs.getString(2));
                producto.setF_descripcion(rs.getString(3)); 
                producto.setF_costo(rs.getInt(4));
                producto.setF_precio_venta(rs.getInt(5));
                producto.setF_precio_alquiler(rs.getInt(6));
                producto.setF_alquiler_venta(rs.getString(7));
                producto.setF_cantidad_alquiler(rs.getString(8));
                producto.setF_cantidad_venta(rs.getString(9));
                producto.setF_dias_recuperacion(rs.getString(10));
                
                respon.setId(1);
                respon.setMensaje(respon.ToJson(producto));//agrego el Gson de producto a Respuesta
                
            }
        } 
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             
             dbase.CerrarConexion();
             return respon.ToJson(respon);
                     
        }
         
        
        
        return respon.ToJson(respon);         
        //retorno el json
          
    }
    
    
    @POST
    @Path("/insertarproducto")
    @Consumes("application/json")
    public String insertar_producto(
        @FormParam("token") String token ,
        @FormParam("Gson") String gson) throws Exception{
        
         
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        
        if (!ctoken.checktocken2(token)){
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return  respo.ToJson(respo); 
        }
        
        Producto product = new Producto();
        product.insertar_t_productos(gson);
        respo.setId(1);
        respo.setMensaje("Hecho");
        return  respo.ToJson(respo);
        
    }
    
    
    
    
    //*************************************Para EL servlet******************************************************************
    @POST
    @Path("/getproducto")
    @Produces("application/json")
    public String getproduct_id_nombre_pag(
            @FormParam("nombre") String nombre,
            @FormParam("token") String token) throws Exception
    {
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
      //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!check.checktocken2(token)) 
       {
            respon.setId(2);
            respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
            return  respon.ToJson(respon);
                    
       }            
                 
       //realizo el sql de busqueda
        String sql="SELECT f_id,f_nombre,f_descripcion,f_precio_venta,f_precio_alquiler,f_cantidad_alquiler,f_cantidad_venta from public.t_productos where f_nombre ilike '%"+nombre+"%';";   
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            if(!rs.next())
            {
                     
                Respuesta respo = new Respuesta();
                     
                respo.setId(0);
                respo.setMensaje("No hay registros actualmente en la base de datos");
                return respo.ToJson(respo);
                 
            }
            while (rs.next())
            {
                    
                 
                Producto producto = new Producto();
  
                producto.setF_id(rs.getInt(1)); //ID del producto
                producto.setF_nombre(rs.getString(2));
                producto.setF_descripcion(rs.getString(3));
                producto.setF_precio_venta(rs.getInt(4));
                producto.setF_precio_alquiler(rs.getInt(5));
                producto.setF_cantidad_alquiler(rs.getString(6));
                producto.setF_cantidad_venta(rs.getString(7));
             
                //asigno el rs a la lista
                lista.add(producto);
            }
        
        } 
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);        
        }
        
        respon.setId(1);
        respon.setMensaje(respon.ToJson(lista));//convierto la lista a Gson
        dbase.CerrarConexion();
        return respon.ToJson(respon);      //retorno el json   
        
            
    }

   
    
    /**
     * PUT method for updating or creating an instance of Webservice_Producto
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}

