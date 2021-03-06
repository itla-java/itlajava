/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import db.DB;
import dto.Respuesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author enriq_000
 */
@Path("logins")
public class WebService_Logins {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Logins
     */
    public WebService_Logins() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Logins
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/hola")
    @Produces("text/plane")
    public String holaM(){
        return "<h1>hola mundo por fin segunda prueba</h1>";
    }
    /**
     * PUT method for updating or creating an instance of WebService_Logins
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @GET
    @Produces("application/json")
    @Path("/getstatus/{user}/{pass}")
    public String getStatus(
            @PathParam ("user") String user ,
            @PathParam ("pass") String pass) throws Exception
    {
     
        String token;
        Respuesta respo = new Respuesta();
        String sql="";
        try
        {
            DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
            sql="Select fun_login('"+user+"','"+pass+"')";
            ResultSet rs = dbase.execSelect(sql);  
        
            while(rs.next())
            {
                if (rs.getString(1).equals("-1"))
                {  

                    respo.setId(-1);
                    respo.setMensaje("Usuario no existe");
                    return respo.ToJson(respo);
                }
                
                else
                {
                    token=rs.getString(1);
                    respo.setId(1);
                    respo.setMensaje(token);
                    return respo.ToJson(respo);
                }
                
                
            }
            
             dbase.CerrarConexion();
      
        }
        catch (SQLException e) 
        {
                    respo.setId(-3);
                    respo.setMensaje(sql + " " +e.getMessage());
                    return respo.ToJson(respo);        
        }
        
        catch (Exception e) 
        {
                    respo.setId(-2);
                    respo.setMensaje(sql + " " +e.getMessage());
                    return respo.ToJson(respo);        
        }
        
        
               
         return "";
    }
    
}
