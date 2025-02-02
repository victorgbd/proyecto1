 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

/**
 *
 * @author Felix Artiles
 */
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Empleados extends javax.swing.JFrame {

    public static boolean reg_emple = false;
     private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    public static int cod_usu;
    private int x, y;
    /**
     * Creates new form Empleados
     */
    
    public Empleados() {
      
        initComponents();
       
        Funciones.llenar_combo(combo_puesto,"tipo_de_empleado","descripcion");
         Funciones.llenar_combo(combo_dias,"tipo_horario","descripcion");
        Funciones.llenar_combo(combo_horario_entrada,"horario","entrada");
         Funciones.llenar_combo(combo_horario_salida,"horario","salida");
         Funciones.llenar_combo(combo_telefono,"tipo_telefono","descripcion");
         
        
    }
    String sql = null;
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        combo_puesto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        combo_dias = new javax.swing.JComboBox<>();
        txt_usuario = new javax.swing.JTextField();
        combo_horario_salida = new javax.swing.JComboBox<>();
        combo_telefono = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        combo_documento = new javax.swing.JComboBox<>();
        btn_salir = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        combo_horario_entrada = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 155, 151, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Puesto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 215, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 212, 236, -1));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 115, -1));

        combo_puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(combo_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 212, 104, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Días");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 261, -1, -1));

        combo_dias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(combo_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 258, 103, -1));
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 181, 151, -1));

        combo_horario_salida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(combo_horario_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        combo_telefono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(combo_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 101, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 258, 236, -1));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 117, 151, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, -1));

        combo_documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Pasaporte" }));
        jPanel1.add(combo_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 155, 104, -1));

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 358, -1, -1));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 358, -1, -1));

        combo_horario_entrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(combo_horario_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("/");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Horario");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dirección");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 215, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 187, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

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
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

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
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jLabel13.setOpaque(true);
        jLabel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel13MouseDragged(evt);
            }
        });
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed
    
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        boolean encontrado = false;
        Registrar_usuario form = new Registrar_usuario();
               
        if(txt_usuario.getText().isEmpty() || txtcedula.getText().isEmpty() || txt_correo.getText().isEmpty() ||  txt_telefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
        }else{
            try {
                int cod_dir = 0,cod_tel=0,cod_docu=0,cod_per=0,horario=1;
                
                Funciones.validar_correo(txt_correo);
                encontrado = Funciones.buscar_usuario(txt_usuario.getText());
                
                if(encontrado){
                    //llenar tabla direccion
                     sql = "call sp_direccion(?)";
                    ps = cn.prepareStatement(sql);
                    ps.setString(1, txt_direccion.getText());
                    ResultSet rs =ps.executeQuery();
                    rs.next();
                    cod_dir = rs.getInt(1);
                    //llenar tabla telefono
                    sql = "call sp_telefono(?,?)";
                    ps = cn.prepareStatement(sql);
                     ps.setString(1, txt_telefono.getText());
                      ps.setInt(2,  1+combo_telefono.getSelectedIndex());
                       rs =ps.executeQuery();
                    rs.next();
                    cod_tel = rs.getInt(1);
                    //llenar tabla documento
                    sql = "call sp_documento(?,?)";
                    ps = cn.prepareStatement(sql);
                     ps.setString(1, txtcedula.getText());
                      ps.setString(2,  combo_documento.getSelectedItem().toString());
                       rs =ps.executeQuery();
                    rs.next();
                    cod_docu = rs.getInt(1);
                    //llenar tabla persona
                    sql = "call sp_persona(?,?,?,?)";
                     ps = cn.prepareStatement(sql);
                     ps.setString(1, txt_nombre.getText());
                     ps.setString(2, txt_apellido.getText());
                      ps.setInt(3,  cod_dir);
                      ps.setInt(4,  cod_docu);
                       rs =ps.executeQuery();
                    rs.next();
                    cod_per = rs.getInt(1);
                    //tabla horario
                    
                    
                    //llenar tabla empleado
                     sql = "SELECT codusuario from usuario WHERE nickname ='"+txt_usuario.getText()+"'";
        
                    rs = Funciones.consulta(sql);
                    rs.next();
            
            
                    cod_usu = rs.getInt(1);;
                    sql = "call sp_empleado(?,?,?,?,?,?)";
                     ps = cn.prepareStatement(sql);
                     ps.setString(1, txt_correo.getText());
                     ps.setInt(2, 1+combo_puesto.getSelectedIndex());
                      ps.setInt(3,  cod_per);
                      ps.setInt(4,  cod_usu);
                      ps.setInt(5,  cod_tel);
                      ps.setInt(6,  horario);
                       rs =ps.executeQuery();
                    
                    JOptionPane.showMessageDialog(null, "El empleado ha sido creado correctamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "Debe crear un usuario para el empleado.","Empleado",JOptionPane.INFORMATION_MESSAGE);
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);
                    reg_emple = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(txt_telefono.getText().length()==3 ||txt_telefono.getText().length()==7){
            txt_telefono.setText(txt_telefono.getText()+"-");
        }
        if(!Character.isDigit(c) || txt_telefono.getText().length() > 11){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        
        if(txtcedula.getText().length()==3 ||txtcedula.getText().length()==11){
            txtcedula.setText(txtcedula.getText()+"-");
        }
        if(!Character.isDigit(c) || txtcedula.getText().length() > 12){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void jLabel13MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jLabel13MouseDragged

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel13MousePressed

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
    void limpiar(){
        txt_correo.setText("");
        txt_direccion.setText("");
        txt_apellido.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_usuario.setText("");
        txtcedula.setText("");
        txtcedula.requestFocus();
    }
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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> combo_dias;
    private javax.swing.JComboBox<String> combo_documento;
    private javax.swing.JComboBox<String> combo_horario_entrada;
    private javax.swing.JComboBox<String> combo_horario_salida;
    private javax.swing.JComboBox<String> combo_puesto;
    private javax.swing.JComboBox<String> combo_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel salir;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    public static javax.swing.JTextField txt_usuario;
    private javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
