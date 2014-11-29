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
    
}
