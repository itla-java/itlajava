/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import db.DB;
import java.sql.PreparedStatement;

/**
 *
 * @author HiraldoTran
 */
public class detalleAlquilerFactura {
    private int f_id;
    private int f_id_t_alquiler_factura;
    private String f_tipo_Factura_t_alquiler_factura;
    private int f_id_t_Producto;
    private String f_fecha_salida;
    private String f_fecha_entrada;
    private String f_fecha_entrada_real;
    private int f_cantidad;
    private int f_precio;
    private int f_costo;
    private int f_itbis;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getF_id_t_alquiler_factura() {
        return f_id_t_alquiler_factura;
    }

    public void setF_id_t_alquiler_factura(int f_id_t_alquiler_factura) {
        this.f_id_t_alquiler_factura = f_id_t_alquiler_factura;
    }

    public String getF_tipo_Factura_t_alquiler_factura() {
        return f_tipo_Factura_t_alquiler_factura;
    }

    public void setF_tipo_Factura_t_alquiler_factura(String f_tipo_Factura_t_alquiler_factura) {
        this.f_tipo_Factura_t_alquiler_factura = f_tipo_Factura_t_alquiler_factura;
    }

    public int getF_id_t_Producto() {
        return f_id_t_Producto;
    }

    public void setF_id_t_Producto(int f_id_t_Producto) {
        this.f_id_t_Producto = f_id_t_Producto;
    }

    public String getF_fecha_salida() {
        return f_fecha_salida;
    }

    public void setF_fecha_salida(String f_fecha_salida) {
        this.f_fecha_salida = f_fecha_salida;
    }

    public String getF_fecha_entrada() {
        return f_fecha_entrada;
    }

    public void setF_fecha_entrada(String f_fecha_entrada) {
        this.f_fecha_entrada = f_fecha_entrada;
    }

    public String getF_fecha_entrada_real() {
        return f_fecha_entrada_real;
    }

    public void setF_fecha_entrada_real(String f_fecha_entrada_real) {
        this.f_fecha_entrada_real = f_fecha_entrada_real;
    }

    public int getF_cantidad() {
        return f_cantidad;
    }

    public void setF_cantidad(int f_cantidad) {
        this.f_cantidad = f_cantidad;
    }

    public int getF_precio() {
        return f_precio;
    }

    public void setF_precio(int f_precio) {
        this.f_precio = f_precio;
    }

    public int getF_costo() {
        return f_costo;
    }

    public void setF_costo(int f_costo) {
        this.f_costo = f_costo;
    }

    public int getF_itbis() {
        return f_itbis;
    }

    public void setF_itbis(int f_itbis) {
        this.f_itbis = f_itbis;
    }

   
    
    
    public void insertar_detalle_alquiler_factura(String informacion) throws Exception{
    
    
        DB dbase = new DB("ilta2","itlajava","12345678@itla");
        String sql;
        sql="INSERT INTO public.t_detalle_alquiler_factura(f_id_t_alquiler_factura,f_tipo_factura_t_alquiler_factura,f_id_t_productos,f_fecha_salida,f_fecha_entrada,f_fecha_real_entrada,f_cantidad,f_precio,f_costo,f_itbis)";
        sql+="VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        Gson json = new Gson();
        detalleAlquilerFactura info = json.fromJson(informacion, detalleAlquilerFactura.class);
        
        PreparedStatement p = DB.conexion.prepareStatement(sql);
        p.setInt(1, f_id_t_alquiler_factura);
        p.setString(2, f_tipo_Factura_t_alquiler_factura);
        p.setInt(3, f_id_t_Producto);
        p.setString(4,f_fecha_salida);
        p.setString(5,f_fecha_entrada);
        p.setString(6,f_fecha_entrada_real);
        p.setInt(7,f_cantidad);
        p.setInt(8,f_precio);
        p.setInt(9,f_costo);
        p.setInt(10,f_itbis);
        p.execute();
        
        dbase.CerrarConexion();

    }
    
}
