/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import clases.CheckToken;
import dto.Respuesta;
import dto.alquilerFactura;
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
@Path("alquiler_factura")
public class WebService_Alquiler_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Alquiler_factura
     */
    public WebService_Alquiler_factura() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Alquiler_factura
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    /*Metodo que inserta en alquiler_factura*/
    @POST
    @Path("/insertar_alquiler_factura/{token}/{informacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_alquiler_factura(@PathParam("token") String token, @PathParam("informacion") String informacion) throws Exception{
        
        Respuesta respo  = new Respuesta();
        CheckToken ctoken = new CheckToken();
        if (ctoken.checktocken2(token)==true){
            respo.setId(3);
            respo.setMensaje("El token no esta activo");
            respo.ToJson(respo);

        }
        
        alquilerFactura afactura = new alquilerFactura();
        afactura.insertar_alquiler_factura(informacion);
        respo.setId(1);
        respo.setMensaje("Hecho");
        respo.ToJson(respo);
                
    
    }
    /*fin Metodo que inserta en alquiler_factura made by:José Aníbal Moronta Mejía*/
    /**
     * PUT method for updating or creating an instance of WebService_Alquiler_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
