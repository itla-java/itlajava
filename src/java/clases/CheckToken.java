/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author COMPAQ
 */
import db.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.Respuesta;

public class CheckToken {
    
    
    public  boolean checktocken(DB dbase,String token)
    {

       String sql="select count(*) from public.t_logins where f_token="+dbase.comilla(token) + " and f_activo = true";
       try
       {
       ResultSet rs= dbase.execSelect(sql); 
       while (rs.next())
       {
           return true;
       }
       }catch(SQLException e) {}
       return false;
    }
    public  int  checktocken2(String token) 
    {
       
       DB dbase = new DB("itla2","admini3lwux2","aLXsCK8L2Pmy");
       String sql="select count(f_activo) from t_logins where f_token='"+dbase.comilla(token) + "' and f_activo = true";
       try
       {
            ResultSet rs= dbase.execSelect(sql); 
            rs.next();// mover posicion de rs
            int num=rs.getInt(1);
          
            return num;
       }
       catch(SQLException e) {}
       
       return -2;
    }
    
}
