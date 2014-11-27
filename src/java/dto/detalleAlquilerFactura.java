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
public class detalleAlquilerFactura {
    private int id;
    private int idAlquilerFactura;
    private String tipoFactura_alquilerFactura;
    private int idProducto;
    private String fechaSalida;
    private String fechaEntrada;
    private String fechaEntradaReal;
    private int cantidad;
    private int precio;
    private int costo;
    private int itbis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlquilerFactura() {
        return idAlquilerFactura;
    }

    public void setIdAlquilerFactura(int idAlquilerFactura) {
        this.idAlquilerFactura = idAlquilerFactura;
    }

    public String getTipoFactura_alquilerFactura() {
        return tipoFactura_alquilerFactura;
    }

    public void setTipoFactura_alquilerFactura(String tipoFactura_alquilerFactura) {
        this.tipoFactura_alquilerFactura = tipoFactura_alquilerFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int  getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    public String getFechaEntradaReal() {
        return fechaEntradaReal;
    }

    public void setFechaEntradaReal(String fechaEntradaReal) {
        this.fechaEntradaReal = fechaEntradaReal;
    }
    
    
    public void insertar_detalle_alquiler_factura(String informacion) throws Exception{
    
    
        DB dbase = new DB("ilta2","itlajava","12345678@itla");
        String sql;
        sql="INSERT INTO public.t_detalle_alquiler_factura(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_productos,f_fecha_salida,f_fecha_entrada,f_fecha_real_entrada,f_cantidad,f_precio,f_costo,f_itbis)";
        sql+="VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setInt(1, idAlquilerFactura);
        p.setString(2, tipoFactura_alquilerFactura);
        p.setInt(3, idProducto);
        p.setString(4,fechaSalida);
        p.setString(5,fechaEntrada);
        p.setString(6,fechaEntradaReal);
        p.setInt(7,cantidad);
        p.setInt(8,precio);
        p.setInt(9,costo);
        p.setInt(10,itbis);
        p.execute();
        
        
        
        
        
    
    }
    
}
