/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;


import Datos.DventaDetalle;
import Presentacion.frmVenta;
import static Presentacion.frmVenta.tablaRealizarVenta;
import claseConectar.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitela
 */
public class LventaDetalle {
     private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
    public boolean InsertarVentaDetalle (DventaDetalle dtsDV) throws SQLException{
       sSQL="INSERT INTO detalleventa(id_venta,id_producto,nombre_producto,cantidad_producto,preciounitario_producto,preciototal_venta) VALUES (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst= cn.prepareStatement(sSQL);
           pst.setString(1,dtsDV.getIdVenta());
           pst.setString(2,dtsDV.getIdProducto());
           pst.setString(3,dtsDV.getNombreProducto());
           pst.setString(4,dtsDV.getCantidadProducto());
           pst.setString(5,dtsDV.getPrecioUnitario());
           pst.setString(6,dtsDV.getTotal());
        
           int n=pst.executeUpdate();
           if (n!=0){
     
               return true;
           }
           else{
               return false;
           }
           
       } catch (SQLException ex) {
            Logger.getLogger(frmVenta.class.getName()).log(Level.SEVERE, null, ex);
           return false;
       }
   
   }
   
}
