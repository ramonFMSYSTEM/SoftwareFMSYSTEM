/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import Datos.DTotal;
import Datos.Dventa;
import Presentacion.frmVenta;
import static Presentacion.frmVenta.tablaRealizarVenta;
import static Presentacion.frmVenta.txtidusuario;

import claseConectar.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vitela
 */
public class Lventa {
   private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
    public boolean InsertarVenta (Dventa dts){
       sSQL="insert into venta (id_venta,id_usuario,subtotal_venta,iva_venta,total_venta,fecha_venta) VALUES (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst= cn.prepareStatement(sSQL);
           pst.setString(1,dts.getIdVenta());
           pst.setInt(2,dts.getIdUsuario());
           pst.setString(3,dts.getSubtotalVenta());
           pst.setString(4,dts.getIvaVenta());
           pst.setString(5,dts.getTotalVenta());
           pst.setString(6,dts.getFechaVenta());
           
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
   //DESCONTAR EN INVENTARIO DESPUES DE VENTA
   public void DescontarStock(String idproventa, String cantproventa) {
        int descontar = Integer.parseInt(cantproventa);
        String stock = "";
        int desfinal;
        String consul = "SELECT * FROM producto_final WHERE  id_producto='" + idproventa + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                stock = rs.getString(5);
            }

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(stock) - descontar;
        String modi = "UPDATE producto_final SET Stock_producto='" + desfinal + "' WHERE id_producto = '" + idproventa + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }

    }
   
    public DTotal CalcularTotal(JTable tablaRealizarVenta) {
        DTotal total= new DTotal();

        for (int i = 0; i < tablaRealizarVenta.getRowCount(); i++) {
            total.setPre(tablaRealizarVenta.getValueAt(i, 2).toString()); // tablaRealizarVenta.getValueAt(i, 2).toString();
            total.setCan(tablaRealizarVenta.getValueAt(i, 3).toString());//can = tablaRealizarVenta.getValueAt(i, 3).toString();
            total.setPrecio(Double.parseDouble(total.getPre()));//precio = Double.parseDouble(pre);
            total.setCantidad(Integer.parseInt(total.getCan()));//cantidad = Integer.parseInt(can);
            total.setImporte(total.getPrecio() * total.getCantidad());//importe = precio * cantidad;
            total.setSubtotal(total.getSubtotal()+total.getImporte());//subtotal = subtotal + importe;
            total.setIva(total.getSubtotal()*0.16);//iva = subtotal * 0.16;
            total.setTotal(total.getSubtotal() + total.getIva());//total = subtotal + iva;

            tablaRealizarVenta.setValueAt(Math.rint(total.getImporte() * 100) / 100, i, 4);

        }
        total.setTabla(tablaRealizarVenta);
        return total;
    }
    
    public String numeros() {
        conexion cc = new conexion();
        Connection cn = cc.conectar();
    
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "select max(id_venta) from venta";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
    
    public String CalcularCambio(String total, String efectivo){
        // String efectivo;
        double cambio;
        //String total = txtTotal.getText();
        double total2 = Double.parseDouble(total);

        //efectivo = (txtEfectivo.getText());
        double efectivo2 = Double.parseDouble(efectivo);

        cambio = efectivo2 - total2;
        String cad="" + Math.rint(cambio * 100) / 100;
        return cad;
    }
   

}
