/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DmateriaPrima;
import claseConectar.conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author alee
 */
public class LMateriaPrima {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSql="";
    
    
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos= {"Categoria","Proveedor","ID","Cantidad","Unidad demedida","Producto","Descripcion","Precio","fecha compra","fecha caducidad"};
   
       String[] registro = new String [10];
       
      // totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSql="select * from materia_prima where Producto like '%"+ buscar + "%' order by ID";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           
           while(rs.next()){
               registro[0]=rs.getString("Categoria");
               registro[1]=rs.getString("Proveedor");
               registro[2]=rs.getString("ID");
              registro[3]=rs.getString("Cantidad");
              registro[4]=rs.getString("Unidad_medida");
               registro[5]=rs.getString("Producto");
               registro[6]=rs.getString("Descripcion");
                 registro [7]=rs.getString("Precio");
               registro [8]=rs.getString("Fecha_compra");
               registro [9]=rs.getString("Fecha_cad");
//               
               
             //  totalregistros=totalregistros+1;
               modelo.addRow(registro);
           }
           return modelo;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
   }
    
    public DmateriaPrima buscar(int buscar){
        
       DmateriaPrima dmp = new DmateriaPrima();
             //"select * from producto WHERE id_producto='"+buscar+"'"
       sSql="select * from materia_prima where id='"+buscar+"'";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           rs.next();
           
           dmp.setCategoria(rs.getString("Categoria"));
           dmp.setProveedor(rs.getString("Proveedor"));
           dmp.setID(rs.getInt("ID"));
           dmp.setCantidad(rs.getInt("Cantidad"));
           dmp.setUnidad_medidad(rs.getString("Unidad_medida"));
           dmp.setProducto(rs.getString("Producto"));
           dmp.setDescripcion(rs.getString("Descripcion"));
           dmp.setPrecio(rs.getDouble("Precio"));
           dmp.setFecha_compra(rs.getString("Fecha_compra"));
           dmp.setFecha_cad(rs.getString("Fecha_cad"));
           
           /*
           while(rs.next()){
               
               
               
               registro[0]=rs.getString("Categoria");
               registro[1]=rs.getString("Proveedor");
               registro[2]=rs.getString("ID");
              registro[3]=rs.getString("Cantidad");
              registro[4]=rs.getString("Unidad_medida");
               registro[5]=rs.getString("Producto");
               registro[6]=rs.getString("Descripcion");
                 registro [7]=rs.getString("Precio");
               registro [8]=rs.getString("Fecha_compra");
               registro [9]=rs.getString("Fecha_cad");
//               
               
             //  totalregistros=totalregistros+1;
               modelo.addRow(registro);
           }
*/
           return dmp;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
   }
    
    public DefaultTableModel mostrarMin(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos= {"Id","Producto","Cantidad","Proveedor","Unidad demedida","Categoria","Descripcion","Precio","fecha compra","fecha caducidad"};
          
       String[] registro = new String [10];
       
      // totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSql="select * from materia_prima where Producto like '%"+ buscar + "%' order by ID";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           
           while(rs.next()){
               registro[0]=rs.getString("ID");
               registro[1]=rs.getString("Producto");
               registro[2]=rs.getString("Cantidad");
              registro[3]=rs.getString("Proveedor");
              registro[4]=rs.getString("Unidad_medida");
               registro[5]=rs.getString("Categoria");
               registro[6]=rs.getString("Descripcion");
                 registro [7]=rs.getString("Precio");
               registro [8]=rs.getString("Fecha_compra");
               registro [9]=rs.getString("Fecha_cad");
//               
               
             //  totalregistros=totalregistros+1;
               modelo.addRow(registro);
           }
           return modelo;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
   }
    
    public boolean insertar(DmateriaPrima dts){
        sSql="insert into materia_prima (Categoria, Proveedor, Cantidad, Unidad_medida, Producto, Descripcion, Precio, Fecha_compra, Fecha_cad)"+
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setString(1, dts.getCategoria());
            pst.setString(2, dts.getProveedor());
            pst.setInt(3, dts.getCantidad());
            pst.setString(4, dts.getUnidad_medidad());
            pst.setString(5, dts.getProducto());
            pst.setString(6, dts.getDescripcion());
            pst.setDouble(7, dts.getPrecio());
            pst.setString(8, dts.getFecha_compra());
            pst.setString(9, dts.getFecha_cad());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
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
    
    
    
     public boolean editar(DmateriaPrima dts){
         sSql="update materia_prima set Cantidad=?, Precio=?, Fecha_compra=?, Fecha_cad=? where ID=?";
         
         
        try {
            
              
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setInt(1, dts.getCantidad());
            pst.setDouble(2, dts.getPrecio());
            pst.setString(3, dts.getFecha_compra());
            pst.setString(4, dts.getFecha_cad());
            pst.setInt(5, dts.getID());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
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
     
     
      public boolean eliminar(DmateriaPrima dts){
          sSql="delete from materia_prima where ID=?";
        try {
            
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setInt(1, dts.getID());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
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
