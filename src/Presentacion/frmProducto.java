/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Presentacion;
import Datos.DMateriaPrimaEnProductos;
import Datos.DmateriaPrima;
import Logica.LgenerarCodigos;
import Datos.Dproducto;
import Logica.LMateriaPrima;
import Logica.LMateriaPrimaEnProductos;
import Logica.Lproducto;
import Logica.Lproducto;
import claseConectar.conexion;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


/**
 *
 * @author vitela
 */
public class frmProducto extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    ArrayList<Integer> mppBorrar;
    /** Creates new form IngresoProductos */
    public frmProducto() {
        initComponents();
         this.setLocation(150,15 );
         bloquear();
         mostrar("");
         mppBorrar = new ArrayList();
         //tablaProductos.setCellSelectionEnabled(false);
    }
     void bloquear(){
    txtIDprod.setEnabled(false);
    txtNmbre.setEnabled(false);
    txtDes.setEnabled(false);
    txtPre.setEnabled(false);
    //txtStock.setEnabled(false);
    btnGuardar.setEnabled(false);
    btnNuevo.setEnabled(true);
    btnCancelar.setEnabled(false);
    btnModificar.setEnabled(false);
    btnBorrar.setEnabled(false);
    cboCategoria.setEnabled(false);
    
    }
    void limpiar(){
    txtIDprod.setText("");
    txtNmbre.setText("");
    txtDes.setText("");
    txtPre.setText("");
    //txtStock.setText("");
    mppBorrar = new ArrayList();
    ((DefaultTableModel)tablaProd1.getModel()).setRowCount(0);
    cboCategoria.setSelectedIndex(0);
    }
    void desbloquear(){
    //txtIDprod.setEnabled(true);
    txtNmbre.setEnabled(true);
    txtDes.setEnabled(true);
    txtPre.setEnabled(true);
    cboCategoria.setEnabled(true);
    //txtStock.setEnabled(true);
    
    btnGuardar.setEnabled(true);
    btnNuevo.setEnabled(false);
    btnCancelar.setEnabled(true);
    btnBorrar.setEnabled(true);
    }
     void ocultar_columnas() {
        tablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaProductos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
        
    }
     
     void ocultar_columnas_MatPrim() {
        tablaProd.getColumnModel().getColumn(0).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(0).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(0).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(2).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(2).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(2).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(3).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(3).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(3).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(4).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(4).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(4).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(5).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(5).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(5).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(6).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(6).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(6).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(7).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(7).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(7).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(8).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(8).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(8).setWidth(0);//Oculta Columna de ID
        
        tablaProd.getColumnModel().getColumn(9).setMinWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(9).setMaxWidth(0);//Oculta Columna de ID
        tablaProd.getColumnModel().getColumn(9).setWidth(0);//Oculta Columna de ID
        
        
        
        tablaProd1.getColumnModel().getColumn(0).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(0).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(0).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(3).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(3).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(3).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(4).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(4).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(4).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(5).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(5).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(5).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(6).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(6).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(6).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(7).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(7).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(7).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(8).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(8).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(8).setWidth(0);//Oculta Columna de ID
        
        tablaProd1.getColumnModel().getColumn(9).setMinWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(9).setMaxWidth(0);//Oculta Columna de ID
        tablaProd1.getColumnModel().getColumn(9).setWidth(0);//Oculta Columna de ID

    }
   void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            Lproducto func = new Lproducto();
            modelo = func.mostrar(buscar);
            
            DefaultTableModel modelo2;
            LMateriaPrima func2 = new LMateriaPrima();
            modelo2 = func2.mostrarMin(buscar);
            
            DefaultTableModel modelo3;
            LMateriaPrima func3 = new LMateriaPrima();
            modelo3 = func3.mostrarMin(buscar);

            tablaProd.setModel(modelo2);            
            tablaProd1.setModel(modelo3);
            ((DefaultTableModel)tablaProd1.getModel()).setRowCount(0);
            tablaProductos.setModel(modelo);
            
            //tablaProd.removeColumn(tablaProd.getColumnModel().getColumn(0));
            
            ocultar_columnas_MatPrim();
            ocultar_columnas();
           //lblTotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
   
        void BuscarProductoEditar(String cod) {
        
        try{
           
            Lproducto lprod = new Lproducto();
            Dproducto dprod = lprod.buscar(cod);
            
            txtIDprod.setText(dprod.getCodigo());
            txtNmbre.setText(dprod.getNombre());
            txtDes.setText(dprod.getDescripcion());
            txtPre.setText(dprod.getPrecio());
            cboCategoria.setSelectedItem(dprod.getCategoria());
            //txtStock.setText(dprod.getStock());

            LMateriaPrimaEnProductos lmpp = new LMateriaPrimaEnProductos();
            dprod.setMateriasPrimas(lmpp.mostrar(dprod.getCodigo()));
            //ArrayList<DMateriaPrimaEnProductos> arrDmpp = lmpp.mostrar(dprod.getCodigo());
            
            for(int x=0; x<dprod.getMateriasPrimas().size(); x++){
                //dmp=lmp.
                LMateriaPrima lmp = new LMateriaPrima();
                DmateriaPrima dmp = lmp.buscar(dprod.getMateriasPrimas().get(x).getIdMateriaPrima());
                
                DefaultTableModel modeloAux = (DefaultTableModel) tablaProd1.getModel();
                modeloAux.addRow(new Object[]{dmp.getID(),dmp.getProducto(),dprod.getMateriasPrimas().get(x).getCantidadMP(), dmp.getProveedor(),dmp.getUnidad_medidad(),dmp.getCategoria(),dmp.getDescripcion(),dmp.getPrecio(),dmp.getFecha_compra(),dmp.getFecha_cad()});
            }
            
            /*
            DmateriaPrima dtsMatPrim = new DmateriaPrima();
             
            dtsMatPrim.setID(Integer.parseInt((String)(tablaProd.getValueAt(filasel, 0))));
            dtsMatPrim.setProducto((String)(tablaProd.getValueAt(filasel, 1)));
            dtsMatPrim.setCantidad((Integer.parseInt((String)(tablaProd.getValueAt(filasel, 2)))));
            dtsMatPrim.setProveedor((String)(tablaProd.getValueAt(filasel, 3)));
            dtsMatPrim.setUnidad_medidad((String)(tablaProd.getValueAt(filasel, 4)));
            dtsMatPrim.setCategoria((String)(tablaProd.getValueAt(filasel, 5)));
            dtsMatPrim.setDescripcion((String)(tablaProd.getValueAt(filasel, 6)));
            dtsMatPrim.setPrecio((Double.parseDouble((String)(tablaProd.getValueAt(filasel, 7)))));
            dtsMatPrim.setFecha_compra((String)(tablaProd.getValueAt(filasel, 8)));
            dtsMatPrim.setFecha_cad((String)(tablaProd.getValueAt(filasel, 9)));
            
             DefaultTableModel modeloAux = (DefaultTableModel) tablaProd1.getModel();
             modeloAux.addRow(new Object[]{dtsMatPrim.getID(),dtsMatPrim.getProducto(),dtsMatPrim.getCantidad(), dtsMatPrim.getProveedor(),dtsMatPrim.getUnidad_medidad(),dtsMatPrim.getCategoria(),dtsMatPrim.getDescripcion(),dtsMatPrim.getPrecio(),dtsMatPrim.getFecha_compra(),dtsMatPrim.getFecha_cad()});
            */
            
            }catch(Exception e)
            {
            System.out.println(e.getMessage());
            }
     
    }
        void codigos(){/////// HACER MVC !!!
           
        int j;
        int cont=1;
        String num="";
        String c="";
         String SQL="select max(id_producto) from producto_final";
       // String SQL="select count(*) from factura";
        //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
        //String SQL="SELECT @@identity AS ID";
        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 c=rs.getString(1);
            }
            
           
            if(c==null){
                txtIDprod.setText("CP0001");
            }
            else{
                char r1=c.charAt(2);
            char r2=c.charAt(3);
            char r3=c.charAt(4);
            char r4=c.charAt(5);
            String r="";
            r=""+r1+r2+r3+r4;
                 j=Integer.parseInt(r);
                 LgenerarCodigos gen= new LgenerarCodigos();
                 gen.generar(j);
                 txtIDprod.setText("CP"+gen.serie());
                
            
            }
       
          
                  
           
           
         
        } catch (SQLException ex) {
           Logger.getLogger(frmVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnactualizar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        txtIDprod = new javax.swing.JTextField();
        lblDescrip = new javax.swing.JLabel();
        txtDes = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPre = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNmbre = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        lblBuscarProd = new javax.swing.JLabel();
        txtBuscarProd = new javax.swing.JTextField();
        btnMostrarTodo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProd = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProd1 = new javax.swing.JTable();
        btnAgregarMatPrim = new javax.swing.JButton();
        btnLimpiarMatPrim = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnEliminarMatPrim = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        mnactualizar.setText("Modificar");
        mnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnactualizarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnactualizar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Producto"));

        lblProducto.setText("Id producto:");

        txtIDprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDprodActionPerformed(evt);
            }
        });

        lblDescrip.setText("Descripcion:");

        txtDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio:");

        txtPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreActionPerformed(evt);
            }
        });

        lblStock.setText("Categoría:");

        lblNombre.setText("Nombre:");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San Valentín", "Día de la Madre", "Graduación", "Maternidad", "Día del padre", "Funeral", "Boda", "Quinceañera", "Navidad", "Primaveral", "Cumpleaños", "Bautizo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescrip)
                    .addComponent(lblProducto)
                    .addComponent(lblPrecio)
                    .addComponent(lblStock)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDprod, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtNmbre)
                    .addComponent(txtDes)
                    .addComponent(txtPre)
                    .addComponent(cboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtIDprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNmbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescrip)
                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio)
                    .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnBorrar.setText("Eliminar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblBuscarProd.setText("Buscar:");

        txtBuscarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdKeyReleased(evt);
            }
        });

        btnMostrarTodo.setText("Mostrar Todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Materia Prima Disponible"));

        tablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablaProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaProd.setMaximumSize(new java.awt.Dimension(200, 64));
        tablaProd.setPreferredSize(new java.awt.Dimension(70, 64));
        jScrollPane3.setViewportView(tablaProd);

        jScrollPane5.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Materia Prima Seleccionada"));

        tablaProd1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Material", "Cantidad"
            }
        ));
        jScrollPane4.setViewportView(tablaProd1);

        jScrollPane6.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        btnAgregarMatPrim.setText("Agregar >>>");
        btnAgregarMatPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMatPrimActionPerformed(evt);
            }
        });

        btnLimpiarMatPrim.setText("Limpiar >>>");
        btnLimpiarMatPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMatPrimActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablaProductos.setComponentPopupMenu(jPopupMenu1);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        jScrollPane7.setViewportView(jScrollPane2);

        btnEliminarMatPrim.setText("Eliminar o No >>>");
        btnEliminarMatPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMatPrimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(lblBuscarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarMatPrim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMatPrim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(btnLimpiarMatPrim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarTodo)
                            .addComponent(txtBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuscarProd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnAgregarMatPrim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarMatPrim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarMatPrim))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtIDprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDprodActionPerformed
