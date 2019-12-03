/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.ventas;

import agroquimica.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Felix Artiles
 */
public class Pago_factura extends javax.swing.JFrame {

    /**
     * Creates new form Pago_factura
     */
    public Pago_factura() {
        initComponents();
    }

    private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    DecimalFormat df = new DecimalFormat("#.00");
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        porciento = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        txt_factura = new javax.swing.JTextField();
        txt_deuda = new javax.swing.JTextField();
        txt_balance = new javax.swing.JTextField();
        txt_pago = new javax.swing.JTextField();
        btn_pagar = new javax.swing.JButton();
        radio_50 = new javax.swing.JRadioButton();
        radio_100 = new javax.swing.JRadioButton();
        check_pago_porcentaje = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cuentas por cobrar");

        jLabel1.setText("Pagar factura a credito");

        jLabel2.setText("Cliente");

        jLabel3.setText("Factura");

        jLabel4.setText("Total Deuda");

        jLabel5.setText("Balance pendiente");

        jLabel6.setText("Total a pagar");

        txt_cliente.setEditable(false);

        txt_deuda.setEditable(false);

        txt_balance.setEditable(false);

        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        porciento.add(radio_50);
        radio_50.setText("50%");
        radio_50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_50MouseClicked(evt);
            }
        });

        porciento.add(radio_100);
        radio_100.setText("100%");
        radio_100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_100MouseClicked(evt);
            }
        });

        check_pago_porcentaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_pago_porcentajeMouseClicked(evt);
            }
        });

        jLabel7.setText("Desea pagar?");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(btn_pagar))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_pago_porcentaje)
                                .addGap(18, 18, 18)
                                .addComponent(radio_50)
                                .addGap(18, 18, 18)
                                .addComponent(radio_100)))
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_factura)
                                .addComponent(txt_deuda)
                                .addComponent(txt_balance)
                                .addComponent(txt_pago, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(txt_cliente))
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_deuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radio_50)
                                    .addComponent(radio_100)))))
                    .addComponent(check_pago_porcentaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pagar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void limpiar(){
        txt_balance.setText("");
        txt_cliente.setText("");
        txt_deuda.setText("");
        txt_factura.setText("");
        txt_cliente.setText("");
    }
    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        // TODO add your handling code here:
        if(txt_factura.getText().isEmpty() || txt_pago.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe llenar los campos habilitados.");
            
        }else{
            if(Double.parseDouble(txt_pago.getText()) > Double.parseDouble(txt_balance.getText()) || Double.parseDouble(txt_pago.getText())<=0){
                JOptionPane.showMessageDialog(null, "El pago debe ser menor a "+txt_balance.getText()+"$RD y mayor a 0.00$RD", "Error de pago", JOptionPane.ERROR_MESSAGE);
                txt_pago.requestFocus();
                txt_pago.setText("");
            }else{
                String sql ="call sp_cobro_credito(?,?,?)";
                try {
                    ps = cn.prepareStatement(sql);
                    
                     ps.setInt(1, Integer.parseInt(txt_factura.getText()));
                    ps.setDouble(2, Double.parseDouble(df.format(Double.parseDouble(txt_balance.getText()))));
                    ps.setDouble(3, Double.parseDouble(df.format(Double.parseDouble(txt_pago.getText()))));
                    ResultSet rs = ps.executeQuery();
                    JOptionPane.showMessageDialog(null, "Pago realizado correctamente","Pago de factura",JOptionPane.INFORMATION_MESSAGE);
                    cuentas_pagar obj = new cuentas_pagar();
                   
                    obj.setVisible(true);
                    dispose();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Pago_factura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void radio_50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_50MouseClicked
        // TODO add your handling code here:
        if(radio_50.isSelected() && check_pago_porcentaje.isSelected()){
            
        txt_pago.setText(String.valueOf(String.format("%.2f", Double.parseDouble(txt_balance.getText()) * 0.50)));
          txt_pago.setEditable(false);
        }else{
            txt_pago.setEditable(true);
            
        }
    }//GEN-LAST:event_radio_50MouseClicked

    private void check_pago_porcentajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_pago_porcentajeMouseClicked
        // TODO add your handling code here:
        if(!check_pago_porcentaje.isSelected()){
            radio_50.setSelected(false);
            radio_100.setSelected(false);
            txt_pago.setEditable(true);
            txt_pago.setText(null);
            txt_pago.requestFocus();
        }
    }//GEN-LAST:event_check_pago_porcentajeMouseClicked

    private void radio_100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_100MouseClicked
        // TODO add your handling code here:
        if(radio_100.isSelected() && check_pago_porcentaje.isSelected()){
            
        txt_pago.setText(txt_balance.getText());
          txt_pago.setEditable(false);
        }else{
            txt_pago.setEditable(true);
            
        }
    }//GEN-LAST:event_radio_100MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pago_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pago_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pago_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pago_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pago_factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pagar;
    private javax.swing.JCheckBox check_pago_porcentaje;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.ButtonGroup porciento;
    private javax.swing.JRadioButton radio_100;
    private javax.swing.JRadioButton radio_50;
    public static javax.swing.JTextField txt_balance;
    public static javax.swing.JTextField txt_cliente;
    public static javax.swing.JTextField txt_deuda;
    public static javax.swing.JTextField txt_factura;
    public static javax.swing.JTextField txt_pago;
    // End of variables declaration//GEN-END:variables
}
