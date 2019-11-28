/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

import agroquimica.ventas.buscar_productos;
import agroquimica.recomendaciones.recomendacion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarIconos();
        cargaCombobox();
    }

    private void cargarIconos() {
        ImageIcon usuariosico = new ImageIcon(getClass().getResource("/iconos/iconfinder_group2_309041.png"));
        ImageIcon usuarioico1 = new ImageIcon(usuariosico.getImage().getScaledInstance(lbregistrar_usuarios.getWidth(), lbregistrar_usuarios.getHeight(), Image.SCALE_DEFAULT));
        lbregistrar_usuarios.setIcon(usuarioico1);
        ImageIcon consultaRico = new ImageIcon(getClass().getResource("/iconos/81088.png"));
        ImageIcon consultaRico1 = new ImageIcon(consultaRico.getImage().getScaledInstance(consult_receta.getWidth(), consult_receta.getHeight(), Image.SCALE_DEFAULT));
        consult_receta.setIcon(consultaRico1);
        ImageIcon consultaEico = new ImageIcon(getClass().getResource("/iconos/subir.png"));
        ImageIcon consultaEico1 = new ImageIcon(consultaEico.getImage().getScaledInstance(consult_enfermedad.getWidth(), consult_enfermedad.getHeight(), Image.SCALE_DEFAULT));
        consult_enfermedad.setIcon(consultaEico1);
    }

    private void cargaCombobox() {
        try {
            Statement st = cn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM `forma_de_pago`");
            while (res.next()) {
                jComboformapago.addItem(res.getString("descripcion"));
            }
            jComboformapago.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private File es = null;
    private JFileChooser file;
    private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    private int x, y;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbRecomendacion = new javax.swing.JLabel();
        lbVentas = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        lb_resigstrar = new javax.swing.JLabel();
        lbcerrarsesion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        inicio = new javax.swing.JPanel();
        recomendacionprincipal = new javax.swing.JPanel();
        consult_enfermedad = new javax.swing.JLabel();
        consult_receta = new javax.swing.JLabel();
        lbsubirimg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Recomendacion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txruta = new javax.swing.JTextField();
        seleccionar = new javax.swing.JButton();
        evaluar = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Recomendacion2 = new javax.swing.JPanel();
        enfermedad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        Ventas_ventana = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jCombotipofactura = new javax.swing.JComboBox<>();
        lbtipofact = new javax.swing.JLabel();
        jComboformapago = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Registrar = new javax.swing.JPanel();
        lbregistrar_usuarios = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlmenu = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jltab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(19, 19, 123));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel3.setAutoscrolls(true);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbRecomendacion.setBackground(new java.awt.Color(102, 102, 102));
        lbRecomendacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbRecomendacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRecomendacion.setText("Recomendacion");
        lbRecomendacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRecomendacion.setOpaque(true);
        lbRecomendacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRecomendacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRecomendacionMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbRecomendacionMouseReleased(evt);
            }
        });
        jPanel3.add(lbRecomendacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 190, 42));

        lbVentas.setBackground(new java.awt.Color(102, 102, 102));
        lbVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVentas.setText("Ventas");
        lbVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVentas.setOpaque(true);
        lbVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbVentasMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbVentasMouseReleased(evt);
            }
        });
        jPanel3.add(lbVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 42));

        lbInicio.setBackground(new java.awt.Color(102, 102, 102));
        lbInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInicio.setText("Inicio");
        lbInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbInicio.setOpaque(true);
        lbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbInicioMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbInicioMouseReleased(evt);
            }
        });
        jPanel3.add(lbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 42));

        lb_resigstrar.setBackground(new java.awt.Color(102, 102, 102));
        lb_resigstrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_resigstrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_resigstrar.setText("Registrar");
        lb_resigstrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_resigstrar.setOpaque(true);
        lb_resigstrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_resigstrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_resigstrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lb_resigstrarMouseReleased(evt);
            }
        });
        jPanel3.add(lb_resigstrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 42));

        lbcerrarsesion.setBackground(new java.awt.Color(102, 102, 102));
        lbcerrarsesion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcerrarsesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcerrarsesion.setText("Cerrar sesion");
        lbcerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbcerrarsesion.setOpaque(true);
        lbcerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbcerrarsesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbcerrarsesionMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbcerrarsesionMouseReleased(evt);
            }
        });
        jPanel3.add(lbcerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 42));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, -1, 510));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel2.setLayout(new java.awt.CardLayout());

        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(inicio, "card3");

        recomendacionprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consult_enfermedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        consult_enfermedad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                consult_enfermedadMouseReleased(evt);
            }
        });
        recomendacionprincipal.add(consult_enfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 150, 130));

        consult_receta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        consult_receta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                consult_recetaMouseReleased(evt);
            }
        });
        recomendacionprincipal.add(consult_receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 150, 130));

        lbsubirimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsubirimg.setText("Buscar recomendacion por imagen");
        recomendacionprincipal.add(lbsubirimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 200, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar Recomendacion");
        recomendacionprincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 160, -1));

        jPanel2.add(recomendacionprincipal, "card7");

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

        Recomendacion2.setBackground(new java.awt.Color(0, 0, 102));
        Recomendacion2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Recomendacion2.add(enfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 164, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Productos Recomendados");
        Recomendacion2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 31, 194, 52));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enfermedad:");
        Recomendacion2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

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
        jScrollPane3.setViewportView(tabla);

        Recomendacion2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 146, 424, 171));

        jButton3.setText("Agregar compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Recomendacion2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 159, -1, -1));

        jPanel2.add(Recomendacion2, "card8");

        Ventas_ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Realizar Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Ventas_ventana.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 114, -1, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Ventas_ventana.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 114, -1, -1));

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

        Ventas_ventana.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 151, 600, 251));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Total:");
        Ventas_ventana.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        jlTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Ventas_ventana.add(jlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 120, 30));

        jCombotipofactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        jCombotipofactura.setSelectedIndex(-1);
        Ventas_ventana.add(jCombotipofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 80, -1));

        lbtipofact.setText("Tipo de Factura:");
        Ventas_ventana.add(lbtipofact, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, 20));
        Ventas_ventana.add(jComboformapago, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 120, -1));

        jLabel8.setText("Forma de Pago:");
        Ventas_ventana.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, 20));

        jPanel2.add(Ventas_ventana, "card4");

        Registrar.setBackground(new java.awt.Color(255, 255, 255));
        Registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbregistrar_usuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbregistrar_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbregistrar_usuariosMouseReleased(evt);
            }
        });
        Registrar.add(lbregistrar_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 110));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registrar usuarios");
        Registrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, -1));

        jPanel2.add(Registrar, "card5");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 920, 510));

        jlmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/menu.png"))); // NOI18N
        jlmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlmenuMousePressed(evt);
            }
        });
        jPanel1.add(jlmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 40));

        salir.setBackground(new java.awt.Color(19, 19, 123));
        salir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 30, 30));

        minimizar.setBackground(new java.awt.Color(19, 19, 123));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 30, 30));

        jltab.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jltabMouseDragged(evt);
            }
        });
        jltab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jltabMousePressed(evt);
            }
        });
        jPanel1.add(jltab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbRecomendacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRecomendacionMouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.recomendacionprincipal);
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

    private void jlmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlmenuMousePressed
        //mover el panel de menu con la animacion
        Menu.jPanel3.setVisible(true);
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_jlmenuMousePressed

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
            r[0] = r[0].replace(" ", "");
            int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
            if (opcion == JOptionPane.YES_OPTION) {
//                recomendacion obj = new recomendacion(r[0]);
//                obj.enfermedad.setText(r[0]);
//                obj.setLocationRelativeTo(jPanel2);
//                obj.setVisible(true);
                this.enfermedad.setText(r[0]);
                recomendacion(r[0]);
                jPanel2.removeAll();
                jPanel2.repaint();
                jPanel2.revalidate();
                jPanel2.add(Recomendacion2);
                jPanel2.repaint();
                jPanel2.revalidate();
                int posicion = jPanel3.getX();
                if (posicion < -1) {
                    Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                } else {
                    Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                }
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (jList1.getSelectedValue() != null) {
                String[] r = jList1.getSelectedValue().split(" porciento de acierto: ");
                int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
                if (opcion == JOptionPane.YES_OPTION) {
                    this.enfermedad.setText(r[0]);
                    recomendacion(r[0]);
                    jPanel2.removeAll();
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    jPanel2.add(Recomendacion2);
                    jPanel2.repaint();
                    jPanel2.revalidate();
                    int posicion = jPanel3.getX();
                    if (posicion < -1) {
                        Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                    } else {
                        Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
                    }
                }
            }
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void lbInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInicioMouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.inicio);
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
                int codcli = 1;
                boolean estado = true;
                int tipfact = jCombotipofactura.getSelectedIndex();
                if (tipfact == 1) {
                    estado = false;
                }
                Statement st = cn.createStatement();
                ResultSet res = st.executeQuery("SELECT codformapag FROM `forma_de_pago` WHERE descripcion = '" + jComboformapago.getSelectedItem().toString() + "'");
                res.next();
                int codformpag = res.getInt(1);
                int codemp = 1;
                double balance = 0;
                double total = Double.parseDouble(jlTotal.getText());
                String sql = "call sp_factura(?,?,?,?,?,?,?)";
                ps = cn.prepareStatement(sql);
                ps.setInt(1, codcli);
                ps.setBoolean(2, estado);
                ps.setInt(3, tipfact);
                ps.setInt(4, codformpag);
                ps.setInt(5, codemp);
                ps.setDouble(6, balance);
                ps.setDouble(7, total);
                res = ps.executeQuery();
                res.next();
                int numfac = res.getInt(1);
                sql = "call sp_detallefactura(?,?,?,?)";
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
                    jlTotal.setText("");
                    jComboformapago.setSelectedIndex(-1);
                    jCombotipofactura.setSelectedIndex(-1);
                    JOptionPane.showMessageDialog(null, "transaccion realizada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar_productos obj = new buscar_productos();
        obj.setLocationRelativeTo(jPanel2);
        obj.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVentasMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(Ventas_ventana);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
        }
    }//GEN-LAST:event_lbVentasMouseReleased

    private void lbInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInicioMouseEntered
        lbInicio.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lbInicioMouseEntered

    private void lbInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInicioMouseExited
        lbInicio.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbInicioMouseExited

    private void lbVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVentasMouseEntered
        lbVentas.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lbVentasMouseEntered

    private void lbVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVentasMouseExited
        lbVentas.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbVentasMouseExited

    private void lbRecomendacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRecomendacionMouseEntered
        lbRecomendacion.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lbRecomendacionMouseEntered

    private void lbRecomendacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRecomendacionMouseExited
        lbRecomendacion.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbRecomendacionMouseExited

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        this.dispose();
    }//GEN-LAST:event_salirMousePressed

    private void minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizarMousePressed

    private void jltabMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jltabMouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jltabMouseDragged

    private void jltabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jltabMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jltabMousePressed

    private void lb_resigstrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resigstrarMouseEntered
        // TODO add your handling code here:
        lb_resigstrar.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lb_resigstrarMouseEntered

    private void lb_resigstrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resigstrarMouseExited
        // TODO add your handling code here:
        lb_resigstrar.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_resigstrarMouseExited

    private void lb_resigstrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resigstrarMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.Registrar);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = this.jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, this.jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, this.jPanel3);
        }
    }//GEN-LAST:event_lb_resigstrarMouseReleased

    private void lbcerrarsesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarsesionMouseEntered
        // TODO add your handling code here:
        lbcerrarsesion.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lbcerrarsesionMouseEntered

    private void lbcerrarsesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarsesionMouseExited
        // TODO add your handling code here:
        lbcerrarsesion.setBackground(new Color(102, 102, 102));

    }//GEN-LAST:event_lbcerrarsesionMouseExited

    private void lbcerrarsesionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarsesionMouseReleased
        // TODO add your handling code here:
        agroquimica.Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbcerrarsesionMouseReleased

    private void lbregistrar_usuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbregistrar_usuariosMouseReleased
        Registrar_usuario obj = new Registrar_usuario();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbregistrar_usuariosMouseReleased

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setBackground(new Color(19, 19, 123));
    }//GEN-LAST:event_salirMouseExited

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_salirMouseEntered

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered
        minimizar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited
        minimizar.setBackground(new Color(19, 19, 123));
    }//GEN-LAST:event_minimizarMouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
            total += (cant * precio);
        }
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Menu.jlTotal.setText(total + "");
        Menu.jPanel2.removeAll();
        Menu.jPanel2.repaint();
        Menu.jPanel2.revalidate();
        Menu.jPanel2.add(Ventas_ventana);
        Menu.jPanel2.repaint();
        Menu.jPanel2.revalidate();
        int posicion = Menu.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
        } else {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void consult_enfermedadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consult_enfermedadMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(Recomendacion);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = this.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
            Menu.jPanel3.setVisible(false);
        } else {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);

        }
    }//GEN-LAST:event_consult_enfermedadMouseReleased

    private void consult_recetaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consult_recetaMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(Recomendacion2);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = this.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
            jPanel3.setVisible(false);
        } else {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);

        }
    }//GEN-LAST:event_consult_recetaMouseReleased
    private void recomendacion(String enfermedad) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        String sql = "SELECT codenfer from enfermedad where descripcion=" + "'" + enfermedad + "'";

        ResultSet rs = Funciones.consulta(sql);
        try {
            rs.next();
            int codenf = rs.getInt("codenfer");
            sql = "SELECT  p.codproducto,p.descripcion,p.preciovent,pe.cantidad from productovsefermedad as pe"
                    + " INNER JOIN enfermedad as enf on pe.codenfer=enf.codenfer "
                    + "INNER JOIN producto as p on pe.codprod=p.codproducto where pe.codenfer=" + codenf;
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
    private javax.swing.JPanel Recomendacion2;
    private javax.swing.JPanel Registrar;
    public static javax.swing.JPanel Ventas_ventana;
    private javax.swing.JLabel consult_enfermedad;
    private javax.swing.JLabel consult_receta;
    public javax.swing.JTextField enfermedad;
    private javax.swing.JButton evaluar;
    private javax.swing.JLabel imagen;
    private static javax.swing.JPanel inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboformapago;
    private javax.swing.JComboBox<String> jCombotipofactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlmenu;
    private javax.swing.JLabel jltab;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbRecomendacion;
    private javax.swing.JLabel lbVentas;
    private javax.swing.JLabel lb_resigstrar;
    private javax.swing.JLabel lbcerrarsesion;
    private javax.swing.JLabel lbregistrar_usuarios;
    private javax.swing.JLabel lbsubirimg;
    private javax.swing.JLabel lbtipofact;
    private javax.swing.JLabel minimizar;
    private javax.swing.JPanel recomendacionprincipal;
    private javax.swing.JLabel salir;
    private javax.swing.JButton seleccionar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txruta;
    // End of variables declaration//GEN-END:variables
}
