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
        if (ctoken.checktocken2(token)==false){
            respo.setId(3);
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
    public String getdetallealquilerfactura_id(@PathParam("token") String token,@PathParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        ArrayList<detalleAlquilerFactura> lista = new ArrayList<detalleAlquilerFactura>();
        CheckToken check = new CheckToken();
        Gson json = new Gson();
      
        //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (check.checktocken2(token)) 
       { 
         respon.setId(-1);
         respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
         String json1=json.toJson(respon);
         return json1;              
       }            
                 
       //realizo el sql de busqueda
        String sql ="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_productos,";
        sql+="f_fecha_salida,f_fecha_entrada,f_fecha_real_entrada,f_cantidad,f_precio,f_costo,f_itbis ";
        sql+=" FROM public.t_detalle_alquiler_factura  where f_id = "+id;
  
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
                lista.add(daf);
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
    
     /*  /*inicio del metodo que busca detallealquilerFactua por el id made by :José Aníbal Moronta*/
   
    
    

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
