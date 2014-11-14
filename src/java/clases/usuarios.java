/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import db.DB;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivan Reyes
 */

public class usuarios 
{
    //Instancia a un objeto de la clase mensajes mediante la variable alerta
     Mensajes alerta = new Mensajes();
    
    //Instancia a un objeto de la clase db mediante la variable dbase
    DB dbase = new DB("localhost", "loteria_db", "postgres","3815");
    
    // Metodo para loguearse a la base de datos
    public String login(String usuario, String clave, String token)
    {
        try
        {
      // variable sql para hacer la consulta a la base de datos  
      String sql;
      sql="SELECT f_nombre, f_clave from t_usuarios "
      + "where f_nombre= '"+usuario+"' AND f_clave='"+clave+"' ";
     
      //asignamos un al objeto dbase al objeto ResultSet y ejecutamos la consulta
      ResultSet rs = dbase.execSelect(sql);
      
      
      //verificamos que los parametros que nos hayan enviado no esten vacios
       if(usuario.equals("") || clave.equals(""))
        {
         alerta.mensajeError(null,"Todos los campos son obligatorios");
         return null;
        }
       
      if(rs.next())
     {
     alerta.mensajeError(null, "Usuario o contraseña incorrectos");
      return null;
     }   
       
        }
        catch (SQLException e)
        {
         e.printStackTrace();
        }
               
        String mensajeprueba;
        
        mensajeprueba = "Esto es una prueba para loguearse";
       return mensajeprueba;
       
       /*
       if(token.equals(""))
       {
       alerta.mensajeError(null, "Lo sentimos su cesión a expirado, favor de volver a loguearse");
       return;
       }
         */  
       
    
      
    
    }
 
    


}
