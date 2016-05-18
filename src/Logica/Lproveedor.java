/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Datos.Dproveedor;
import claseConectar.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitela
 */
public class Lproveedor {
   private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public DefaultTableModel MostrarProveedores(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos= {"ID","Nombre","Dirección","Telefono local","Telefono celular"};
   
       String[] registro = new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from proveedor where nombreempresa_proveedor like '%"+ buscar + "%' order by id_proveedor";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro[0]=rs.getString("id_proveedor");
               registro[1]=rs.getString("nombreempresa_proveedor");
               registro[2]=rs.getString("direccion_proveedor");
               registro[3]=rs.getString("telefono_proveedor");
               registro[4]=rs.getString("celular_proveedor");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
           }
           return modelo;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
   }
   public boolean InsertarProveedor (Dproveedor dts){
       sSQL="insert into proveedor (nombreempresa_proveedor,direccion_proveedor,telefono_proveedor,celular_proveedor)" +
              " values (?,?,?,?)";
       try {
           
           PreparedStatement pst= cn.prepareStatement(sSQL);
           pst.setString(1,dts.getNombre());
           pst.setString(2,dts.getDireccion());
           pst.setString(3,dts.getTelefonop());
           pst.setString(4,dts.getCelularp());
          
           
           int n=pst.executeUpdate();
           if (n!=0){
               return true;
           }
           else{
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   
   }
   
   public boolean EditarProveedor (Dproveedor dts){
       sSQL="update proveedor set nombreempresa_proveedor=?,direccion_proveedor=?,telefono_proveedor=?,celular_proveedor=?" +
               "where id_proveedor=?";
       try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
           pst.setString(1,dts.getNombre());
           pst.setString(2,dts.getDireccion());
           pst.setString(3,dts.getTelefonop());
           pst.setString(4,dts.getCelularp());
           pst.setInt(5,dts.getIdproveedor());
           int n=pst.executeUpdate();
           if (n!=0){
               return true;
           }
           else{
               return false;
           }
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   
   }
   
   public boolean EliminarProveedor (Dproveedor dts){
       sSQL="delete from proveedor where id_proveedor =?";
       
       try {
           PreparedStatement pst= cn.prepareStatement(sSQL);
           
            pst.setInt(1,dts.getIdproveedor());
           int n=pst.executeUpdate();
           if (n!=0){
               return true;
           }
           else{
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   
   }
}
