/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import claseConectar.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author usuario
 */
public class Reportes {
    public void ReporteUsuario() throws SQLException, JRException{
      Connection a;
      a = DriverManager.getConnection("jdbc:mysql://localhost/bdfloreria","root","");
     // String ubicacionReporte=System.getProperty("user.dir")+"/Cliente.jasper";
     
      JasperReport reporte=null;
     // reporte = (JasperReport) JRLoader.loadObject(ubicacionReporte);
      reporte=(JasperReport) JRLoader.loadObjectFromFile("src/Reportes/RUsuarios.jasper");
      JasperPrint print=JasperFillManager.fillReport(reporte, null, a);
      JasperViewer ver=new JasperViewer(print,false);
      ver.setTitle("Usuario");
      ver.setVisible(true);
      
       
    }
   
    public void ReporteVentaDetalle() throws SQLException, JRException{
      Connection a;
      a = DriverManager.getConnection("jdbc:mysql://localhost/bdfloreria","root","");
     // String ubicacionReporte=System.getProperty("user.dir")+"/Cliente.jasper";
     
      JasperReport reporte=null;
     // reporte = (JasperReport) JRLoader.loadObject(ubicacionReporte);
      reporte=(JasperReport) JRLoader.loadObjectFromFile("src/Reportes/RVentaDetalle.jasper");
      JasperPrint print=JasperFillManager.fillReport(reporte, null, a);
      JasperViewer ver=new JasperViewer(print,false);
      ver.setTitle("Reporte de ventas a detalle");
      ver.setVisible(true);
      
       
    }
    public void ReporteProveedor() throws SQLException, JRException{
      Connection a;
      a = DriverManager.getConnection("jdbc:mysql://localhost/bdfloreria","root","");
     // String ubicacionReporte=System.getProperty("user.dir")+"/Cliente.jasper";
     
      JasperReport reporte=null;
     // reporte = (JasperReport) JRLoader.loadObject(ubicacionReporte);
      reporte=(JasperReport) JRLoader.loadObjectFromFile("src/Reportes/RProveedor.jasper");
      JasperPrint print=JasperFillManager.fillReport(reporte, null, a);
      JasperViewer ver=new JasperViewer(print,false);
      ver.setTitle("Reporte de Proveedores");
      ver.setVisible(true);
      
       
    }
    public void ReporteVenta() throws SQLException, JRException{
      Connection a;
      a = DriverManager.getConnection("jdbc:mysql://localhost/bdfloreria","root","");
     // String ubicacionReporte=System.getProperty("user.dir")+"/Cliente.jasper";
     
      JasperReport reporte=null;
     // reporte = (JasperReport) JRLoader.loadObject(ubicacionReporte);
      reporte=(JasperReport) JRLoader.loadObjectFromFile("src/Reportes/RVenta.jasper");
      JasperPrint print=JasperFillManager.fillReport(reporte, null, a);
      JasperViewer ver=new JasperViewer(print,false);
      ver.setTitle("Reporte de Proveedores");
      ver.setVisible(true);
      
       
    }
}
