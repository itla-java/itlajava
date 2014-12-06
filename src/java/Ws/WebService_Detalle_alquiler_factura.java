/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import com.google.gson.Gson;
import db.DB;
import dto.Respuesta;
import dto.alquilerFactura;
import dto.detalleAlquilerFactura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author COMPAQ
 */
@Path("detalle_alquiler_factura")
public class WebService_Detalle_alquiler_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Detalle_alquiler_factura
     */
    public WebService_Detalle_alquiler_factura() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Detalle_alquiler_factura
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @POST
    @Path("/insertar_detalle_alquiler_factura")
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertar_detalle_alquiler_factura(
            @FormParam("token")String token,
            @FormParam("informacion")String json) throws Exception{
        
        
        Respuesta respo  = new Respuesta();
        
        CheckToken ctoken = new CheckToken();
        if (!ctoken.checktocken2(token)){
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        detalleAlquilerFactura dafactura = new detalleAlquilerFactura();
        dafactura.insertar_detalle_alquiler_factura(json);
        respo.setId(1);
        respo.setMensaje("hecho");
        return respo.ToJson(respo);
    }
    
    /*inicio del metodo que busca detalle alquilerFactua por el id*/
    @GET
    @Path("/getdetallealquilerfactura_id/{token}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getdetallealquilerfactura_id(
            @PathParam("token") String token,
            @PathParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        
        CheckToken check = new CheckToken();
        
      
        //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (!check.checktocken2(token)) 
       { 
         respon.setId(2);
         respon.setMensaje("Lo Sentimos token Desactivado, Comuniquese Con el Administrador, Gracias");
         return respon.ToJson(respon);
                     
       }            
                 
       //realizo el sql de busqueda
        String sql ="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_productos,";
        sql+="f_fecha_salida,f_fecha_entrada,f_fecha_real_entrada,f_cantidad,f_precio,f_costo,f_itbis ";
        sql+=" FROM public.t_detalle_alquiler_factura  where f_id = "+id;
  
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
                  
                 
                detalleAlquilerFactura daf = new detalleAlquilerFactura();
                    
                daf.setF_id(rs.getInt(1));
                daf.setF_id_t_alquiler_factura(rs.getInt(2));
                daf.setF_tipo_Factura_t_alquiler_factura(rs.getString(3));
                daf.setF_id_t_Producto(rs.getInt(4));
                daf.setF_fecha_salida(rs.getString(5));
                daf.setF_fecha_entrada(rs.getString(6));
                daf.setF_fecha_entrada_real(rs.getString(6));
                daf.setF_cantidad(rs.getInt(7));
                daf.setF_precio(rs.getInt(7));
                daf.setF_costo(rs.getInt(7));
                daf.setF_itbis(rs.getInt(8));
 
                //asigno elrs a la lista
                
                respon.setId(1);
                respon.setMensaje(respon.ToJson(daf));
                
                
            }
        } 
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);
                       
        }
      
        return respon.ToJson(respon);    //retornando el Gson 

    }
    
     /*  /*inicio del metodo que busca detallealquilerFactua por el id made by :José Aníbal Moronta*/
   
    
    @POST  // metodo para el servlet
    @Path("/getdetallealquilerfactura_id")
    @Produces(MediaType.APPLICATION_JSON)
    public String getdetallealquilerfactura_id(
            @FormParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
      
        
       DB dbase = new DB("itla2","itlajava","12345678@itla");//instancie el objeto de DB
          
               
                 
       //realizo el sql de busqueda
        String sql ="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_productos,";
        sql+="f_fecha_salida,f_fecha_entrada,f_fecha_real_entrada,f_cantidad,f_precio,f_costo,f_itbis ";
        sql+=" FROM public.t_detalle_alquiler_factura  where f_id = "+id;
  
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
                  
                
                detalleAlquilerFactura daf = new detalleAlquilerFactura();
                    
                daf.setF_id(rs.getInt(1));
                daf.setF_id_t_alquiler_factura(rs.getInt(2));
                daf.setF_tipo_Factura_t_alquiler_factura(rs.getString(3));
                daf.setF_id_t_Producto(rs.getInt(4));
                daf.setF_fecha_salida(rs.getString(5));
                daf.setF_fecha_entrada(rs.getString(6));
                daf.setF_fecha_entrada_real(rs.getString(7));
                daf.setF_cantidad(rs.getInt(8));
                daf.setF_precio(rs.getInt(9));
                daf.setF_costo(rs.getInt(10));
                daf.setF_itbis(rs.getInt(11));
 
                respon.setId(1);
                respon.setMensaje(respon.ToJson(daf));
                  
            }
        } 
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);
                     
        }
    
        return respon.ToJson(respon);   //retorno el json  

    }

    
    
    
    
    /**
     * PUT method for updating or creating an instance of WebService_Detalle_alquiler_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    
    
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
