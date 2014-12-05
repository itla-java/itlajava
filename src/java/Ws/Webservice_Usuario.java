 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws;

import dto.Respuesta;
import dto.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import clases.CheckToken;
import com.google.gson.Gson;
import db.DB;
import dto.Respuesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Estudiante
 */
@Path("/usuario")
public class Webservice_Usuario {

    @Context
    private UriInfo context;
    CheckToken checktocken = new CheckToken();
    DB dbase = new DB("itla2","itlajava","12345678@itla");

    /**
     * Creates a new instance of Webservice_Usuario
     */
    public Webservice_Usuario() throws Exception {
    
    }

    /**
     * Retrieves representation of an instance of Ws.Webservice_Usuario
     * @return an instance of java.lang.String
     */
    
    @PUT
    @Path("/modificar_pass")
    @Consumes("application/json")
    //metodo para cambiar contra de un usuario
    public String Mod_pass_usu(
            @FormParam("token")String token,
            @FormParam("pass")String pass,
            @FormParam("id") int id) throws Exception
    {
        String Gson;
        Gson gso= new Gson(); 
        Respuesta resp = new Respuesta();
       
        if (!checktocken(dbase,token)) 
        { resp.setId(-1);
          resp.setMensaje("Lo Sentimos Usuario Desactivado, Comuniquese Con el Administrador, Gracias");
          Gson=gso.toJson(resp);
          return Gson;              
        }  
        
        Usuario user = new Usuario();
        user.mod_pass(pass ,id);
        
        resp.setId(1);
        resp.setMensaje("Hecho");
        Gson=gso.toJson(resp);
        return Gson;
    }
    
    
    
    @GET
    @Path("/getusuario/{token}/{id}")
    @Produces("application/json")
    public String getUsuario(@PathParam("token") String token,@PathParam("id") int id) throws Exception
    {
        Respuesta respon = new Respuesta();
        CheckToken check = new CheckToken();
        String sql;
        DB dbase = new DB("itla2","itlajava","12345678@itla");//instancia del objeto  DB
        if(!check.checktocken2(token)==true)
        {
            respon.setId(2);
            respon.setMensaje("El token ha sido desactivado");
            return respon.ToJson(respon);
        }
        
        sql="select * from t_usuario where f_id="+id+" ";
        ResultSet rs = dbase.execSelect(sql);
        
        try
        {
            if(!rs.next()==true)
            {
                respon.setId(0);
                respon.setMensaje("no hay Usuarios registrados actualmente");
                return respon.ToJson(respon);
            }
            while(rs.next()==true)
            {
                Usuario usu = new Usuario();
                
                usu.setF_id(rs.getInt(1));
                usu.setF_nombre(rs.getString(2));
                usu.setF_apellido(rs.getString(3));
                usu.setF_usuario(rs.getString(4));
                usu.setF_clave(rs.getString(5));
                usu.setF_proceso(rs.getBoolean(6));
                usu.setF_activo(rs.getBoolean(7));
                
                respon.setId(1);
                respon.setMensaje(respon.ToJson(usu));
                
            }
        
        }
        catch(SQLException e)
        {
            respon.setId(-1);
            respon.setMensaje("error de la base de datos "+e.getMessage()+" ");
            return respon.ToJson(respon); 
        }
        
         return respon.ToJson(respon);//returna el cliente que se iso en el while.
            //fin del metodo cliente que busca por id Maded By Juan L Hiciano
        
        
        
    }
    
    
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    

    /**
     * PUT method for updating or creating an instance of Webservice_Usuario
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    
    

    private boolean checktocken(DB dbase, String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
