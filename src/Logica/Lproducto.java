/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;


import Datos.Dproducto;
import Presentacion.frmProducto;
import claseConectar.conexion;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitela
 */
public class Lproducto {
    DefaultTableModel model;
    private String sSQL="";
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    public Integer totalregistros;
  
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
      
            
          
       String [] titulos= {"ID de producto","Categoria","Nombre","Descripcion","Precio","Stock"};
   
        String [] registros= new String[6];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from producto_final WHERE CONCAT (descripcion_producto,'',nombre_producto) LIKE '%"+buscar+"%'";
          try{  Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
      
      
          
               registros[0]=rs.getString("id_producto");
               registros[1]=rs.getString("categoria");
               registros[2]=rs.getString("nombre_producto");
               registros[3]=rs.getString("descripcion_producto");
               registros[4]=rs.getString("precio_producto");
               registros[5]=rs.getString("Stock_producto");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registros);
           }
           return modelo;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
            
   }
   
   public Dproducto buscar(String buscar){
       //String [] titulos= {"ID de producto","Nombre","Descripcion","Precio","Stock"};
       Dproducto prod = new Dproducto();
       //select * from producto WHERE id_producto='"+cod+"'"
       sSQL="select * from producto_final WHERE id_producto='"+buscar+"'";
          try{  Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
                prod.setCodigo(rs.getString("id_producto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setNombre(rs.getString("nombre_producto"));
                prod.setDescripcion(rs.getString("descripcion_producto"));
                prod.setPrecio(rs.getString("precio_producto"));
                prod.setStock(rs.getString("Stock_producto"));
           }
           return prod;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
            
   }
    public boolean insertar (Dproducto dts){
        
        sSQL="INSERT INTO producto_final (id_producto,categoria,nombre_producto,descripcion_producto,precio_producto,Stock_producto) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst  = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigo());
            pst.setString(2, dts.getCategoria());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getDescripcion());
            pst.setString(5, dts.getPrecio());
            pst.setString(6, dts.getStock());
            int n=pst.executeUpdate();
            if(n>0){
               
            return true;
            }
            else{
            return false;
            }
           
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresoProductos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    
     /*public boolean editar (Dproducto dts){
       sSQL="update habitacion set numero=?,piso=?,descripcion=?,caracteristicas=?,precio_diario=?,estado=?,tipo_habitacion=?" +
               "where idhabitacion=?";
       try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
//           pst.setString(1,dts.getNumero());
//           pst.setString(2,dts.getPiso());
//           pst.setString(3,dts.getDescripcion());
//           pst.setString(4,dts.getCaracteristicas());
//           pst.setDouble(5,dts.getPrecio_diario());
//           pst.setString(6,dts.getEstado());
//           pst.setString(7,dts.getTipo_habitacion());
//            pst.setInt(8,dts.getIdhabitacion());
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
*/
    public boolean editar(Dproducto dts){
         sSQL="update producto_final set categoria=?,nombre_producto=?,descripcion_producto=?,precio_producto=? where id_producto=?";
         
         
        try {
            
              
            PreparedStatement pst  = cn.prepareStatement(sSQL);
            //pst.setString(1, dts.getCodigo());
            pst.setString(1, dts.getCategoria());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getPrecio());
            pst.setString(5, dts.getCodigo());
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
     
      public boolean eliminar(Dproducto dts){
          sSQL="delete from producto_final where id_producto=?";
        try {
            
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigo());
            
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
