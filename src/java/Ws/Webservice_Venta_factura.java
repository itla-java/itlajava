/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import com.google.gson.Gson;
import db.DB;
import dto.productos;
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
import java.util.ArrayList;

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
    @GET
    @Path("/getproductos")
    @Produces("application/json")
    public String getfactura_id(@PathParam("id") int id){
        //instancie el objeto de DB
       DB dbase = new DB("localhost","itla","itlajava","12345678@itla");
       ventaFactura vf = new ventaFactura();
       ArrayList<ventaFactura> lista = new ArrayList<>();
       Gson json = new Gson();
       
       //realizo el sql
       String sql="select * from public.t_venta_factura where f_id ="+id;
       
       try{
      
       ResultSet rs = dbase.execSelect(sql);   
       while (rs.next()){
           ventaFactura ventaf = new ventaFactura();
           
           ventaf.setId(rs.getInt(1));
           ventaf.setDpo_factura(rs.getString(2));
           ventaf.setId_cliente(rs.getInt(3));
          ventaf.setId_orden(rs.getInt(3));
          ventaf.setFecha(rs.getString(4));
           ventaf.setHechaPor(rs.getString(5));
           ventaf.setId_usuario(rs.getInt(6));
       
           
           //asigno elrs a la lista
           lista.add(ventaf);
       
       }
    } catch (Exception e) {
        //si falla un error de base de datos
            return "-1: Error de la base de datos ";
        }
        
        //convierto la lista a Gson
        String json1=json.toJson(lista);
        
        //cierro la conexion
        dbase.CerrarConexion();
        //retorno el json
        return json1;
        
    }
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
