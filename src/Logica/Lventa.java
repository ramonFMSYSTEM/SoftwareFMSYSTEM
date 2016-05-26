/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import Datos.DMateriaPrimaEnProductos;
import Datos.DTotal;
import Datos.DmateriaPrima;
import Datos.Dproducto;
import Datos.Dventa;
import Datos.DventaDetalle;
import Presentacion.frmConsultasProductos;
import Presentacion.frmVenta;

import claseConectar.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public DefaultTableModel obtenerTodasLasFacturas(){
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"ID de venta","Id usuario","SUBTOTAL","IVA","TOTAL","FECHA"};
        tabla.setColumnIdentifiers(titulos);
        String consulta= "SELECT * FROM venta";
        String []Datos= new String [7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id_venta");
                Datos[1]=rs.getString("id_usuario");
               
                Datos[2]=rs.getString("subtotal_venta");
                Datos[3]=rs.getString("iva_venta");
                Datos[4]=rs.getString("total_venta");
                Datos[5]=rs.getString("fecha_venta");
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    
    public DefaultTableModel busquedaEspecifica(boolean isIdSelected, boolean isFechaSelected, boolean isTodasSelected, String num, Date fecha){
            
        String consulta="";
        if(isIdSelected)
        {
            consulta= "SELECT * FROM venta WHERE id_venta='"+num+"'";
        }
        if(isFechaSelected)
        {
            SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
            String fec=""+formatofecha.format(fecha);
            consulta= "SELECT * FROM venta WHERE fecha_venta='"+fec+"'";
        }
        if(isTodasSelected)
        {
            consulta= "SELECT * FROM venta ";
        }
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"ID de venta","Id usuario","SUBTOTAL","IVA","TOTAL","FECHA"};
        tabla.setColumnIdentifiers(titulos);

        String []Datos= new String [7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id_venta");
                Datos[1]=rs.getString("id_usuario");
               // Datos[2]=rs.getString("nombre_usuario");
                Datos[2]=rs.getString("subtotal_venta");
                Datos[3]=rs.getString("iva_venta");
                Datos[4]=rs.getString("total_venta");
                Datos[5]=rs.getString("fecha_venta");

                tabla.addRow(Datos);
            }
            } catch (SQLException ex) {
                Logger.getLogger(frmConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        return tabla;
    }
    
    public String validarMateriaPrimaSuficiente(JTable tablaRealizarVenta){
        ArrayList<DMateriaPrimaEnProductos> arrMPP = new ArrayList();
        String cadError="";
        
        LMateriaPrimaEnProductos lmpp = new LMateriaPrimaEnProductos();
        
        
        for(int i=0; i<tablaRealizarVenta.getRowCount(); i++){//Productos en la lista de venta
            int cantidadProducto=0;
            Dproducto dprod = new Dproducto();
            dprod.setCodigo((String)tablaRealizarVenta.getValueAt(i, 0));
            cantidadProducto=Integer.parseInt((String)tablaRealizarVenta.getValueAt(i, 3));
            dprod.setMateriasPrimas(lmpp.mostrar(dprod.getCodigo()));
            
            for(int j=0; j<dprod.getMateriasPrimas().size(); j++){//materias primas en el producto "j" de la lista
                boolean mppExists=false;
                for(int k=0; k<arrMPP.size(); k++){//Lista de materias primas encontradas
                    if(arrMPP.get(k).getIdMateriaPrima()==dprod.getMateriasPrimas().get(j).getIdMateriaPrima()){//Si ya esta registrada la MateriaPrima en la lista
                        mppExists=true;
                        arrMPP.get(k).setCantidadMP(arrMPP.get(k).getCantidadMP()+dprod.getMateriasPrimas().get(j).getCantidadMP()*cantidadProducto);
                    }                    
                }
                if(!mppExists){//si no está en lista se agrega
                    dprod.getMateriasPrimas().get(j).setCantidadMP(dprod.getMateriasPrimas().get(j).getCantidadMP()*cantidadProducto);
                    arrMPP.add(dprod.getMateriasPrimas().get(j));
                }
            }
        }
        for(int x=0; x<arrMPP.size(); x++){//Recorre la lista de materias primas encontradas
            LMateriaPrima lmp = new LMateriaPrima();
            DmateriaPrima mp = new DmateriaPrima();
            mp = lmp.buscar(arrMPP.get(x).getIdMateriaPrima());//Buscar la materia prima(x) en BD
            if(mp.getCantidad()<arrMPP.get(x).getCantidadMP()){//Si la cantidad necesaria es mayor que la existente
                cadError=cadError+"\n"+mp.getProducto()+"   ----   "+mp.getCantidad()+"   ----   "+arrMPP.get(x).getCantidadMP();
            }
        }
        
        return cadError;
    }
    
    public void realizarVenta(JTable tablaRealizarVenta, String idVenta,int idUsuario,String subTotal,String ivaVenta,String totalVenta,String fechaVenta){
        ArrayList<DMateriaPrimaEnProductos> arrMPP = new ArrayList();
        LMateriaPrimaEnProductos lmpp = new LMateriaPrimaEnProductos();
        
        
        for(int i=0; i<tablaRealizarVenta.getRowCount(); i++){//Productos en la lista de venta
            int cantidadProducto=0;
            Dproducto dprod = new Dproducto();
            dprod.setCodigo((String)tablaRealizarVenta.getValueAt(i, 0));
            cantidadProducto=Integer.parseInt((String)tablaRealizarVenta.getValueAt(i, 3));
            dprod.setMateriasPrimas(lmpp.mostrar(dprod.getCodigo()));
            
            for(int j=0; j<dprod.getMateriasPrimas().size(); j++){//materias primas en el producto "j" de la lista
                boolean mppExists=false;
                //DMateriaPrimaEnProductos mpp = new DMateriaPrimaEnProductos();
                //mpp.setId(dprod.getMateriasPrimas().get(j).getIdMateriaPrima());
                
                for(int k=0; k<arrMPP.size(); k++){//Lista de materias primas
                    if(arrMPP.get(k).getIdMateriaPrima()==dprod.getMateriasPrimas().get(j).getIdMateriaPrima()){//Si ya esta registrada la MateriaPrima en la lista
                        mppExists=true;
                        arrMPP.get(k).setCantidadMP(arrMPP.get(k).getCantidadMP()+dprod.getMateriasPrimas().get(j).getCantidadMP()*cantidadProducto);
                    }                    
                }
                if(!mppExists){//si no está en lista se agrega
                    dprod.getMateriasPrimas().get(j).setCantidadMP(dprod.getMateriasPrimas().get(j).getCantidadMP()*cantidadProducto);
                    arrMPP.add(dprod.getMateriasPrimas().get(j));
                }
            }
        }
        
        for(int x=0; x<arrMPP.size(); x++){
            LMateriaPrima lmp = new LMateriaPrima();
            DmateriaPrima mp = new DmateriaPrima();
            mp = lmp.buscar(arrMPP.get(x).getIdMateriaPrima());//obtener materia prima
            mp.setCantidad(mp.getCantidad()-arrMPP.get(x).getCantidadMP());//restar la materia prima usada
            lmp.editar(mp);
            //TODO Agregar las salidas de Materia Prima
        }
        
        
        String idproventa = "", cantproventa = "";
        Dventa dts = new Dventa();
        Lventa func = new Lventa();
                for (int i = 0; i < tablaRealizarVenta.getRowCount(); i++) {
                    idproventa = frmVenta.tablaRealizarVenta.getValueAt(i, 0).toString();
                    cantproventa = frmVenta.tablaRealizarVenta.getValueAt(i, 3).toString();
                    func.DescontarStock(idproventa, cantproventa);
                }
            

            dts.setIdVenta(idVenta);
            dts.setIdUsuario(idUsuario);
            dts.setSubtotalVenta(subTotal);
            dts.setIvaVenta(ivaVenta);
            dts.setTotalVenta(totalVenta);
            dts.setFechaVenta(fechaVenta);

            if (func.InsertarVenta(dts)) {
                JOptionPane.showMessageDialog(null, "La Venta fue registrada ");

            }

            // detalleventa();
            DventaDetalle dtsDV = new DventaDetalle();
            LventaDetalle funcDV = new LventaDetalle();
            for (int i = 0; i < tablaRealizarVenta.getRowCount(); i++) {
                dtsDV.setIdVenta(idVenta);
                dtsDV.setIdProducto(tablaRealizarVenta.getValueAt(i, 0).toString());
                dtsDV.setNombreProducto(tablaRealizarVenta.getValueAt(i, 1).toString());
                dtsDV.setCantidadProducto(tablaRealizarVenta.getValueAt(i, 3).toString());
                dtsDV.setPrecioUnitario(tablaRealizarVenta.getValueAt(i, 2).toString());
                dtsDV.setTotal(tablaRealizarVenta.getValueAt(i, 4).toString());

                try {
                    if (funcDV.InsertarVentaDetalle(dtsDV)) {

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }
   

}
