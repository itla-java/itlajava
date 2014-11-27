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
public class facturaRecibo {
    private int idVentaFactura;
    private String tipoFacturaVentaFactura;
    private int monto;
    private String fecha;
    private int idReciboVentaFactura;

    public int getIdVentaFactura() {
        return idVentaFactura;
    }

    public void setIdVentaFactura(int idVentaFactura) {
        this.idVentaFactura = idVentaFactura;
    }

    public String getTipoFacturaVentaFactura() {
        return tipoFacturaVentaFactura;
    }

    public void setTipoFacturaVentaFactura(String tipoFacturaVentaFactura) {
        this.tipoFacturaVentaFactura = tipoFacturaVentaFactura;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdReciboVentaFactura() {
        return idReciboVentaFactura;
    }

    public void setIdReciboVentaFactura(int idReciboVentaFactura) {
        this.idReciboVentaFactura = idReciboVentaFactura;
    }
    
    public void insertar_factura_recibo(String informacion) throws Exception{
        
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql = "INSERT INTO public.t_factura_recibo(f_tipo_factura_t_venta_factura,f_monto,f_fecha,f_id_t_recibo_venta_factura)";
        sql+="VALUES (?,?,?,?,?,?,?,?)";
        
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        
        p.setString(1, tipoFacturaVentaFactura);
        p.setInt(2, monto);
        p.setString(3, fecha);
        p.setInt(4, idReciboVentaFactura);
        p.execute();
    
    }
    
    
}
