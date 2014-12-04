/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import db.DB;
import java.sql.PreparedStatement;
import javax.ws.rs.PathParam;

/**
 *
 * @author HiraldoTran
 */
public class detalleVentaFactura {
   private int id;
   private int idVentaFactura;
   private String tipoFacturaVentaFactura;
   private int idProducto;
   private int precio;
   private int cantidad;
   private int costo;
   private int itbis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getItbis() {
        return itbis;
    }

    public void setItbis(int itbis) {
        this.itbis = itbis;
    }
   
    public void insertar_detalle_venta_factura(String informacion) throws Exception{
        
        DB dbase = new DB("itla2","itlajava","12345678@itla");
        
        String sql="INSERT INTO public.t_detalle_venta_factura(f_id_t_venta_factura,f_tipo_factura_t_venta_factura,f_id_t_productos,f_precio,f_cantidad,f_costo,f_itbis)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        
        Gson json = new Gson();
        detalleVentaFactura info = json.fromJson(informacion, detalleVentaFactura.class);
        p.setInt(1, idVentaFactura);
        p.setString(2, tipoFacturaVentaFactura);
        p.setInt(3, idProducto);
        p.setInt(4, precio);
        p.setInt(5, cantidad);
        p.setInt(6, costo);
        p.setInt(7, itbis);
        p.execute();
        
        
    
    }
   
}
