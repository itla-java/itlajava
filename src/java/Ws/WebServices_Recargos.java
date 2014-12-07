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
    @Path("/getrecargo_id/{token}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getrecargos_id(
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
        sql="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_descripcion,f_monto,  ";
        sql+="f_hecho_por,f_pagado FROM public.t_recargos where f_id ="+id ;
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            if(!rs.next())
            {
           
                respon.setId(0);
                respon.setMensaje("No hay registros actualmente en la base de datos");
                return respon.ToJson(respon);
                 
            }
            while (rs.next())
            {
     
                recargos r = new recargos();
                    
                r.setF_id(rs.getInt(1));
                r.setF_id_t_alquiler_factura(rs.getInt(2));
                r.setF_tipo_factura_t_alquiler_factura(rs.getString(3));
                r.setF_descripcion(rs.getString(4));
                r.setF_monto(rs.getInt(5));
                r.setF_hecho_por(rs.getString(6));
                r.setF_pagado(rs.getBoolean(7));

                //asigno elrs a la lista
                respon.setId(1);
                respon.setMensaje(respon.ToJson(r));
                  
            }
        }
        catch (SQLException e) 
        {
            //si falla un error de base de datos
             respon.setId(-1);
             respon.setMensaje("Error de la base de datos "+e.getMessage());
             return respon.ToJson(respon);
                  
        }
        dbase.CerrarConexion();
        return respon.ToJson(respon);//retorno el json

    }
    
     /*fin  del metodo que busca recargos por el id made by :José Aníbal Moronta*/
   
    
    
    @POST  // metodo para el Setvlet*****************************************************
    @Path("/getrecargo_id")
    @Produces(MediaType.APPLICATION_JSON)
    public String getrecargos_id(
            @FormParam("id")int id) throws Exception{
        
        Respuesta respon = new Respuesta();
        
        
        
        String sql;
        //instancie el objeto de DB
       DB dbase = new DB("itla2","itlajava","12345678@itla");
          
                  
                 
       //realizo el sql de busqueda
        sql="SELECT f_id,f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_descripcion,f_monto,  ";
        sql+="f_hecho_por,f_pagado FROM public.t_recargos where f_id ="+id ;
        try
        {
            ResultSet rs = dbase.execSelect(sql);   
            if(!rs.next())
            {
                     
                
                     
                respon.setId(0);
                respon.setMensaje("No hay registros actualmente en la base de datos");
                return respon.ToJson(respon);
                 
            }
            else
            while (rs.next())
             {
                 
                  
                 
                recargos r = new recargos();
                    
                r.setF_id(rs.getInt(1));
                r.setF_id_t_alquiler_factura(rs.getInt(2));
                r.setF_tipo_factura_t_alquiler_factura(rs.getString(3));
                r.setF_descripcion(rs.getString(4));
                r.setF_monto(rs.getInt(5));
                r.setF_hecho_por(rs.getString(6));
                r.setF_pagado(rs.getBoolean(7));

                //asigno elrs a la lista
                respon.setId(1);
                respon.setMensaje(respon.ToJson(r));
                  
            }
        }
        catch (SQLException e) 
        {
            //si falla un error de base de datos
            respon.setId(-1);
            respon.setMensaje("Error de la base de datos "+e.getMessage());
            return respon.ToJson(respon);
                  
        }
        dbase.CerrarConexion(); 
        return respon.ToJson(respon);       //retorno el json  
        
           

    }
    
    
    @POST
    @Path("/insertar_recargo")
    @Produces("application/json")
    public String insertar_recargo(
            @FormParam("token")String token,
            @FormParam("informacion") String informacion) throws Exception{
            
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==0){
            respo.setId(2);
            respo.setMensaje("El token fue desactivado,Comuniquese con el Administrador");
            return respo.ToJson(respo);
        }
    
        recargos recargos = new recargos();
        recargos.insertar_recargos(informacion); // llamado el metodo con Prepared Statement
        
        respo.setId(1);
        respo.setMensaje("Hecho");
        return respo.ToJson(respo);
    
    }
    
    
    
    
    

    
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
   
    
    }

    
