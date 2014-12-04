/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import dto.detalleAlquilerFactura;
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
@Path("detalle_alquiler_factura")
public class WebService_Detalle_alquiler_factura {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService_Detalle_alquiler_factura
     */
    public WebService_Detalle_alquiler_factura() {
    }

    /**
     * Retrieves representation of an instance of Ws.WebService_Detalle_alquiler_factura
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @POST
    @Path("/insertar_detalle_alquiler_factura/informacion")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertar_detalle_alquiler_factura(@PathParam("informacion")String json) throws Exception{
    
        detalleAlquilerFactura dafactura = new detalleAlquilerFactura();
        dafactura.insertar_detalle_alquiler_factura(json);
        
    
    
    }
    
    

    /**
     * PUT method for updating or creating an instance of WebService_Detalle_alquiler_factura
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
