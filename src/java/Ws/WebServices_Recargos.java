/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import dto.Respuesta;
import dto.recargos;
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
