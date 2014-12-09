/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import db.DB;
import dto.Respuesta;
import dto.reciboVentaFactura;
import dto.ventaFactura;
import java.sql.ResultSet;
import java.sql.SQLException;
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

/**
 * REST Web Service
 *
 * @author COMPAQ
 */
@Path("recibo_venta_factura")
public class WebService_Recibo_venta_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Recibo_venta_factura
     */
    public WebService_Recibo_venta_factura() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Recibo_venta_factura
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    /*webservice que busca recibo venta factura por le id*/
    @GET
    @Path("/getrecibo_venta_factura_id/{token}/{id}")
    @Produces("application/json")
    public String getrecibo_venta_factura_id(
            @PathParam("token") String token,
            @PathParam("id") int id) throws Exception{
        

        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
       
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        
        if (ctoken.checktocken2(token)==0){
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        
       
       
       //realizo el sql
       String sql="SELECT f_id,f_id_t_cliente,f_concepto,f_fecha,f_monto FROM public.t_recibo_venta_factura where f_id ="+id;
       
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
           
                
                
                reciboVentaFactura rcb = new reciboVentaFactura();
           
                rcb.setF_id(rs.getInt(1));
                rcb.setF_id_t_cliente(rs.getInt(2));
                rcb.setF_concepto(rs.getString(3));
                rcb.setF_fecha(rs.getString(4));
                rcb.setF_monto(rs.getInt(5));
             
                
                
       
           
                respo.setId(1);
                respo.setMensaje(respo.ToJson(rcb));
            }
       
        }
        catch (SQLException e)
        {
            //si falla un error de base de datos
            respo.setId(-1);
            respo.setMensaje("Error de la base de datos :"+e.getMessage());
            
            return respo.ToJson(respo);
        }
        
        //convierto la lista a Gson
        
        
        
        dbase.CerrarConexion();//cierro la conexion
        
        return respo.ToJson(respo);//retorno el json
        
    }
    /*fin del metodo que busca la factura por el id made by:José Aníbal Moronta Mejía*/
    
     @POST
    @Path("/insertar_recibo_venta_factura")
    @Produces("application/json")
    public String insertar_recibo_venta_factura(
            @FormParam("token")String token,
            @FormParam("Gson")String informacion) throws Exception
    {
        
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==0){
            respo.setId(2);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        reciboVentaFactura rcb = new reciboVentaFactura();
        String respuestasBD=rcb.insertar_recibo_venta_fact(informacion);
          if(respuestasBD.equals("1")){
        
        respo.setId(1);
        respo.setMensaje("Hecho");
        return  respo.ToJson(respo);
        }
        respo.setId(-1);
        respo.setMensaje(respuestasBD);
        return  respo.ToJson(respo);
        
    }
    /*fin del metodo que inserta factura en reciboVnetaFactura mede by:José Aníbal Moronta Mejía*/
    

    /**
     * PUT method for updating or creating an instance of WebService_Recibo_venta_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
