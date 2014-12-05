/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import dto.Respuesta;
import com.google.gson.Gson;
import db.DB;
import dto.Producto;
import dto.Respuesta;
import dto.reciboVentaFactura;
import dto.ventaFactura;
import java.sql.ResultSet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author COMPAQ
 */
@Path("venta_factura")
public class Webservice_Venta_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Webservice_Venta_factura
     */
    public Webservice_Venta_factura() {
    }
    
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    /*Metodo que busca la factura por el id*/
    @GET
    @Path("/getfactura_id/{token}/{id}")
    @Produces("application/json")
    public String getfactura_id(@PathParam("token") String token,@PathParam("id") int id) throws Exception{
        

        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
       
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        
        if (ctoken.checktocken2(token)==true){
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        //instancie el objeto de DB
       
       
       //realizo el sql
       String sql="select * from public.t_venta_factura where f_id ="+id;
       
       try
       {
      
            ResultSet rs = dbase.execSelect(sql);   
            if(!rs.next())
            {
             
                respo.setId(0);
                respo.setMensaje("No hay registros actualmente en la base de datos");
                return respo.ToJson(respo);
                 
            }
            while (rs.next())
            {
           
                
                
                ventaFactura ventaf = new ventaFactura();
           
                ventaf.setF_id(rs.getInt(1));
                ventaf.setF_tipo_factura(rs.getString(2));
                ventaf.setF_id_t_cliente(rs.getInt(3));
                ventaf.setF_id_orden(rs.getInt(3));
                ventaf.setF_fecha(rs.getString(4));
                ventaf.setF_hecha_por(rs.getString(5));
                ventaf.setF_id_t_usuario(rs.getInt(6));
       
           
                respo.setId(1);
                respo.setMensaje(respo.ToJson(ventaf));
            }
       
       }
        catch (Exception e)
        {
            //si falla un error de base de datos
            respo.setId(-1);
            respo.setMensaje("Error de la base de datos :"+e.getMessage());
            return respo.ToJson(respo);
        }
        
        //convierto la lista a Gson
        
        
        //cierro la conexion
        dbase.CerrarConexion();
        //retorno el json
        return respo.ToJson(respo);
        
    }
    /*fin del metodo que busca la factura por el id made by:José Aníbal Moronta Mejía*/
    
    
    @GET
    @Path("/getfactura_id/{id}")
    @Produces("application/json")
    public String getfactura_id(@PathParam("id") int id) throws Exception{
        

        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        
        Respuesta respo  = new Respuesta();
       
        
        
        
        //instancie el objeto de DB
       
       
       //realizo el sql
       String sql="select * from public.t_venta_factura where f_id ="+id;
       
       try
       {
      
            ResultSet rs = dbase.execSelect(sql);   
            if(!rs.next())
            {
             
                respo.setId(0);
                respo.setMensaje("No hay registros actualmente en la base de datos");
                return respo.ToJson(respo);
                 
            }
            while (rs.next())
            {
           
                
                
                ventaFactura ventaf = new ventaFactura();
           
                ventaf.setF_id(rs.getInt(1));
                ventaf.setF_tipo_factura(rs.getString(2));
                ventaf.setF_id_t_cliente(rs.getInt(3));
                ventaf.setF_id_orden(rs.getInt(3));
                ventaf.setF_fecha(rs.getString(4));
                ventaf.setF_hecha_por(rs.getString(5));
                ventaf.setF_id_t_usuario(rs.getInt(6));
                
                respo.setId(1);
                respo.setMensaje(respo.ToJson(ventaf));

            }
       
       }
        catch (Exception e)
        {
            //si falla un error de base de datos
            respo.setId(-1);
            respo.setMensaje("Error de la base de datos :"+e.getMessage());
            return respo.ToJson(respo);
        }
        
        //convierto la lista a Gson
        
        
        //cierro la conexion
        dbase.CerrarConexion();
        //retorno el json
        return respo.ToJson(respo);
        
    }
    /*metodo que busca la factur apor le id made by:José Aníbal moronta*/
    
    
    
    
    /*metodo que inserta factura en reciboVnetaFactura*/
    @POST
    @Path("/insertar_venta_factura")
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertar_venta_factura(
            @FormParam("token")String token,
            @FormParam("informacion")String informacion) throws Exception
    {
        
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==false){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        reciboVentaFactura recibo = new reciboVentaFactura();
        recibo.insertar_recibo_venta_fact(informacion);
        
        respo.setId(1);
        respo.setMensaje("Hecho");
        return respo.ToJson(respo);
    }
    /*fin del metodo que inserta factura en reciboVnetaFactura mede by:José Aníbal Moronta Mejía*/
    
    /**
     * Retrieves representation of an instance of Ws.Webservice_Venta_factura
     * @return an instance of java.lang.String
     */
    /**
     * PUT method for updating or creating an instance of Webservice_Venta_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
