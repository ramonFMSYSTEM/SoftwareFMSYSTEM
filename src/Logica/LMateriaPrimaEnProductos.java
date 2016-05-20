/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DMateriaPrimaEnProductos;
import claseConectar.conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alee
 */
public class LMateriaPrimaEnProductos {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSql="";
    
    
    
//    public DefaultTableModel mostrar1(String buscar){
//        DefaultTableModel modelo;
//        
//        String [] titulos = {"Categoria","Proveedor", "ID", "Cantidad", "Unidad_medidad", "Producto", "Descripcion", "Precio", "Fecha_compra", "Fecha_cad"}; 
//        
//        String [] registro=new String [11];
//        
//        modelo=new DefaultTableModel(null,titulos);
//        
//        sSql="select * from productos where Descripcion like' " + buscar + " 'order by ID ";
//        
//        try {
//           Statement st= cn.createStatement();
//           ResultSet rs= st.executeQuery(sSql);
//           
//           while(rs.next()){
//               registro [0]=rs.getString("Categoria");
//               registro [1]=rs.getString("Proveedor");
//               registro [2]=rs.getString("ID");
//               registro [3]=rs.getString("Cantidad");
//               registro [4]=rs.getString("Unidad_medidad");
//               registro [5]=rs.getString("Producto");
//               registro [6]=rs.getString("Descripcion");
//               registro [7]=rs.getString("Precio");
//               registro [8]=rs.getString("Fecha_compra");
//               registro [9]=rs.getString("Fecha_cad");
//               
//               modelo.addRow(registro);
//           }
//           return modelo;
//           
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//    }
    public ArrayList mostrar(String buscar){
       //DefaultTableModel modelo;
       
       ArrayList<DMateriaPrimaEnProductos> mppArr = new ArrayList();
       
       //String [] titulos= {"ID","ID Producto","ID Materia Prima","Descripcion","Cantidad"};
   
       //String[] registro = new String [5];
       
      // totalregistros=0;
       //modelo = new DefaultTableModel(null,titulos);
       
       sSql="select * from elemento where Idproductofinal like '%"+ buscar + "%' order by ID";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           
           while(rs.next()){
               DMateriaPrimaEnProductos mpp = new DMateriaPrimaEnProductos();
               mpp.setId(Integer.parseInt(rs.getString("idelementos")));
               mpp.setIdProducto(rs.getString("idproductofinal"));
               mpp.setIdMateriaPrima(Integer.parseInt(rs.getString("ID")));
               mpp.setDescripcionMP(rs.getString("descripcion"));
               mpp.setCantidadMP(Integer.parseInt(rs.getString("cantidad")));
               
               mppArr.add(mpp);
               /*
               registro[0]=rs.getString("idelementos");
               registro[1]=rs.getString("idproductofinal");
               registro[2]=rs.getString("ID");
              registro[3]=rs.getString("descripcion");
              registro[4]=rs.getString("cantidad");
                */
//               
               
             //  totalregistros=totalregistros+1;
               //modelo.addRow(registro);
           }
           return mppArr;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e+"/n No se encuentra la materia Prima del producto indicado");
           return null;
       }
   }
    
    
    public DMateriaPrimaEnProductos buscar(int id){
       //DefaultTableModel modelo;
       
       //String [] titulos= {"ID","ID Producto","ID Materia Prima","Descripcion","Cantidad"};
   
       //String[] registro = new String [5];
       
      // totalregistros=0;
       //modelo = new DefaultTableModel(null,titulos);
       
       sSql="select * from elemento where idelementos like '%"+ id + "%' order by ID";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           
            DMateriaPrimaEnProductos mpp = new DMateriaPrimaEnProductos();
           while(rs.next()){
               mpp.setId(Integer.parseInt(rs.getString("idelementos")));
               mpp.setIdProducto(rs.getString("idproductofinal"));
               mpp.setIdMateriaPrima(Integer.parseInt(rs.getString("ID")));
               mpp.setDescripcionMP(rs.getString("descripcion"));
               mpp.setCantidadMP(Integer.parseInt(rs.getString("cantidad")));
               
           }
           return mpp;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e+"/n No se encuentra la materia Prima del producto indicado");
           return null;
       }
   }
    
    
    /*
    public DefaultTableModel mostrarMin(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos= {"Id","Producto","Cantidad","Proveedor","Unidad demedida","Categoria","Descripcion","Precio","fecha compra","fecha caducidad"};
          
       String[] registro = new String [10];
       
      // totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSql="select * from productos where Producto like '%"+ buscar + "%' order by ID";
       
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
*/
    
    public boolean insertar(DMateriaPrimaEnProductos mpp){
        sSql="insert into elemento (idproductofinal, ID, descripcion, cantidad)"+
                "values (?, ?, ?, ?)";
        
        try {
            
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setString(1, mpp.getIdProducto());
            pst.setInt(2, mpp.getIdMateriaPrima());
            pst.setString(3, mpp.getDescripcionMP());
            pst.setInt(4, mpp.getCantidadMP());
            
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
    
    
    
     public boolean editar(DMateriaPrimaEnProductos mpp){
         sSql="update elemento set descripcion=?, cantidad=? where idproductofinal=? and ID=?";
         //(idproductofinal, ID, descripcion, cantidad)"
         
         
        try {
            
              
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setString(1, mpp.getDescripcionMP());
            pst.setInt(2, mpp.getCantidadMP());            
            pst.setString(3, mpp.getIdProducto());
            pst.setInt(4, mpp.getIdMateriaPrima());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                insertar(mpp);
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
     
     
    
      public boolean eliminar(DMateriaPrimaEnProductos dts){
          sSql="delete from elemento where idproductofinal=? and id=?";
        try {
            
            PreparedStatement pst= cn.prepareStatement(sSql);
            pst.setString(1, dts.getIdProducto());
            pst.setInt(2, dts.getIdMateriaPrima());
            
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
