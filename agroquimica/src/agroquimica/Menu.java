/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

import agroquimica.ventas.buscar_productos;
import agroquimica.recomendaciones.recomendacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    private File es = null;
    private JFileChooser file;
    private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    private boolean animacion=true;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbRecomendacion = new javax.swing.JLabel();
        lbVentas = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Recomendacion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txruta = new javax.swing.JTextField();
        seleccionar = new javax.swing.JButton();
        evaluar = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(19, 19, 123));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        lbRecomendacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbRecomendacion.setText("Recomendacion");
        lbRecomendacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRecomendacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbRecomendacionMouseReleased(evt);
            }
        });

        lbVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVentas.setText("Ventas");
        lbVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbVentasMouseReleased(evt);
            }
        });

        lbInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbInicio.setText("Inicio");
        lbInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbInicioMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRecomendacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbRecomendacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, -1, 560));

        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, "card3");

        Recomendacion.setBackground(new java.awt.Color(0, 0, 51));
        Recomendacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("selecciona una imagen:");
        Recomendacion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));
        Recomendacion.add(txruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 202, -1));

        seleccionar.setBackground(new java.awt.Color(255, 255, 255));
        seleccionar.setText("ua");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });
        Recomendacion.add(seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 27, -1));

        evaluar.setBackground(new java.awt.Color(255, 255, 255));
        evaluar.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        evaluar.setText("evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });
        Recomendacion.add(evaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        imagen.setBackground(new java.awt.Color(255, 255, 255));
        imagen.setForeground(new java.awt.Color(255, 255, 255));
        imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        imagen.setOpaque(true);
        Recomendacion.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 202, 172));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        Recomendacion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 439, 89));

        jPanel2.add(Recomendacion, "card2");

        jButton2.setText("realizar venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setDoubleBuffered(true);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jButton2)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap(195, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel5, "card4");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 90, 800, 560));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\victor\\Desktop\\Recursos\\Recursos\\img\\menu.png")); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbRecomendacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRecomendacionMouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.Recomendacion);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mover el panel de menu con la animacion
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_lbRecomendacionMouseReleased

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        //mover el panel de menu con la animacion
        Menu.jPanel3.setVisible(true);
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, png y gif", "jpg", "png", "gif");
        file.setFileFilter(filtro);
        file.setCurrentDirectory(es);
        file.showOpenDialog(this);

        if (file.getSelectedFile() != null) {
            es = file.getSelectedFile();
            this.txruta.setText(es.getAbsolutePath());
            rsscalelabel.RSScaleLabel.setScaleLabel(imagen, es.getAbsolutePath());
            int posicion = Menu.jPanel3.getX();
            if (posicion < -1) {
                Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                Menu.jPanel3.setVisible(false);
            }
            

        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        try {
            if (!this.txruta.getText().equals("")) {
                URL url = new URL("http://127.0.0.1:5000/upload/" + this.txruta.getText());//your url i.e fetch data from .
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                String resultados = "";
                while ((output = br.readLine()) != null) {
                    resultados += output;
                }
                resultados = resultados.replace("{", "");
                resultados = resultados.replace("}", "");
                resultados = resultados.replace(":", "  porciento de acierto: ");
                resultados = resultados.replace("\"", "");
                String[] resul = resultados.split(",");
                this.jList1.setListData(resul);
                conn.disconnect();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception in NetClientGet:- " + e);
        }
    }//GEN-LAST:event_evaluarActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (jList1.getSelectedValue() != null) {
            String[] r = jList1.getSelectedValue().split(" porciento de acierto: ");
            int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
            if (opcion == JOptionPane.YES_OPTION) {
                recomendacion obj = new recomendacion(r[0]);
                obj.enfermedad.setText(r[0]);
                obj.setLocationRelativeTo(jPanel2);
                obj.setVisible(true);
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (jList1.getSelectedValue() != null) {
                String[] r = jList1.getSelectedValue().split(" porciento de acierto: ");
                int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
                if (opcion == JOptionPane.YES_OPTION) {
                    recomendacion obj = new recomendacion(r[0]);
                    obj.enfermedad.setText(r[0]);
                    obj.setLocationRelativeTo(jPanel2);
                    obj.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void lbInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInicioMouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.jPanel4);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mover el panel de menu con la animacion
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_lbInicioMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.jTable1.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "agregar una compra");
        } else {
            try {
                //ejecuto el procedimento almacenado de factura que retorna el numero de la factura
                Statement st = cn.createStatement();
                ResultSet res = st.executeQuery("call sp_factura(1,1,1,1,1)");
                res.next();
                int numfac = res.getInt(1);
                String sql = "call sp_detallefactura(?,?,?,?)";
                int contador = 0;
                //JOptionPane.showMessageDialog(null, ""+jTable1.getRowCount());
                //recorre cada uno de los productos de jtable y lo agrega a la tabla detalle factura
                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    int opcion = 0;
                    try {
                        ps = cn.prepareStatement(sql);
                        ps.setInt(1, numfac);
                        ps.setInt(2, Integer.parseInt(this.jTable1.getValueAt(i, 0).toString()));
                        ps.setInt(3, Integer.parseInt(this.jTable1.getValueAt(i, 3).toString()));
                        ps.setDouble(4, Double.parseDouble(this.jTable1.getValueAt(i, 2).toString()));
                        res = ps.executeQuery();
                        res.next();
                        opcion = res.getInt(1);
                    } catch (SQLException ex) {
                    }

                    if (opcion != 0) {
                        contador++;
                    }
                }
                //si no encuentra nada no presenta el mensaje
                if (contador == this.jTable1.getRowCount()) {
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                    JOptionPane.showMessageDialog(null, "transaccion realizada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar_productos obj = new buscar_productos();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVentasMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.jPanel5);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_lbVentasMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Redneu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Recomendacion;
    private javax.swing.JButton evaluar;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbRecomendacion;
    private javax.swing.JLabel lbVentas;
    private javax.swing.JButton seleccionar;
    private javax.swing.JTextField txruta;
    // End of variables declaration//GEN-END:variables
}
