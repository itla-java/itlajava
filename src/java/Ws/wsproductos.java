/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;


import clases.productos;
import db.DB;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import  java.sql.ResultSet;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * REST Web Service
 *
 * @author Estudiante
 */
@Path("producto")
public class wsproductos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsproductos
     */
    public wsproductos() {
    }
    
    //variables de la base de datos 
        String Host = "localhost";
        String Database ="itla";
        String User = "localhost";
        String Pass = "localhost";
        String sql;
        Gson json = new Gson();
        productos producto = new productos();
        ArrayList<productos> lista = new ArrayList<productos>();
    /**
     * Retrieves representation of an instance of Ws.wsproductos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/getproducto")
    @Produces("application/json")
    public String getproducto(){
        //Asigne los parametros de onccion a la base de datos
        
        
        
        //instancie el objeto de DB
       DB dbase = new DB(Host,Database,User,Pass);
       
       //realizo el sql
       sql="select * from public.t_productos";
       
         try{
      
       ResultSet rs = dbase.execSelect(sql);   
       while (rs.next()){
           productos producto = new productos();
           
           producto.setId(rs.getInt(1));
           producto.setDescripcion(rs.getString(2));
           producto.setCosto(rs.getInt(3));
           producto.setPrecioVenta(rs.getInt(3));
           producto.setPrecioAlquiler(rs.getInt(4));
           producto.setAlquilerVenta(rs.getString(5));
           producto.setCantidadALquiler(rs.getString(6));
           producto.setCantidadVenta(rs.getString(7));
           producto.setDiasRecuperacion(rs.getString(8));
           
           //asigno elrs a la lista
           lista.add(producto);
       
       }
    } catch (Exception e) {
        //si falla un error de base de datos
            return "-1: Error de la base de datos ";
        }
        
        //convierto la lista a Gson
        String json1=json.toJson(lista);
        
        //retorno el json
        return json1;
    }

    @GET
    @Path("/getproducto")
    @Produces("application/json")
    public String getproduct_id_nombre(@PathParam("id") String id,@PathParam("token") String token){
      //instancie el objeto de DB
       DB dbase = new DB(Host,Database,User,Pass);
       String tokenlook;
       tokenlook="select f_activo from public.t_logins";
       ResultSet rs1 = dbase.execSelect(tokenlook); 
      
       try {
            while (rs1.next()) {  
            if ((rs1.getBoolean("f_activo")==false)){
                
                return "Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias ";             
            } else 
    {
                
            //realizo el sql de busqueda
            sql="select * from public.t_productos where f_id ="+id+" or f_nombre ilike "+"'"+"'"+id+"'"+"'";
       
         try
        {
      
            ResultSet rs = dbase.execSelect(sql);   
            while (rs.next())
             {
                productos producto = new productos();

                producto.setId(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setCosto(rs.getInt(3));
                producto.setPrecioVenta(rs.getInt(3));
                producto.setPrecioAlquiler(rs.getInt(4));
                producto.setAlquilerVenta(rs.getString(5));
                producto.setCantidadALquiler(rs.getString(6));
                producto.setCantidadVenta(rs.getString(7));
                producto.setDiasRecuperacion(rs.getString(8));

                //asigno elrs a la lista
                lista.add(producto);

            }
        } catch (Exception e) {
        //si falla un error de base de datos
            return "-1: Error de la base de datos ";
        }
        
        //convierto la lista a Gson
        String json1=json.toJson(lista);
        
        //retorno el json
        return json1;
            
    }//llave del esle
        }//llave del while
            
       }catch(SQLException e){}
        return null;
 
    }
    

    
    /**
     * PUT method for updating or creating an instance of wsproductos
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}