// TODO add your handling code here:
    txtIDprod.transferFocus();
}//GEN-LAST:event_txtIDprodActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
// TODO add your handling code here:
    desbloquear();
    limpiar();
    txtIDprod.requestFocus();
   codigos();
}//GEN-LAST:event_btnNuevoActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
    bloquear();
    limpiar();
}//GEN-LAST:event_btnCancelarActionPerformed

private void txtDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesActionPerformed
// TODO add your handling code here:
    txtDes.transferFocus();
}//GEN-LAST:event_txtDesActionPerformed

private void txtPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreActionPerformed
// TODO add your handling code here:
    txtPre.transferFocus();
}//GEN-LAST:event_txtPreActionPerformed

private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
// TODO add your handling code here:
    mostrar("");
}//GEN-LAST:event_btnMostrarTodoActionPerformed

private void txtBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdKeyReleased
// TODO add your handling code here:
    mostrar(txtBuscarProd.getText());
}//GEN-LAST:event_txtBuscarProdKeyReleased

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:
       int filasel= tablaProductos.getSelectedRow();
       try {
           if(filasel==-1)
           {
            JOptionPane.showMessageDialog(null, "Seleccione algun dato");
           }
           else
           {
             String  cod=(String)tablaProductos.getValueAt(filasel, 0);
             //String eliminarSQL="DELETE FROM producto_final WHERE id_producto = '"+cod+"'";
             try {
             /*PreparedStatement pst  = cn.prepareStatement(eliminarSQL);
          pst.executeUpdate();*/
            Dproducto dts = new Dproducto();
            Lproducto func = new Lproducto();
            dts.setCodigo(cod);
            if(func.eliminar(dts)){
                JOptionPane.showMessageDialog(null, "Borrado");
                mostrar("");
            }
            } 
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }
           }
           } 
       catch (Exception e)
       {
       }
}//GEN-LAST:event_mneliminarActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
    ArrayList<DMateriaPrimaEnProductos> arrMpp = new ArrayList();
    
    
        for(int x =0; x<tablaProd1.getRowCount(); x++){
            
            LMateriaPrima funcMatPrimAux = new LMateriaPrima();
            DefaultTableModel mod=funcMatPrimAux.mostrarMin((String)(tablaProd1.getValueAt(0, 1)));
            int cantidadEnStock=(Integer.parseInt((String)(mod.getValueAt(0, 2))));
         
            LMateriaPrima funcMatPrim = new LMateriaPrima();
            DmateriaPrima dtsMatPrim = new DmateriaPrima();
            String id = tablaProd1.getValueAt(x, 0).toString();
            dtsMatPrim.setID(Integer.parseInt(id));
            dtsMatPrim.setProducto((String)(tablaProd1.getValueAt(x, 1)));
            
            //dtsMatPrim.setCantidad(cantidadEnStock-(Integer.parseInt((String)(tablaProd1.getValueAt(x, 2)))));
            dtsMatPrim.setProveedor((String)(tablaProd1.getValueAt(x, 3)));
            dtsMatPrim.setUnidad_medidad((String)(tablaProd1.getValueAt(x, 4)));
            dtsMatPrim.setCategoria((String)(tablaProd1.getValueAt(x, 5)));
            dtsMatPrim.setDescripcion((String)(tablaProd1.getValueAt(x, 6)));
            
            
            dtsMatPrim.setPrecio((Double) tablaProd1.getValueAt(x, 7));
            dtsMatPrim.setFecha_compra((String)(tablaProd1.getValueAt(x, 8)));
            dtsMatPrim.setFecha_cad((String)(tablaProd1.getValueAt(x, 9)));
            
            //funcMatPrim.editar(dtsMatPrim);
            
            
            /*
            String  material=(String)tablaProd.getValueAt(filasel, 0);
             String  stock=(String)tablaProd.getValueAt(filasel, 1);
             DefaultTableModel modeloAux = (DefaultTableModel) tablaProd1.getModel();
             modeloAux.addRow(new Object[]{material,stock});
            */
            
            DMateriaPrimaEnProductos dmpp = new DMateriaPrimaEnProductos();
            dmpp.setIdProducto(txtIDprod.getText());
            dmpp.setIdMateriaPrima(dtsMatPrim.getID());
            //System.out.println("id- "+dmpp.getIdMateriaPrima());
            dmpp.setDescripcionMP(dtsMatPrim.getDescripcion());
            try {
                dmpp.setCantidadMP((Integer.parseInt((String)(tablaProd1.getValueAt(x, 2)))));
            } catch (Exception e) {
                dmpp.setCantidadMP((Integer)(tablaProd1.getValueAt(x, 2)));
            }
            
            
            arrMpp.add(dmpp);
        }
        
        Dproducto dts = new Dproducto();
        Lproducto func = new Lproducto();

        dts.setCodigo(txtIDprod.getText());
        dts.setNombre(txtNmbre.getText());
        dts.setDescripcion(txtDes.getText());
        dts.setPrecio(txtPre.getText());
        dts.setStock("0");
        dts.setCategoria(cboCategoria.getItemAt(cboCategoria.getSelectedIndex()));
        dts.setMateriasPrimas(arrMpp);
        
        LMateriaPrimaEnProductos lmpp = new LMateriaPrimaEnProductos();
        
        if (func.insertar(dts)) {
            for(int x=0; x<arrMpp.size(); x++){
                //System.out.println("id- "+arrMpp.get(x).getIdMateriaPrima());
                lmpp.insertar(arrMpp.get(x));
            }
            //if(lprod.insertar(mpp))
            JOptionPane.showMessageDialog(rootPane, "El producto fue registrado satisfactoriamente");
            mostrar("");
            bloquear();
            limpiar();
        }
            
}//GEN-LAST:event_btnGuardarActionPerformed

