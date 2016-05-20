/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Presentacion;


import claseConectar.conexion;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class frmConsultaUsuariosV extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;

   
    public frmConsultaUsuariosV() {
        initComponents();
        mostrarusuarios("");
      
    }
   
    void mostrarusuarios(String valor)
    {
        String[]titulos={"Id de usuario","Nombre","ApellidoP","ApellidoM","Email"} ;  
        String []Registros= new String[5];
        modelo=new DefaultTableModel(null,titulos);
        String Sql="SELECT * FROM usuario WHERE CONCAT(id_usuario,nombre_usuario,apellidop_usuario,apellidom_usuario,email_usuario) LIKE '%"+valor+"%'";
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                 Registros[0]=rs.getString("id_usuario");  
                 Registros[1]=rs.getString("nombre_usuario");  
                 Registros[2]=rs.getString("apellidop_usuario");  
                 Registros[3]=rs.getString("apellidom_usuario");  
                 Registros[4]=rs.getString("email_usuario");  
                 
                 modelo.addRow(Registros);
             } 
             tablaUsuarios.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmConsultaUsuariosV.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblBuscarUs = new javax.swing.JLabel();
        txtbus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        mnenviar.setText("Enviar Datos");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Usuarios");

        lblBuscarUs.setText("Buscar Usuario:");

        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });
        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaUsuarios.setComponentPopupMenu(jPopupMenu1);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBuscarUs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarUs)
                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_txtbusActionPerformed

private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
// TODO add your handling code here:
    mostrarusuarios(txtbus.getText());
}//GEN-LAST:event_txtbusKeyReleased

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
// TODO add your handling code here:
    
    //envio usuario con clic derecho 
    
    String cod="",nom="",ape="",apem="",email="";
    int fila = tablaUsuarios.getSelectedRow();
    try {
        if(fila==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod =  (String)tablaUsuarios.getValueAt(fila, 0);
         nom =  (String)tablaUsuarios.getValueAt(fila, 1);
         ape =  (String)tablaUsuarios.getValueAt(fila, 2);
         apem =  (String)tablaUsuarios.getValueAt(fila, 3);
         email =  (String)tablaUsuarios.getValueAt(fila, 4);
         frmVenta.txtidusuario.setDisabledTextColor(Color.blue);
         frmVenta.txtidusuario.setText(cod);
         frmVenta.txtnomape.setDisabledTextColor(Color.blue);
         frmVenta.txtnomape.setText(nom+"   "+ape+" "+apem);
         frmVenta.txtEmailUs.setDisabledTextColor(Color.blue);
         frmVenta.txtEmailUs.setText(email);
         this.dispose();
         
        }
    } catch (Exception e) {
    }
}//GEN-LAST:event_mnenviarActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarUs;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables
    conexion cc= new conexion();
    Connection cn = cc.conectar();
}
