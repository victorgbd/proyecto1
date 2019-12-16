/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.consultas;

import agroquimica.ConexionBD;
import agroquimica.Funciones;
import agroquimica.Menu;
import agroquimica.produccion.produccion_1;
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felix Artiles
 */
public class buscar_productos extends javax.swing.JFrame {

    /**
     * Creates new form buscar_productos
     */
    public buscar_productos() {
        initComponents();
        llenarTabla("");
    }
    private int x, y;

    private void llenarTabla(String dato) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        modelo.setColumnIdentifiers(new Object[]{
            "codigo", "Descripcion", "precio de venta", "Cantidad existente", "Unidad", "Codigo de Unidad"
        });

        String sql = "SELECT p.codproducto,p.descripcion,pu.precioventa,pu.cantext,u.descripcion as Unidad,pu.coduni from producto as p "
                + "INNER JOIN productovsunidad as pu on pu.codproducto=p.codproducto "
                + "INNER JOIN unidad as u on u.coduni=pu.coduni WHERE "
                + "p.descripcion LIKE  '%" + dato + "%'"
                + "OR p.codproducto LIKE  '%" + dato + "%'";
        if (jTextField1.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "No ha escrito", "busqueda", JOptionPane.ERROR_MESSAGE);
        } else {

        }
        ResultSet rs = Funciones.consulta(sql);
        try {
            while (rs.next()) {
                // agrega los datos de la consulta al modelo de la tabla
                modelo.addRow(new Object[]{
                    rs.getString("codproducto"),
                    rs.getString("descripcion"),
                    rs.getString("precioventa"),
                    rs.getString("cantext"),
                    rs.getString("Unidad"),
                    rs.getString("coduni")
                });
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "llenar tabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar productos");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(19, 19, 123));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 206, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Productos");
        PanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codpro", "nombre", "precio", "cantidad", "Unidad", "Codigo Uni"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tabla);

        PanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 590, 171));
        PanelPrincipal.add(jtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 126, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");
        PanelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        minimizar.setBackground(new java.awt.Color(255, 255, 255));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("_");
        minimizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        minimizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        minimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minimizar.setMaximumSize(new java.awt.Dimension(12, 22));
        minimizar.setMinimumSize(new java.awt.Dimension(12, 22));
        minimizar.setOpaque(true);
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizarMousePressed(evt);
            }
        });
        PanelPrincipal.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setText("X");
        salir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        salir.setOpaque(true);
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salirMousePressed(evt);
            }
        });
        PanelPrincipal.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 30, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jLabel6.setOpaque(true);
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel6MouseDragged(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        PanelPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        llenarTabla(jTextField1.getText());

    }//GEN-LAST:event_jTextField1KeyReleased

    public static void llenar_producto(){
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //se agregan los datos de la fila seleccionada a la tabla principal
        if (jtcantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe insertar la cantidad", "Producto", JOptionPane.ERROR_MESSAGE);
            jtcantidad.requestFocus();
        } else {
            try {
                if (Funciones.nombre_formulario.equals("produccion")) {

                    DefaultTableModel tabladet = (DefaultTableModel) produccion_1.Tabla.getModel();
                    //codigo
                    Funciones.dato[0] = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                    //producto
                    Funciones.dato[1] = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
                    //
                    Funciones.dato[2] = jtcantidad.getText();
                    Funciones.dato[3] = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
                    //
                    Funciones.dato[4] = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();

                    tabladet.addRow(Funciones.dato);
                    produccion_1.Tabla.setModel(tabladet);
                    dispose();
                } else {
                    boolean f = true;
                    for (int i = 0; i < Menu.jTable1.getRowCount(); i++) {
                        if (Menu.jTable1.getValueAt(i, 0).toString().equals(tabla.getValueAt(tabla.getSelectedRow(), 0))) {
                            int cant = Integer.parseInt(Menu.jTable1.getValueAt(i, 3).toString());
                            cant += Integer.parseInt(jtcantidad.getText());
                            Menu.jTable1.setValueAt(cant, i, 3);
                            f = false;
                        }
                    }
                    if (f) {
                        String[] dato = new String[6];
                        DefaultTableModel tabladet = (DefaultTableModel) Menu.jTable1.getModel();

                        dato[0] = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                        dato[1] = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
                        dato[2] = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
                        dato[3] = jtcantidad.getText();
                        dato[4] = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
                        dato[5] = tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
                        tabladet.addRow(dato);
                        Menu.jTable1.setModel(tabladet);
                    }
                    double total = 0;
                    for (int i = 0; i < Menu.jTable1.getRowCount(); i++) {
                        int cant = Integer.parseInt(Menu.jTable1.getValueAt(i, 3).toString());
                        double precio = Double.parseDouble(Menu.jTable1.getValueAt(i, 2).toString());
                        total += (cant * precio);
                    }
                    Menu.jlTotal.setText(total + "");
                    this.setVisible(false);
                    int posicion = Menu.jPanel3.getX();
                    if (posicion < -1) {
                        Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                        Menu.jPanel3.setVisible(false);
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered
        minimizar.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited
        minimizar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_minimizarMouseExited

    private void minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizarMousePressed

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_salirMouseExited

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        this.dispose();
    }//GEN-LAST:event_salirMousePressed

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jLabel6MouseDragged

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel6MousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtcantidad;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
