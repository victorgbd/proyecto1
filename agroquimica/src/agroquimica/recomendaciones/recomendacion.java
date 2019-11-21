/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.recomendaciones;

import agroquimica.Funciones;
import agroquimica.Menu;
import java.awt.Color;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class recomendacion extends javax.swing.JFrame {

    public recomendacion(String enfe) {
        initComponents();
        recomendacion(enfe);
    }
    private int x, y;

    private void recomendacion(String enfermedad) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        String sql = "SELECT codenfer from enfermedad where descripcion=" + "'" + enfermedad + "'";

        ResultSet rs = Funciones.consulta(sql);
        try {
            rs.next();
            int codenf = rs.getInt("codenfer");
            sql = "SELECT  p.codproducto,p.descripcion,p.preciovent,pe.cantidad from productovsefermedad as pe"
                    + " INNER JOIN enfermedad as enf on pe.codenfer=" + codenf + " "
                    + "INNER JOIN producto as p on pe.codprod=p.codproducto";
            rs = Funciones.consulta(sql);

            while (rs.next()) {
                // agrega los datos de la consulta al modelo de la tabla
                modelo.addRow(new Object[]{
                    rs.getString("codproducto"),
                    rs.getString("descripcion"),
                    rs.getString("preciovent"),
                    rs.getString("cantidad"),});
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "llenar tabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        enfermedad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        minimizar = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelPrincipal.setBackground(new java.awt.Color(0, 111, 152));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelPrincipal.add(enfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 93, 164, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Productos Recomendados");
        PanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 31, 194, 52));

        jLabel2.setText("Enfermedad:");
        PanelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 96, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codpro", "nombre", "precio", "cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tabla);

        PanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 146, 424, 171));

        jButton1.setText("Agregar compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 159, -1, -1));

        minimizar.setBackground(new java.awt.Color(255, 255, 255));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("_");
        minimizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
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
        PanelPrincipal.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 30, 30));

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setText("X");
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
        PanelPrincipal.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 30, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
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
        PanelPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean f = true;
        for (int j = 0; j < tabla.getRowCount(); j++) {
            for (int i = 0; i < Menu.jTable1.getRowCount(); i++) {
                if (Menu.jTable1.getValueAt(i, 0).toString().equals(tabla.getValueAt(j, 0))) {
                    int cant = Integer.parseInt(Menu.jTable1.getValueAt(i, 3).toString());
                    cant += Integer.parseInt(tabla.getValueAt(j, 3).toString());
                    Menu.jTable1.setValueAt(cant, i, 3);
                    f = false;
                }
            }
        }
        if (f) {
            String[] dato = new String[4];
            DefaultTableModel tabladet = (DefaultTableModel) Menu.jTable1.getModel();
            for (int i = 0; i < tabla.getRowCount(); i++) {
                dato[0] = tabla.getValueAt(i, 0).toString();
                dato[1] = tabla.getValueAt(i, 1).toString();
                dato[2] = tabla.getValueAt(i, 2).toString();
                dato[3] = tabla.getValueAt(i, 3).toString();
                tabladet.addRow(dato);
            }
            Menu.jTable1.setModel(tabladet);
        }
        double total = 0;
        for (int i = 0; i < Menu.jTable1.getRowCount(); i++) {
            int cant = Integer.parseInt(Menu.jTable1.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(Menu.jTable1.getValueAt(i, 2).toString());
            total += (cant*precio);
        }
        Menu.jlTotal.setText(total+"");
        this.setVisible(false);
        Menu.jPanel2.removeAll();
        Menu.jPanel2.repaint();
        Menu.jPanel2.revalidate();
        Menu.jPanel2.add(Menu.jPanel5);
        Menu.jPanel2.repaint();
        Menu.jPanel2.revalidate();
        int posicion = Menu.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
        } else {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        this.setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_jLabel6MouseDragged

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_jLabel6MousePressed

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered
        minimizar.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited
        minimizar.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_minimizarMouseExited

    private void minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizarMousePressed

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_salirMouseExited

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        this.dispose();
    }//GEN-LAST:event_salirMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    public javax.swing.JTextField enfermedad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
