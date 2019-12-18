/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.ventas;

import agroquimica.ConexionBD;
import agroquimica.Funciones;
import agroquimica.Menu;
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Felix Artiles
 */
public class factura_credito extends javax.swing.JFrame {
    public factura_credito(int numfac,double balance) {
        initComponents();
        txt_cliente.setText(Menu.txt_cliente.getText());
        txt_factura.setText(String.valueOf(numfac));
        factura_credito.txt_monto_total.setText(String.valueOf(df.format(balance)));
        lb_fecha.setText(Funciones.fecha());
        cuota();
    }
    private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    private int x,y;
    double cuota = 0;
    float interes = (float) 0.1;
    DecimalFormat df = new DecimalFormat("###,###.##");

    public int numfac;
    public double total;
    public String tipfact;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_pagos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_cuota = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_monto_total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        whitelb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(19, 19, 123));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        txt_pagos.setEditable(false);
        jPanel1.add(txt_pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 267, 88, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pagos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 267, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cuotas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 229, -1, -1));

        combo_cuota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "12", "18", "24" }));
        combo_cuota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_cuotaItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_cuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 229, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("meses");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 229, -1, -1));

        txt_monto_total.setEditable(false);
        txt_monto_total.setText("18,452.25");
        txt_monto_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_monto_totalActionPerformed(evt);
            }
        });
        jPanel1.add(txt_monto_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 191, 88, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto Total:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 191, -1, -1));

        txt_cliente.setEditable(false);
        jPanel1.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 153, 244, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 153, -1, -1));

        lb_fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lb_fecha.setText("Fecha");
        jPanel1.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 118, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 118, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Factura:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 67, -1, -1));

        txt_factura.setEditable(false);
        txt_factura.setText("5");
        jPanel1.add(txt_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 67, 88, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Factura a credito");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 34, -1, -1));

        minimizar.setBackground(new java.awt.Color(255, 255, 255));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("_");
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
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 30, 30));

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
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, 30));

        whitelb.setBackground(new java.awt.Color(255, 255, 255));
        whitelb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        whitelb.setOpaque(true);
        whitelb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                whitelbMouseDragged(evt);
            }
        });
        whitelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whitelbMousePressed(evt);
            }
        });
        jPanel1.add(whitelb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 346));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_cuotaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_cuotaItemStateChanged
        cuota();
    }//GEN-LAST:event_combo_cuotaItemStateChanged

    private void txt_monto_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_monto_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_monto_totalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String sql = "call sp_cuota(?,?,?)";

        try {
            ps = cn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txt_factura.getText()));
            ps.setDouble(2, Double.parseDouble(txt_pagos.getText().replace(",", "")));

            ps.setInt(3, Integer.parseInt(combo_cuota.getSelectedItem().toString()));
            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Transaccion realizada correctamente", "Cuota", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            //reporte de jasperreport
            JasperReport reporte = null;
            String ruta = getClass().getResource("/Reportes/Factura.jasper").toString();
            ruta = ruta.replace("file:", "");
            Map parametro = new HashMap();
            parametro.put("numerodefactura", numfac);
            parametro.put("Totalfactura", total);
            parametro.put("TipoFactura", tipfact);
            parametro.put("cliente", Menu.txt_cliente.getText());
            parametro.put("vendedor", Menu.txt_empleado.getText());
            try {
                reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, cn);
                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            //limpiamos pantalla
            DefaultTableModel modelo = (DefaultTableModel) Menu.jTable1.getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            Menu.jlTotal.setText("");
            Menu.jCombotipofactura.setSelectedIndex(-1);
            Menu.txt_empleado.setText("");
            Menu.txt_cliente.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(factura_credito.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void whitelbMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whitelbMouseDragged
        this.setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_whitelbMouseDragged

    private void whitelbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whitelbMousePressed
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_whitelbMousePressed

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
        this.setVisible(false);
    }//GEN-LAST:event_salirMousePressed
    public void cuota(){
        double deuda = Double.parseDouble(txt_monto_total.getText().replace(",", ""));
        int meses = Integer.parseInt(combo_cuota.getSelectedItem().toString());
        if (meses < 12 && deuda < 100000) {
            interes = (float) ((float) 0.02 + 0.01);
        } else if (meses < 12 && deuda > 100000) {
            interes = (float) ((float) 0.02 + 0.03);
        } else if (meses >= 12 && deuda < 100000) {
            interes = (float) ((float) 0.04 + 0.01);
        } else if (meses >= 12 && deuda > 100000) {
            interes = (float) ((float) 0.04 + 0.03);
        }

        cuota = (interes * deuda) / (1 - Math.pow((1 + interes), -meses));
        
        txt_pagos.setText(df.format(cuota));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_cuota;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel salir;
    public static javax.swing.JTextField txt_cliente;
    public static javax.swing.JTextField txt_factura;
    public static javax.swing.JTextField txt_monto_total;
    public javax.swing.JTextField txt_pagos;
    private javax.swing.JLabel whitelb;
    // End of variables declaration//GEN-END:variables
}
