/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Estudiante
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Ws.WebService_Alquiler_factura.class);
        resources.add(Ws.WebService_Detalle_alquiler_factura.class);
        resources.add(Ws.WebService_Detalle_venta_factura.class);
        resources.add(Ws.WebService_Factura_Recibo.class);
        resources.add(Ws.WebService_Logins.class);
        resources.add(Ws.WebService_Prueva.class);
        resources.add(Ws.WebServices_Recargos.class);
        resources.add(Ws.Webservice_Cliente.class);
        resources.add(Ws.Webservice_Producto.class);
        resources.add(Ws.Webservice_Usuario.class);
        resources.add(Ws.Webservice_Venta_factura.class);
        resources.add(clases.WssResource.class);
    }
    
}
