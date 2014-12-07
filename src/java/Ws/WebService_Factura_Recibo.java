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
import dto.detalleVentaFactura;
import dto.facturaRecibo;
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
@Path("facturarecibo")
public class WebService_Factura_Recibo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Factura_Recibo
     */
    public WebService_Factura_Recibo() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Factura_Recibo
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    /*metodo que inserta en factura_recibo*/
    @POST
    @Path("/insertar_factura_recibo")
    @Produces("application/json")
    public String insertar_factura_recibo(
            @FormParam("token")String token,
            @FormParam("informacion")String informacion) throws Exception{
        
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==0){
            respo.setId(2);
            respo.setMensaje("El token no fue desactivado");
            return respo.ToJson(respo);
        }
    
        facturaRecibo frecibo = new facturaRecibo();
        frecibo.insertar_factura_recibo(informacion);
        
        respo.setId(1);
        respo.setMensaje("Hecho");
        return respo.ToJson(respo);
        
    }
    /*fin del metodo que inserta en factura_recibo mde by:José Aníbal Moronta mejía*/

    
     /*inicio del metodo que busca factura recibo por el id*/
    @GET
    @Path("/getfacturarecibo_id/{token}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getfacturarecibo_id(
            @PathParam("token") String token,
            @PathParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        
        CheckToken check = new CheckToken();
        
        String sql;
        //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
       if (check.checktocken2(token)==0) 
       { 
            respon.setId(2);
            respon.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
            return respon.ToJson(respon);
                     
       }            
                 
       //realizo el sql de busqueda
        sql="SELECT f_id_t_venta_factura,f_tipo_factura_t_venta_factura,f_monto,f_fecha,f_id_t_recibo_venta_factura ";
        sql+="FROM public.t_factura_recibo where f_id_t_venta_factura ="+id ;
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
                
                    
                facturaRecibo fr = new facturaRecibo();
                    
                fr.setF_id_t_venta_factura(rs.getInt(1));
                fr.setF_tipo_factura_t_venta_factura(rs.getString(2));
                fr.setF_monto(rs.getInt(3));
                fr.setF_fecha(rs.getString(4));
                fr.setF_id_t_Recibo_venta_factura(rs.getInt(5));
                

                //asigno elrs a la lista
                respon.setId(1);
                respon.setMensaje(respon.ToJson(fr));
                 
            }
        } 
        catch (Exception e) 
        {
            //si falla un error de base de datos
            respon.setId(-1);
            respon.setMensaje("Error de la base de datos "+e.getMessage());
            return respon.ToJson(respon);
                      
        }
        
        dbase.CerrarConexion();
       
        return respon.ToJson(respon);  //retorno el json

    }
    
     /*fin  del metodo que busca facturarecibo por el id made by :José Aníbal Moronta */
   
    
    
    /**
     * PUT method for updating or creating an instance of WebService_Factura_Recibo
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
