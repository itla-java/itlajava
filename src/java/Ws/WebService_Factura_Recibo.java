/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import dto.facturaRecibo;
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
@Path("facturarecibo")
public class WebService_Factura_Recibo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Factura_Recibo
     */
    public WebService_Factura_Recibo() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Factura_Recibo
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    /*metodo que inserta en factura_recibo*/
    @POST
    @Path("/insertar_factura_recibo/{informacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_factura_recibo(@PathParam("informacion")String informacion) throws Exception{
    
    
        facturaRecibo frecibo = new facturaRecibo();
        frecibo.insertar_factura_recibo(informacion);
        
    }
    /*fin del metodo que inserta en factura_recibo mde by:José Aníbal Moronta mejía*/

    /**
     * PUT method for updating or creating an instance of WebService_Factura_Recibo
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
