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
    @Path("/getstatus//{token}{user}/{pass}")
    public String getStatus(@PathParam ("token") String token,@PathParam ("user") String user ,@PathParam ("pass") String pass) throws Exception{
        
        
          Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==true){
            respo.setId(-3);
            respo.setMensaje("El token no esta activo");
            return respo.ToJson(respo);
        }
        
        try{
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        
        String sql="Select fun_login('"+user+"','"+pass+"')";
        ResultSet rs = dbase.execSelect(sql);  
        
            if (!rs.next()){  
                respo.setId(-2);
                respo.setMensaje("Usuario no existe");
                return respo.ToJson(respo);
            }
           
        } catch (Exception e) 
        {
         return e.getMessage();    
        
        }
        
                respo.setId(1);
                respo.setMensaje("Usuario existe");
                return respo.ToJson(respo);
                
   
}
}
