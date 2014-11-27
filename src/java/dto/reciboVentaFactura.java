/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import db.DB;
import java.sql.PreparedStatement;

/**
 *
 * @author HiraldoTran
 */
public class reciboVentaFactura {
    private int id;
    private int idCliente;
    private String concepto;
    private String Fecha;
    private int monto;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
       public int getMonto() {
        return monto;
    }

     public void setMonto(int Monto) {
        this.monto = Monto;
     }
    
    public void insertar_recibo_venta_fact(String informacion) throws Exception{
    
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        String sql="INSERT INTO public.t_recibo_venta_factura(f_id_t_cliente,f_concepto,f_fecha,f_monto)";
        sql+="VALUES (?,?,?,?,?,?,?,?)";
      
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        
        p.setInt(1, idCliente);
        p.setString(2, concepto);
        p.setString(3, Fecha);
        p.setInt(4, monto);
        p.execute();
        
    
    }
    
    
}
