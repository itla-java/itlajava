/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import com.google.gson.Gson;
import db.DB;
import dto.Producto;
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
    @Path("/getproductos")
    @Produces("application/json")
    public String getfactura_id(@PathParam("id") int id) throws Exception{
        //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
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
    /*fin del metodo que busca la factura por el id made by:José Aníbal Moronta Mejía*/
    
    
    /*metodo que inserta factura en reciboVnetaFactura*/
    @POST
    @Path("/insertar_venta_factura")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_venta_factura(String informacion) throws Exception{
        
        reciboVentaFactura recibo = new reciboVentaFactura();
        
        recibo.insertar_recibo_venta_fact(informacion);
        
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
