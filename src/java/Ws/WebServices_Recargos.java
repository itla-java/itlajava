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
import dto.facturaRecibo;
import dto.recargos;
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
@Path("recargos")
public class WebServices_Recargos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices_Recargos
     */
    public WebServices_Recargos() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebServices_Recargos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    
     /*inicio del metodo que busca recargos por el id*/
    @GET
    @Path("/getrecargoso_id/{token}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getrecargos_id(@PathParam("token") String token,@PathParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        ArrayList<recargos> lista = new ArrayList<recargos>();
        CheckToken check = new CheckToken();
        Gson json = new Gson();
        String sql;
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
        sql="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_descripcion,f_monto,  ";
        sql+="f_hecho_por,f_pagado FROM public.t_recargos where f_id ="+id ;
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
                recargos r = new recargos();
                    
                r.setF_id(rs.getInt(1));
                r.setF_id_t_alquiler_factura(rs.getInt(2));
                r.setF_tipo_factura_t_alquiler_factura(rs.getString(3));
                r.setF_descripcion(rs.getString(4));
                r.setF_monto(rs.getInt(5));
                r.setF_hecho_por(rs.getString(6));
                r.setF_pagado(rs.getBoolean(7));

                //asigno elrs a la lista
                lista.add(r);
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
    
     /*fin  del metodo que busca recargos por el id made by :José Aníbal Moronta*/
   
    @POST
    @Path("/insertar_recargo/{informacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_recargo(@PathParam("token")String token,@PathParam("informacion") String informacion) throws Exception{
            
          Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==true){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            respo.ToJson(respo);
        }
    
        recargos recargos = new recargos();
            
        recargos.insertar_recargos(informacion);
    
    
    }

    /**
     * PUT method for updating or creating an instance of WebServices_Recargos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
