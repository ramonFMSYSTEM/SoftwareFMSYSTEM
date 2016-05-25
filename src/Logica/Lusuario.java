/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Datos.Dusuario;
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
public class Lusuario {
    private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public DefaultTableModel MostrarUsuarios(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos= {"ID","Nombre","Apellido Paterno","Apellido Materno","Telefono","Dirección","Puesto","Email","Contrasena"};
   
       String[] registro = new String [10];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from usuario where nombre_usuario like '%"+ buscar + "%' order by id_usuario";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro[0]=rs.getString("id_usuario");
               registro[1]=rs.getString("nombre_usuario");
               registro[2]=rs.getString("apellidop_usuario");
               registro[3]=rs.getString("apellidom_usuario");
               registro[4]=rs.getString("tel_usuario");
               registro[5]=rs.getString("direccion_usuario");
               registro[6]=rs.getString("puesto_usuario");
               registro[7]=rs.getString("email_usuario");
               registro[8]=rs.getString("contraseña_usuario");
               
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
           }
           return modelo;
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
   }
   public boolean InsertarUsuario (Dusuario dts){
       sSQL="insert into usuario (nombre_usuario,apellidop_usuario,apellidom_usuario,tel_usuario,direccion_usuario,puesto_usuario,email_usuario,contraseña_usuario)" +
              " values (?,?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst= cn.prepareStatement(sSQL);
           pst.setString(1,dts.getNombreu());
           pst.setString(2,dts.getApellidopu());
           pst.setString(3,dts.getApellidomu()); 
           pst.setString(4,dts.getTelefonou());
           pst.setString(5,dts.getDireccionu());
           pst.setString(6,dts.getPuestou());
           pst.setString(7,dts.getEmailu());
           pst.setString(8,dts.getContrasenau());
           
          
           
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
   
   public boolean EditarUsuario (Dusuario dts){
       sSQL="update usuario set nombre_usuario=?,apellidop_usuario=?,apellidom_usuario=?,tel_usuario=?,direccion_usuario=?,puesto_usuario=?,email_usuario=?,contraseña_usuario=?" +
               "where id_usuario=?";
       try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
           
           
           pst.setString(1,dts.getNombreu());
           pst.setString(2,dts.getApellidopu());
           pst.setString(3,dts.getApellidomu()); 
           pst.setString(4,dts.getTelefonou());
           pst.setString(5,dts.getDireccionu());
           pst.setString(6,dts.getPuestou());
            pst.setString(7,dts.getEmailu());
           pst.setString(8,dts.getContrasenau());
          
           pst.setInt(9,dts.getIdusuario());
           
           
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
   
   public boolean EliminarUsuario (Dusuario dts){
       sSQL="delete from usuario where id_usuario =?";
       
       try {
           PreparedStatement pst= cn.prepareStatement(sSQL);
           
            pst.setInt(1,dts.getIdusuario());
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
   
    public Dusuario Login(String Emailu,String Contrasenau) {
        
        Dusuario usuario = new Dusuario();
        usuario.setIdusuario(-1);

        sSQL = "select * from usuario WHERE email_usuario='"+Emailu+" 'and contraseña_usuario='" + Contrasenau+"'";
        /*sSQL = "select  id_usuario,nombre_usuario,apellidop_usuario,apellidom_usuario,puesto_usuario,email_usuario,contraseña_usuario from usuario"
               + "where email_usuario='" + Emailu + " 'and contraseña_usuario='" + Contrasenau+"'" ;*/
                
        
      //  "SELECT * FROM Login Where usuario='"+usuario+"'and password='"+password+"'"

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                usuario.setIdusuario(Integer.parseInt(rs.getString("id_usuario")));
                usuario.setNombreu(rs.getString("nombre_usuario"));
                usuario.setApellidopu(rs.getString("apellidop_usuario"));
                usuario.setApellidomu(rs.getString("apellidom_usuario"));
                usuario.setDireccionu(rs.getString("direccion_usuario"));
                usuario.setPuestou(rs.getString("puesto_usuario"));
                usuario.setTelefonou(rs.getString("tel_usuario"));
                usuario.setEmailu(rs.getString("email_usuario"));
                usuario.setContrasenau(rs.getString("contraseña_usuario"));
                

            }
            return usuario;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
}
