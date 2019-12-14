/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.ventas;

import agroquimica.ConexionBD;
import agroquimica.Funciones;
import agroquimica.Menu;
import static agroquimica.Menu.txt_cliente;
import static agroquimica.Menu.txt_empleado;
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
    double cuota = 0;
    float interes = (float) 0.1;
    DecimalFormat df = new DecimalFormat("###,###.##");

    public int numfac;
    public double total;
    public String tipfact;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_cuota = new javax.swing.JComboBox<>();
        txt_pagos = new javax.swing.JTextField();
        txt_monto_total = new javax.swing.JTextField();
        txt_factura = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Factura a credito");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Monto Total:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cuotas:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pagos:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Factura:");

        combo_cuota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "12", "18", "24" }));
        combo_cuota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_cuotaItemStateChanged(evt);
            }
        });

        txt_pagos.setEditable(false);

        txt_monto_total.setEditable(false);
        txt_monto_total.setText("18,452.25");
        txt_monto_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_monto_totalActionPerformed(evt);
            }
        });

        txt_factura.setEditable(false);
        txt_factura.setText("5");

        txt_cliente.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("meses");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Fecha");

        lb_fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_fecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cliente)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_pagos)
                                        .addComponent(txt_factura)
                                        .addComponent(txt_monto_total, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combo_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addComponent(lb_fecha))
                                .addGap(0, 41, Short.MAX_VALUE)))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lb_fecha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_monto_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

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
        // TODO add your handling code here:
        String sql = "call sp_cuota(?,?,?)";

        try {
            ps = cn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txt_factura.getText()));
            ps.setDouble(2, Double.parseDouble(txt_pagos.getText().replace(",", "")));

            ps.setInt(3, Integer.parseInt(combo_cuota.getSelectedItem().toString()));
            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Transaccion realizada correctamente", "Cuota", JOptionPane.INFORMATION_MESSAGE);

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
    private javax.swing.JLabel lb_fecha;
    public static javax.swing.JTextField txt_cliente;
    public static javax.swing.JTextField txt_factura;
    public static javax.swing.JTextField txt_monto_total;
    public javax.swing.JTextField txt_pagos;
    // End of variables declaration//GEN-END:variables
}