private void mnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnactualizarActionPerformed
// TODO add your handling code here:
    ((DefaultTableModel)tablaProd1.getModel()).setRowCount(0);
    try {
        int filaMod=tablaProductos.getSelectedRow();
        if(filaMod==-1)
        {
        JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
        }
        else
        {
        
        btnModificar.setEnabled(true);
        String cod=(String)tablaProductos.getValueAt(filaMod, 0);
        desbloquear();
        btnGuardar.setEnabled(false);
        BuscarProductoEditar(cod);
        }
    } catch (Exception e) {
    }
}//GEN-LAST:event_mnactualizarActionPerformed

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
// TODO add your handling code here:
     //String sql="UPDATE producto SET nombre_producto = '"+txtNmbre.getText()+"', precio_producto = '"+txtPre.getText()+"',descripcion_producto ='"+txtDes.getText()+"',Stock_producto = '"+txtStock.getText()+"' WHERE id_producto = '"+txtIDprod.getText()+"'"; 
          
    ArrayList<DMateriaPrimaEnProductos> arrMpp = new ArrayList();
    
        for(int x =0; x<tablaProd1.getRowCount(); x++){
            
            LMateriaPrima funcMatPrimAux = new LMateriaPrima();
            DefaultTableModel mod=funcMatPrimAux.mostrarMin((String)(tablaProd1.getValueAt(0, 1)));
            int cantidadEnStock=(Integer.parseInt((String)(mod.getValueAt(0, 2))));
         
            LMateriaPrima funcMatPrim = new LMateriaPrima();
            DmateriaPrima dtsMatPrim = new DmateriaPrima();
            String id = tablaProd1.getValueAt(x, 0).toString();
            dtsMatPrim.setID(Integer.parseInt(id));
            dtsMatPrim.setProducto((String)(tablaProd1.getValueAt(x, 1)));
            
            try {
                dtsMatPrim.setCantidad(cantidadEnStock-(Integer.parseInt((String)(tablaProd1.getValueAt(x, 2)))));
            } catch (Exception e) {
                dtsMatPrim.setCantidad(cantidadEnStock-((Integer)(tablaProd1.getValueAt(x, 2))));
            }
            dtsMatPrim.setProveedor((String)(tablaProd1.getValueAt(x, 3)));
            dtsMatPrim.setUnidad_medidad((String)(tablaProd1.getValueAt(x, 4)));
            dtsMatPrim.setCategoria((String)(tablaProd1.getValueAt(x, 5)));
            dtsMatPrim.setDescripcion((String)(tablaProd1.getValueAt(x, 6)));
            
            
            dtsMatPrim.setPrecio((Double) tablaProd1.getValueAt(x, 7));
            dtsMatPrim.setFecha_compra((String)(tablaProd1.getValueAt(x, 8)));
            dtsMatPrim.setFecha_cad((String)(tablaProd1.getValueAt(x, 9)));
            
            //funcMatPrim.editar(dtsMatPrim);
            
            
            /*
            String  material=(String)tablaProd.getValueAt(filasel, 0);
             String  stock=(String)tablaProd.getValueAt(filasel, 1);
             DefaultTableModel modeloAux = (DefaultTableModel) tablaProd1.getModel();
             modeloAux.addRow(new Object[]{material,stock});
            */
            
            DMateriaPrimaEnProductos dmpp = new DMateriaPrimaEnProductos();
            dmpp.setIdProducto(txtIDprod.getText());
            dmpp.setIdMateriaPrima(dtsMatPrim.getID());
            //System.out.println("id- "+dmpp.getIdMateriaPrima());
            dmpp.setDescripcionMP(dtsMatPrim.getDescripcion());
            try {
                dmpp.setCantidadMP((Integer.parseInt((String)(tablaProd1.getValueAt(x, 2)))));
            } catch (Exception e) {
                dmpp.setCantidadMP(((Integer)(tablaProd1.getValueAt(x, 2))));
            }
            
            arrMpp.add(dmpp);
                        
        }
     Dproducto dts = new Dproducto();
     Lproducto func = new Lproducto();
     dts.setCodigo(txtIDprod.getText());
     dts.setCategoria(cboCategoria.getItemAt(cboCategoria.getSelectedIndex()));
     dts.setDescripcion(txtDes.getText());
     dts.setNombre(txtNmbre.getText());
     dts.setPrecio(txtPre.getText());
     //dts.setStock(txtStock.getText());
     dts.setMateriasPrimas(arrMpp);
     
    LMateriaPrimaEnProductos lmpp = new LMateriaPrimaEnProductos();
     
    try {
        //PreparedStatement pst = cn.prepareStatement(sql);
        //pst.executeUpdate();
        if(func.editar(dts)){
            for(int x=0; x<arrMpp.size(); x++){
                //System.out.println("id- "+arrMpp.get(x).getIdMateriaPrima());
                lmpp.editar(arrMpp.get(x));
            }
            
            for(int y=0; y<mppBorrar.size(); y++){
                DMateriaPrimaEnProductos dmppEliminar = new DMateriaPrimaEnProductos();
                dmppEliminar.setIdMateriaPrima(mppBorrar.get(y));
                dmppEliminar.setIdProducto(txtIDprod.getText());
                lmpp.eliminar(dmppEliminar);
            }
            JOptionPane.showMessageDialog(null, "Actualizado");
            mostrar("");
            bloquear();
            limpiar();
        }
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
    }
}//GEN-LAST:event_btnModificarActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        // TODO add your handling code here:
        
        ((DefaultTableModel)tablaProd1.getModel()).setRowCount(0);
    try {
        int filaMod=tablaProductos.getSelectedRow();
        if(filaMod==-1)
        {
        JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
        }
        else
        {
            btnModificar.setEnabled(true);
            String cod=(String)tablaProductos.getValueAt(filaMod, 0);
            desbloquear();
            btnGuardar.setEnabled(false);
            BuscarProductoEditar(cod);
        }
    } catch (Exception e) {
    }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnAgregarMatPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMatPrimActionPerformed
        // TODO add your handling code here:
        int filasel= tablaProd.getSelectedRow();
       try {
           if(filasel==-1)
           {
            JOptionPane.showMessageDialog(null, "Seleccione algun dato");
           }
           else
           {
             DmateriaPrima dtsMatPrim = new DmateriaPrima();
             
            dtsMatPrim.setID(Integer.parseInt((String)(tablaProd.getValueAt(filasel, 0))));
            dtsMatPrim.setProducto((String)(tablaProd.getValueAt(filasel, 1)));
            dtsMatPrim.setCantidad((Integer.parseInt((String)(tablaProd.getValueAt(filasel, 2)))));
            dtsMatPrim.setProveedor((String)(tablaProd.getValueAt(filasel, 3)));
            dtsMatPrim.setUnidad_medidad((String)(tablaProd.getValueAt(filasel, 4)));
            dtsMatPrim.setCategoria((String)(tablaProd.getValueAt(filasel, 5)));
            dtsMatPrim.setDescripcion((String)(tablaProd.getValueAt(filasel, 6)));
            dtsMatPrim.setPrecio((Double.parseDouble((String)(tablaProd.getValueAt(filasel, 7)))));
            dtsMatPrim.setFecha_compra((String)(tablaProd.getValueAt(filasel, 8)));
            dtsMatPrim.setFecha_cad((String)(tablaProd.getValueAt(filasel, 9)));
            
             DefaultTableModel modeloAux = (DefaultTableModel) tablaProd1.getModel();
             modeloAux.addRow(new Object[]{dtsMatPrim.getID(),dtsMatPrim.getProducto(),dtsMatPrim.getCantidad(), dtsMatPrim.getProveedor(),dtsMatPrim.getUnidad_medidad(),dtsMatPrim.getCategoria(),dtsMatPrim.getDescripcion(),dtsMatPrim.getPrecio(),dtsMatPrim.getFecha_compra(),dtsMatPrim.getFecha_cad()});
             //tablaProd1.setValueAt(material, tablaProd1.getRowCount(), 0);
           }
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAgregarMatPrimActionPerformed

    private void btnLimpiarMatPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMatPrimActionPerformed
        // TODO add your handling code here:
    ((DefaultTableModel)tablaProd1.getModel()).setRowCount(0);
    }//GEN-LAST:event_btnLimpiarMatPrimActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int filasel= tablaProductos.getSelectedRow();
       try {
           if(filasel==-1)
           {
            JOptionPane.showMessageDialog(null, "Seleccione algun dato");
           }
           else
           {
             String  cod=(String)tablaProductos.getValueAt(filasel, 0);
             //String eliminarSQL="DELETE FROM producto_final WHERE id_producto = '"+cod+"'";
             try {
             /*PreparedStatement pst  = cn.prepareStatement(eliminarSQL);
          pst.executeUpdate();*/
            Dproducto dts = new Dproducto();
            Lproducto func = new Lproducto();
            dts.setCodigo(cod);
            if(func.eliminar(dts)){
                JOptionPane.showMessageDialog(null, "Borrado");
                mostrar("");
            }
            } 
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }
           }
           } 
       catch (Exception e)
       {
       }
       
    bloquear();
    limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEliminarMatPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMatPrimActionPerformed
        // TODO add your handling code here:
        int filasel= tablaProd1.getSelectedRow();
        
        mppBorrar.add(((Integer)(tablaProd1.getValueAt(filasel, 0))));
                
        ((DefaultTableModel)tablaProd1.getModel()).removeRow(filasel);
        
    }//GEN-LAST:event_btnEliminarMatPrimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMatPrim;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarMatPrim;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarMatPrim;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscarProd;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JMenuItem mnactualizar;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JTable tablaProd;
    private javax.swing.JTable tablaProd1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProd;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtIDprod;
    private javax.swing.JTextField txtNmbre;
    private javax.swing.JTextField txtPre;
    // End of variables declaration//GEN-END:variables
   conexion cc= new conexion();
   Connection cn=cc.conectar();
}
