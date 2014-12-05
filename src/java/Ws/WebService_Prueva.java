/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import db.DB;
import dto.cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author enriq_000
 */



@Path("prueva")
public class WebService_Prueva {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Prueva
     */
    public WebService_Prueva() {
    }
    
    
    
    @POST
    @Path("/prueba")
    @Produces("text/plain")
    public Response prueba(
            @FormParam("p1") String p1,
            @FormParam("p2") String p2){
       
        
        return Response.status(200) 
                .entity("el resultado es "+p1+ " - " +p2)
                .build();
    }
    
    /**
     * Retrieves representation of an instance of Ws.WebService_Prueva
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WebService_Prueva
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
    
    @GET
    @Produces("text/plain")
    @Path("/holamundo")
    public String holamundo()
    {
        return "Hola Mundo";
    }
    
    
     @GET
    @Produces("text/plain")
    @Path("/mensage/{mensage}")
    public String mensage(@PathParam("mensage") String mensage)
    {
        return mensage;
    }
    
    @GET
    @Produces("text/plain")
    @Path("/cliente")
    public String Primer_Cliente() throws Exception
    {
        try{
        DB dbase = new DB("itla2","itlajava","12345678@itla");//conexion a la bdd en openshift
        String sql="Select * from t_cliente where f_id=1;";
        
       
            ResultSet rs=dbase.execSelect(sql);
            rs.next();
            cliente cliente1= new cliente();
            
            cliente1.setF_apellido(rs.getString(2));
            cliente1.setF_apellido(rs.getString(3));
            return ""+cliente1.getF_nombre()+","+cliente1.getF_apellido()+";";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return "-1,error en la Bdd";
    }
    
    
}
