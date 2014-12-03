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
import dto.detalleVentaFactura;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
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
@Path("detalle_venta_factura")
public class WebService_Detalle_venta_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Detalle_venta_factura
     */
    public WebService_Detalle_venta_factura() {
    }
    
    
    /*metodo que inserta en detalle_venta_facura*/
    @POST
    @Path("/insertar_detalle_centa_factura/{token}/{informacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_detalle_venta_factura(@PathParam("token") String token,@PathParam("informacion") String informacion) throws Exception{
         Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==true){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            respo.ToJson(respo);
        }
        
        detalleVentaFactura detallevfactura = new detalleVentaFactura();
        
        detallevfactura.insertar_detalle_venta_factura(informacion);
        respo.setId(1);
        respo.setMensaje("Hecho");
        respo.ToJson(respo);

    } 
    /*fin del metodo que inserta en detalle_venta_facura made by:José Aníbal Moronta Mejía*/
    

    /**
     * Retrieves representation of an instance of Ws.WebService_Detalle_venta_factura
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    /*inicio del metodo que busca detalleventaFactua por el id*/
    @GET
    @Path("/getdetalleventafactura_id/{token}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getdetalleventafactura_id(@PathParam("token") String token,@PathParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        ArrayList<detalleVentaFactura> lista = new ArrayList<detalleVentaFactura>();
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
        String sql="SELECT f_id,f_id_t_venta_factura,f_tipo_factura_t_venta_factura,f_id_t_productos,f_precio,";
        sql+="f_cantidad,f_costo,f_itbis FROM public.t_detalle_venta_factura  where f_id = "+id;
  
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            while (rs.next())
             {
                detalleVentaFactura dvf = new detalleVentaFactura();
                    
                dvf.setF_id(rs.getInt(1));
                dvf.setId_t_venta_factura(rs.getInt(2));
                dvf.setF_tipo_Factura_t_venta_factura(rs.getString(3));
                dvf.setF_id_t_Productos(rs.getInt(4));
                dvf.setF_precio(rs.getInt(5));
                dvf.setF_cantidad(rs.getInt(6));
                dvf.setF_costo(rs.getInt(7));
                dvf.setF_itbis(rs.getInt(8));

                //asigno elrs a la lista
                lista.add(dvf);
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
    
     /*fin  del metodo que busca detalleventaFactua por el id made by :José Aníbal Moronta*/
   

    /**
     * PUT method for updating or creating an instance of WebService_Detalle_venta_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
