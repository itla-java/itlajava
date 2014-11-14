/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;


import dto.productos;
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

/**
 * REST Web Service
 *
 * @author Estudiante
 */
@Path("producto")
public class Webservice_Producto {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsproductos
     */
    public Webservice_Producto() {
    }
    
    //variables de la base de datos 
        String sql;
        Gson json = new Gson();
        productos producto = new productos();
        ArrayList<productos> lista = new ArrayList<productos>();
    /**
     * Retrieves representation of an instance of Ws.Webservice_Producto
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/getproductos")
    @Produces("application/json")
    public String getproducto() throws Exception{
        //Asigne los parametros de onccion a la base de datos
        
        
        
        //instancie el objeto de DB
       DB dbase = new DB("localhost","itla","itlajava","12345678@itla");
       
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
    @Path("/getproducto/{id}/{token}")
    @Produces("application/json")
    public String getproduct_id_nombre(@PathParam("id") String id,@PathParam("token") String token) throws Exception{
      //instancie el objeto de DB
       DB dbase = new DB("localhost","itla","itlajava","12345678@itla");
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
    @PUT
    @Path("/insertarproducto/{id}/{nombre}/{descripcion}/{costo}//{precioventa}/{precioalquiler}/{alquilerventa}/{cantidadalquiler}/{cantidadventa}/{diasrecuperacion}")
    @Produces("application/json")
    public void insertar_producto(@PathParam("id")int id,@PathParam("nombre")String nombre,@PathParam("descripcion")String descripcion,@PathParam("costo")int costo,@PathParam("precioventa")int precioventa,@PathParam("precioalquiler")int precioalquiler,@PathParam("alquilerventa")int alquilerventa,@PathParam("cantidadalquier")int cantidadalquiler,@PathParam("cantidadalquier")int cantidadaventa,@PathParam("diasrecuperacion")int diasrecuperacion) throws Exception{
        
        DB dbase = new DB("127.7.234.129:5432","itla","itlajava","12345678@itla");
    
        String sql="INSERT INTO public.t_productos(f_id,f_nombre,f_descripcion,f_costo,f_precio_venta,";
        sql+="f_precio_alquiler,f_alquiler_venta,f_cantidad_alquiler,f_cantidad_venta,f_dias_recuperacion)";
        sql+= "VALUES ("+id+","+"'"+nombre+"'"+","+"'"+descripcion+"'"+","+costo+","+","+precioventa+","+","+precioalquiler+","+"'"+alquilerventa+"'"+","+"'"+cantidadalquiler+"'"+","+"'"+cantidadaventa+"'"+","+"'"+diasrecuperacion+"'"+")";
        
        dbase.executeQuery(sql);
        
    }

    
    /**
     * PUT method for updating or creating an instance of Webservice_Producto
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}

