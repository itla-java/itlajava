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
    @Path("/getproducto/{token}/{nombre}")
    @Produces("application/json")
    public String getproduct_id_nombre(@PathParam("nombre") String nombre,@PathParam("token") String token) throws Exception
    {
        Respuesta respon = new Respuesta();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
      //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!checktocken(dbase,token)) 
       { respon.setId(-1);
         respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
         String json1=json.toJson(respon);
         return json1;              
       }            
                 
       //realizo el sql de busqueda
        String sql="select * from public.t_productos where f_nombre ilike '%"+nombre+"%';";   
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
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
                //asigno elrs a la lista
                lista.add(producto);
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


    @POST
    @Path("/insertarproducto")
    @Consumes("application/json")
    public String insertar_producto(
        @FormParam("token") String token ,
        @FormParam("Gson") String gson) throws Exception{
        
         
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        
        if (ctoken.checktocken2(token)==false){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            return  respo.ToJson(respo); 
        }
        
        Producto product = new Producto();
        product.insertar_t_productos(gson);
        respo.setId(1);
        respo.setMensaje("Hecho");
        return  respo.ToJson(respo);
        
    }
    
    @GET
    @Path("/insertarproduct/{token}/{informacion}")
    @Consumes("application/json")
    public void insertar_product(@PathParam("token")String token,@PathParam("informacion")String json) throws Exception{
        
         
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==true){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            respo.ToJson(respo);
        }
        
        Producto product = new Producto();
        product.insertar_t_productos(json);
        respo.setId(1);
        respo.setMensaje("Hecho");
        respo.ToJson(respo);
                
      
    }
    
    //*************************************Revisar******************************************************************
    @POST
    @Path("/getproducto")
    @Produces("application/json")
    public String getproduct_id_nombre_pag(@FormParam("nombre") String nombre,@FormParam("token") String token) throws Exception
    {
        Respuesta respon = new Respuesta();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
      //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!checktocken(dbase,token)) 
       { respon.setId(-1);
         respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
         String json1=json.toJson(respon);
         return json1;              
       }            
                 
       //realizo el sql de busqueda
        String sql="SELECT f_id,f_nombre,f_descripcion,f_precio_venta,f_precio_alquiler,f_cantidad_alquiler,f_cantidad_venta from public.t_productos where f_nombre ilike '%"+nombre+"%';";   
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            while (rs.next())
             {
                    if(!rs.next()){
                     
                     Respuesta respo = new Respuesta();
                     
                     respo.setId(0);
                     respo.setMensaje("No hay registros actualmente en la base de datos");
                     return respo.ToJson(respo);
                 
                 }
                 else {
                Producto producto = new Producto();
  
                producto.setF_id(rs.getInt(1)); //ID del producto
                producto.setF_nombre(rs.getString(2));
                producto.setF_descripcion(rs.getString(3));
                producto.setF_precio_venta(rs.getInt(4));
                producto.setF_precio_alquiler(rs.getInt(5));
                producto.setF_cantidad_alquiler(rs.getString(6));
                producto.setF_cantidad_venta(rs.getString(7));
             
                //asigno elrs a la lista
                lista.add(producto);
                    }
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

    static private boolean checktocken(DB dbase,String token)
    {

       String sql="select count(*) from public.t_logins where f_token="+dbase.comilla(token) + " and f_activo = true";
       try
       {
       ResultSet rs= dbase.execSelect(sql); 
       while (rs.next())
       {
           return true;
       }
       }catch(SQLException e) {}
       return false;
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

