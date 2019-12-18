/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

import agroquimica.consultas.buscar_cliente;
import agroquimica.consultas.buscar_empleado;
import agroquimica.consultas.buscar_enfermedad;
import agroquimica.consultas.buscar_especie;
import agroquimica.consultas.buscar_planta;
import agroquimica.consultas.buscar_productos;
import agroquimica.produccion.Asignar_trabajos;
import agroquimica.produccion.Composicion_producto;
import agroquimica.produccion.produccion_1;
import agroquimica.ventas.Pedido;
import agroquimica.ventas.cuentas_pagar;
import agroquimica.ventas.factura_credito;
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
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
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
 * @author victor
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarIconos();
        Funciones.llenar_combo(jComboSuelo, "tipo_de_suelo", "descripcion");
        lb_fecha.setText(Funciones.fecha());

    }
    public int tipousuario = 1;
    public static int codemp = 0;
    public static int codclie = 0;
    DecimalFormat df = new DecimalFormat("###,###.##");

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
        ImageIcon cuentasxcico = new ImageIcon(getClass().getResource("/iconos/cuentasxcobrar.png"));
        ImageIcon cuentasxcico1 = new ImageIcon(cuentasxcico.getImage().getScaledInstance(lbcuenta_por_cobrar.getWidth(), lbcuenta_por_cobrar.getHeight(), Image.SCALE_DEFAULT));
        lbcuenta_por_cobrar.setIcon(cuentasxcico1);
        ImageIcon regempleico = new ImageIcon(getClass().getResource("/iconos/empleados.png"));
        ImageIcon regempleico1 = new ImageIcon(regempleico.getImage().getScaledInstance(lbregistrar_empleados.getWidth(), lbregistrar_empleados.getHeight(), Image.SCALE_DEFAULT));
        lbregistrar_empleados.setIcon(regempleico1);
        ImageIcon atrasico = new ImageIcon(getClass().getResource("/iconos/back.jpg"));
        ImageIcon atrasico1 = new ImageIcon(atrasico.getImage().getScaledInstance(lbatras1.getWidth(), lbatras1.getHeight(), Image.SCALE_DEFAULT));
        lbatras1.setIcon(atrasico1);
        lbatras2.setIcon(atrasico1);
    }

    private File es = null;
    private JFileChooser file;
    private final ConexionBD cc = new ConexionBD();
    private final Connection cn = cc.conexion();
    private PreparedStatement ps;
    private int x, y;
    public static int codplant = 0, codespecie = 0, codenf = 0;

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
        lb_cuentas = new javax.swing.JLabel();
        lbproduccionp3 = new javax.swing.JLabel();
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
        lbatras1 = new javax.swing.JLabel();
        Recomendacion2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboSuelo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jbbuscareceta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboClima = new javax.swing.JComboBox<>();
        bt_buscaplanta = new javax.swing.JButton();
        bt_buscaenfermedad = new javax.swing.JButton();
        bt_buscaespecie = new javax.swing.JButton();
        text_planta = new javax.swing.JTextField();
        text_especie = new javax.swing.JTextField();
        text_enfermedad = new javax.swing.JTextField();
        lbatras2 = new javax.swing.JLabel();
        Ventas_ventana = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jCombotipofactura = new javax.swing.JComboBox<>();
        lbtipofact = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btn_cliente = new javax.swing.JButton();
        btn_empleado = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_empleado = new javax.swing.JTextField();
        check_pedido = new javax.swing.JCheckBox();
        Registrar = new javax.swing.JPanel();
        lbregistrar_usuarios = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbregistrar_empleados = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cuentas = new javax.swing.JPanel();
        lbcuenta_por_cobrar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Produccion = new javax.swing.JPanel();
        lbcomposicionprod = new javax.swing.JLabel();
        lbasignartrabajos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcrearproduccion = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        lbRecomendacion.setText("Recomendación");
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
        lbcerrarsesion.setText("Cerrar Sesión");
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
        jPanel3.add(lbcerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 190, 42));

        lb_cuentas.setBackground(new java.awt.Color(102, 102, 102));
        lb_cuentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_cuentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cuentas.setText("Cuentas");
        lb_cuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_cuentas.setOpaque(true);
        lb_cuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_cuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_cuentasMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lb_cuentasMouseReleased(evt);
            }
        });
        jPanel3.add(lb_cuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 42));

        lbproduccionp3.setBackground(new java.awt.Color(102, 102, 102));
        lbproduccionp3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbproduccionp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbproduccionp3.setText("Producción");
        lbproduccionp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbproduccionp3.setOpaque(true);
        lbproduccionp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbproduccionp3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbproduccionp3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbproduccionp3MouseReleased(evt);
            }
        });
        jPanel3.add(lbproduccionp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 42));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, -1, 510));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 140, 187)));
        jPanel2.setLayout(new java.awt.CardLayout());

        inicio.setBackground(new java.awt.Color(255, 255, 255));
        inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(inicio, "card3");

        recomendacionprincipal.setBackground(new java.awt.Color(255, 255, 255));
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

        Recomendacion.setBackground(new java.awt.Color(19, 19, 123));
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

        lbatras1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbatras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbatras1MouseReleased(evt);
            }
        });
        Recomendacion.add(lbatras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jPanel2.add(Recomendacion, "card2");

        Recomendacion2.setBackground(new java.awt.Color(0, 0, 102));
        Recomendacion2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Productos Recomendados");
        Recomendacion2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 194, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enfermedad:");
        Recomendacion2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "Unidad", "Codigo de Unidad"
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
        jScrollPane3.setViewportView(tabla);

        Recomendacion2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 650, 290));

        jButton3.setText("Agregar Compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Recomendacion2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Especie:");
        Recomendacion2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 50, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Planta:");
        Recomendacion2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        Recomendacion2.add(jComboSuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Clima:");
        Recomendacion2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 40, -1));

        jbbuscareceta.setText("Buscar Receta");
        jbbuscareceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbuscarecetaActionPerformed(evt);
            }
        });
        Recomendacion2.add(jbbuscareceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tipo de Suelo:");
        Recomendacion2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jComboClima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Lluvioso" }));
        Recomendacion2.add(jComboClima, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 140, -1));

        bt_buscaplanta.setText("Planta");
        bt_buscaplanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscaplantaActionPerformed(evt);
            }
        });
        Recomendacion2.add(bt_buscaplanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 110, -1));

        bt_buscaenfermedad.setText("Enfermedad");
        bt_buscaenfermedad.setEnabled(false);
        bt_buscaenfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscaenfermedadActionPerformed(evt);
            }
        });
        Recomendacion2.add(bt_buscaenfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 110, -1));

        bt_buscaespecie.setText("Especie");
        bt_buscaespecie.setEnabled(false);
        bt_buscaespecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscaespecieActionPerformed(evt);
            }
        });
        Recomendacion2.add(bt_buscaespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 110, -1));
        Recomendacion2.add(text_planta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 140, -1));
        Recomendacion2.add(text_especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 140, -1));
        Recomendacion2.add(text_enfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 110, -1));

        lbatras2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbatras2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbatras2MouseReleased(evt);
            }
        });
        Recomendacion2.add(lbatras2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jPanel2.add(Recomendacion2, "card8");

        Ventas_ventana.setBackground(new java.awt.Color(19, 19, 123));
        Ventas_ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Realizar Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Ventas_ventana.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Ventas_ventana.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "Unidad", "Codigo de Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDoubleBuffered(true);
        jScrollPane2.setViewportView(jTable1);

        Ventas_ventana.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 710, 251));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total:");
        Ventas_ventana.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, -1, -1));

        jlTotal.setBackground(new java.awt.Color(204, 204, 204));
        jlTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jlTotal.setOpaque(true);
        Ventas_ventana.add(jlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 120, 30));

        jCombotipofactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        jCombotipofactura.setSelectedIndex(-1);
        jCombotipofactura.setAutoscrolls(true);
        Ventas_ventana.add(jCombotipofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 80, -1));

        lbtipofact.setForeground(new java.awt.Color(255, 255, 255));
        lbtipofact.setText("Tipo de Factura:");
        Ventas_ventana.add(lbtipofact, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, 20));

        lb_fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lb_fecha.setText("00/00/00");
        Ventas_ventana.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 100, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Empleado:");
        Ventas_ventana.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ventas_ventana.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 220, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha:");
        Ventas_ventana.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        btn_cliente.setText("Buscar cliente");
        btn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteActionPerformed(evt);
            }
        });
        Ventas_ventana.add(btn_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        btn_empleado.setText("Buscar empleado");
        btn_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empleadoActionPerformed(evt);
            }
        });
        Ventas_ventana.add(btn_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cliente:");
        Ventas_ventana.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        txt_empleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ventas_ventana.add(txt_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 77, 220, -1));

        check_pedido.setBackground(new java.awt.Color(19, 19, 123));
        check_pedido.setForeground(new java.awt.Color(255, 255, 255));
        check_pedido.setText("Pedido");
        check_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_pedidoActionPerformed(evt);
            }
        });
        Ventas_ventana.add(check_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 80, -1));

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
        jLabel4.setText("Registrar Usuarios");
        Registrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, -1));

        lbregistrar_empleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbregistrar_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbregistrar_empleadosMouseReleased(evt);
            }
        });
        Registrar.add(lbregistrar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 150, 110));

        jLabel2.setText("Registrar Empleados");
        Registrar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jPanel2.add(Registrar, "card5");

        Cuentas.setBackground(new java.awt.Color(255, 255, 255));
        Cuentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbcuenta_por_cobrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbcuenta_por_cobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbcuenta_por_cobrarMouseReleased(evt);
            }
        });
        Cuentas.add(lbcuenta_por_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 110));

        jLabel8.setText("Cuentas Por Cobrar");
        Cuentas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jPanel2.add(Cuentas, "card8");

        Produccion.setBackground(new java.awt.Color(255, 255, 255));
        Produccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbcomposicionprod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbcomposicionprod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbcomposicionprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbcomposicionprodMouseReleased(evt);
            }
        });
        Produccion.add(lbcomposicionprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 110));

        lbasignartrabajos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbasignartrabajos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbasignartrabajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbasignartrabajosMouseReleased(evt);
            }
        });
        Produccion.add(lbasignartrabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, 110));

        jLabel13.setText("Asignar Trabajos");
        Produccion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        jLabel14.setText("Crear Composición");
        Produccion.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        lbcrearproduccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbcrearproduccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbcrearproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbcrearproduccionMouseReleased(evt);
            }
        });
        Produccion.add(lbcrearproduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 110));

        jLabel18.setText("Crear Producción");
        Produccion.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jPanel2.add(Produccion, "card9");

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
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 30, 30));

        minimizar.setBackground(new java.awt.Color(19, 19, 123));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 30));

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
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
        }
    }//GEN-LAST:event_lbRecomendacionMouseReleased

    private void jlmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlmenuMousePressed
        //mover el panel de menu con la animacion
        Menu.jPanel3.setVisible(true);
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
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
                resultados = resultados.replace("\\u00c1", "Á");
                resultados = resultados.replace("\\u00e1", "á");
                resultados = resultados.replace("\\u00ed", "í");
                resultados = resultados.replace("\\u00f3", "ó");
                resultados = resultados.replace("\\u00fa", "ú");
                resultados = resultados.replace("\\u00e9", "é");
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
            String[] r2 = r[0].split(">");
            int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
            if (opcion == JOptionPane.YES_OPTION) {

                if (!r2[2].contains("Saludable")) {
                    //setea el texto
                    text_planta.setText(r2[0]);
                    text_especie.setText(r2[1]);
                    text_enfermedad.setText(r2[2]);
                    //busca el codigo dada la descripcion
                    codplant = Funciones.traeindice("planta", r2[0]);
                    codespecie = Funciones.traeindice("especie", r2[1]);
                    codenf = Funciones.traeindice("enfermedad", r2[2]);
                    bt_buscaespecie.setEnabled(true);
                    bt_buscaenfermedad.setEnabled(true);
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
                } else {
                    JOptionPane.showMessageDialog(null, "Esta planta está saludable favor usar otra imagen", "Recomendación", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (jList1.getSelectedValue() != null) {
                String[] r = jList1.getSelectedValue().split(" porciento de acierto: ");
                String[] r2 = r[0].split(">");
                int opcion = JOptionPane.showConfirmDialog(null, "usted selecciono: " + r[0]);
                if (opcion == JOptionPane.YES_OPTION) {
                    ///setea el texto
                    if (!r2[2].contains("Saludable")) {
                        text_planta.setText(r2[0]);
                        text_especie.setText(r2[1]);
                        text_enfermedad.setText(r2[2]);
                        //busca el codigo dada la descripcion
                        codplant = Funciones.traeindice("planta", r2[0]);
                        codespecie = Funciones.traeindice("especie", r2[1]);
                        codenf = Funciones.traeindice("enfermedad", r2[2]);
                        bt_buscaespecie.setEnabled(true);
                        bt_buscaenfermedad.setEnabled(true);
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
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta planta está saludable favor usar otra imagen", "Recomendación", JOptionPane.ERROR_MESSAGE);
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
        jPanel2.add(inicio);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mover el panel de menu con la animacion
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
        }
    }//GEN-LAST:event_lbInicioMouseReleased
    void reporte(int numfac,double total){
        //reporte de jasperreport
                    JasperReport reporte = null;
                    String ruta = getClass().getResource("/Reportes/Factura.jasper").toString();
                    ruta = ruta.replace("file:", "");
                    Map parametro = new HashMap();
                    parametro.put("numerodefactura", numfac);
                    parametro.put("Totalfactura", total);
                    parametro.put("TipoFactura", jCombotipofactura.getSelectedItem().toString());
                    parametro.put("cliente", txt_cliente.getText());
                    parametro.put("vendedor", txt_empleado.getText());
                    try {
                        reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
                        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, cn);
                        JasperViewer view = new JasperViewer(jprint, false);
                        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        view.setVisible(true);
                    } catch (JRException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    void crear_factura() {

        try {
            //ejecuto el procedimento almacenado de factura que retorna el numero de la factura

            boolean estado = true;
            int tipfact = jCombotipofactura.getSelectedIndex();
            if (tipfact == 1) {
                estado = false;
            }

            double balance = 0;
            if (tipfact == 1) {
                balance = Double.parseDouble(jlTotal.getText().replace(",", ""));

            }

            double total = Double.parseDouble(jlTotal.getText().replace(",", ""));

            String sql = "call sp_factura(?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codclie);
            ps.setBoolean(2, estado);
            ps.setInt(3, tipfact);
            ps.setInt(4, codemp);
            ps.setDouble(5, balance);
            ps.setDouble(6, total);
            ResultSet res = ps.executeQuery();
            res.next();
            int numfac = res.getInt(1);
            sql = "call sp_detallefactura(?,?,?,?,?)";
            int contador = 0;
            //JOptionPane.showMessageDialog(null, ""+jTable1.getRowCount());
            //recorre cada uno de los productos de jtable y lo agrega a la tabla detalle factura
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                int opcion = 0;
                try {
                    ps = cn.prepareStatement(sql);
                    ps.setInt(1, numfac);
                    ps.setInt(2, Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
                    ps.setInt(3, Integer.parseInt(jTable1.getValueAt(i, 3).toString()));
                    ps.setDouble(4, Double.parseDouble(jTable1.getValueAt(i, 2).toString()));
                    ps.setInt(5, Integer.parseInt(jTable1.getValueAt(i, 5).toString()));
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
            if (contador == jTable1.getRowCount()) {
                if (tipfact == 1) {
                    factura_credito obj2 = new factura_credito(numfac, balance);

                    obj2.numfac = numfac;
                    obj2.tipfact = jCombotipofactura.getSelectedItem().toString();
                    obj2.total = total;
                    obj2.setVisible(true);
                    obj2.setLocationRelativeTo(null);

                } else {
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Transaccion realizada correctamente");
                    if(check_pedido.isSelected()){
                        Pedido obj = new Pedido();
                        obj.setVisible(true);
                        obj.setLocationRelativeTo(null);
                        Pedido.txt_factura.setText(String.valueOf(numfac)); 
                    }
                  //  reporte(numfac, total);
                    
                    jlTotal.setText("");
                    jCombotipofactura.setSelectedIndex(-1);
                    txt_empleado.setText("");
                    txt_cliente.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Agrega un Producto");
            buscar_productos obj = new buscar_productos();
            obj.setLocationRelativeTo(jPanel2);
            obj.setVisible(true);
        } else {
            if (jCombotipofactura.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Agrega un Tipo de Factura");
            } else if (txt_cliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Agrega un Cliente.");
                buscar_cliente obj = new buscar_cliente();
                obj.setLocationRelativeTo(jPanel2);
                obj.setVisible(true);
            } else if (txt_empleado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Agrega un Empleado.");
                buscar_empleado obj = new buscar_empleado();
                obj.setLocationRelativeTo(jPanel2);
                obj.setVisible(true);
            } else {
                crear_factura();
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
        if (this.tipousuario == 0) {
            JOptionPane.showMessageDialog(null, "No dispones de acceso a esta función", "Menú", JOptionPane.ERROR_MESSAGE);
        } else {
            jPanel2.removeAll();
            jPanel2.repaint();
            jPanel2.revalidate();
            jPanel2.add(this.Registrar);
            jPanel2.repaint();
            jPanel2.revalidate();
            int posicion = jPanel3.getX();
            if (posicion > -1) {
                Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
            } else {
                Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
            }
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
        if (tabla.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Su Receta está vacía", "Recomendación", JOptionPane.ERROR_MESSAGE);
        } else {
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
                String[] dato = new String[6];
                DefaultTableModel tabladet = (DefaultTableModel) Menu.jTable1.getModel();
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    dato[0] = tabla.getValueAt(i, 0).toString();
                    dato[1] = tabla.getValueAt(i, 1).toString();
                    dato[2] = tabla.getValueAt(i, 2).toString();
                    dato[3] = tabla.getValueAt(i, 3).toString();
                    dato[4] = tabla.getValueAt(i, 4).toString();
                    dato[5] = tabla.getValueAt(i, 5).toString();
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
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void consult_enfermedadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consult_enfermedadMouseReleased
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(Recomendacion);
        jPanel2.repaint();
        jPanel2.revalidate();
        int posicion = jPanel3.getX();
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
        int posicion = jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
            jPanel3.setVisible(false);
        } else {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);

        }
    }//GEN-LAST:event_consult_recetaMouseReleased

    private void lbregistrar_empleadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbregistrar_empleadosMouseReleased
        // TODO add your handling code here:
        Empleados obj = new Empleados();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbregistrar_empleadosMouseReleased

    private void lbcuenta_por_cobrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcuenta_por_cobrarMouseReleased
        // TODO add your handling code here:
        cuentas_pagar obj = new cuentas_pagar();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbcuenta_por_cobrarMouseReleased

    private void jbbuscarecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscarecetaActionPerformed
        if (codenf != 0 && codespecie != 0 && codplant != 0) {
            recomendacion(codenf, jComboSuelo.getSelectedIndex() + 1, codplant, codespecie, jComboClima.getSelectedIndex());
        } else {
            if (codplant == 0) {
                JOptionPane.showMessageDialog(null, "Debes buscar una Planta", "Recomendación", JOptionPane.ERROR_MESSAGE);
            } else if (codespecie == 0) {
                JOptionPane.showMessageDialog(null, "Debes buscar una especie", "Recomendación", JOptionPane.ERROR_MESSAGE);
            } else if (codenf == 0) {
                JOptionPane.showMessageDialog(null, "Debes buscar una enfermedad", "Recomendación", JOptionPane.ERROR_MESSAGE);
            }
        }
        //clima si es 0 es normal y si es 1 lluvioso
    }//GEN-LAST:event_jbbuscarecetaActionPerformed

    private void btn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteActionPerformed
        // TODO add your handling code here:
        buscar_cliente obj = new buscar_cliente();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_btn_clienteActionPerformed

    private void btn_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empleadoActionPerformed
        // TODO add your handling code here:
        buscar_empleado obj = new buscar_empleado();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_btn_empleadoActionPerformed

    private void bt_buscaplantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscaplantaActionPerformed
        buscar_planta obj = new buscar_planta();
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);


    }//GEN-LAST:event_bt_buscaplantaActionPerformed

    private void bt_buscaespecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscaespecieActionPerformed
        buscar_especie obj = new buscar_especie(codplant);
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);

    }//GEN-LAST:event_bt_buscaespecieActionPerformed

    private void bt_buscaenfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscaenfermedadActionPerformed
        buscar_enfermedad obj = new buscar_enfermedad(codespecie);
        obj.setLocationRelativeTo(Menu.jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_bt_buscaenfermedadActionPerformed

    private void lb_cuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cuentasMouseEntered
        lb_cuentas.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lb_cuentasMouseEntered

    private void lb_cuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cuentasMouseExited
        lb_cuentas.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_cuentasMouseExited

    private void lb_cuentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cuentasMouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.Cuentas);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mover el panel de menu con la animacion
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
        }
    }//GEN-LAST:event_lb_cuentasMouseReleased

    private void lbproduccionp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbproduccionp3MouseEntered
        lbproduccionp3.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lbproduccionp3MouseEntered

    private void lbproduccionp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbproduccionp3MouseExited
        lbproduccionp3.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbproduccionp3MouseExited

    private void lbproduccionp3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbproduccionp3MouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.Produccion);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mover el panel de menu con la animacion
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, jPanel3);
        }
    }//GEN-LAST:event_lbproduccionp3MouseReleased

    private void lbatras1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbatras1MouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.recomendacionprincipal);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mueve el panel de menu a la izquierda si este se encuentra en a la derecha
        int posicion = Menu.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
            Menu.jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_lbatras1MouseReleased

    private void lbatras2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbatras2MouseReleased
        //pasar de un panel a otro
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(this.recomendacionprincipal);
        jPanel2.repaint();
        jPanel2.revalidate();
        //mueve el panel de menu a la izquierda si este se encuentra en a la derecha
        int posicion = Menu.jPanel3.getX();
        if (posicion < -1) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, Menu.jPanel3);
            Menu.jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_lbatras2MouseReleased

    private void lbcomposicionprodMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcomposicionprodMouseReleased
        Composicion_producto obj = new Composicion_producto();
        obj.setLocationRelativeTo(jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbcomposicionprodMouseReleased

    private void lbasignartrabajosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbasignartrabajosMouseReleased
        Asignar_trabajos obj = new Asignar_trabajos();
        obj.setLocationRelativeTo(jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbasignartrabajosMouseReleased

    private void lbcrearproduccionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcrearproduccionMouseReleased
        produccion_1 obj =  new produccion_1();
        obj.setLocationRelativeTo(jPanel2);
        obj.setVisible(true);
    }//GEN-LAST:event_lbcrearproduccionMouseReleased

    private void check_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_pedidoActionPerformed
        //aumentar total con el costo del pedido
    }//GEN-LAST:event_check_pedidoActionPerformed
    private void recomendacion(int codenf, int codsuelo, int codplanta, int codespecie, int clima) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "SELECT p.codproducto,p.descripcion,pu.precioventa,pe.cantidad,u.descripcion as unidad,pe.coduni FROM productovsefermedad as pe "
                + "INNER JOIN enfermedad as enf on pe.codenfer=enf.codenfer "
                + "INNER JOIN producto as p on p.codproducto=pe.codprod "
                + "INNER JOIN unidad as u on u.coduni=pe.coduni "
                + "INNER JOIN productovsunidad as pu on pu.codproducto=pe.codprod WHERE pe.codenfer=" + codenf
                + " and pe.codsuelo=" + codsuelo + " and pe.codplant=" + codplanta + " and pe.codespecie=" + codespecie
                + " and pe.clima=" + clima;
        try {
            ResultSet rs = Funciones.consulta(sql);
            while (rs.next()) {
                // agrega los datos de la consulta al modelo de la tabla
                modelo.addRow(new Object[]{
                    rs.getString("codproducto"),
                    rs.getString("descripcion"),
                    rs.getString("precioventa"),
                    rs.getString("cantidad"),
                    rs.getString("Unidad"),
                    rs.getString("coduni")});
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al llenar la tabla", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JPanel Cuentas;
    private javax.swing.JPanel Produccion;
    public static javax.swing.JPanel Recomendacion;
    private javax.swing.JPanel Recomendacion2;
    private javax.swing.JPanel Registrar;
    public static javax.swing.JPanel Ventas_ventana;
    public static javax.swing.JButton bt_buscaenfermedad;
    public static javax.swing.JButton bt_buscaespecie;
    private javax.swing.JButton bt_buscaplanta;
    private javax.swing.JButton btn_cliente;
    private javax.swing.JButton btn_empleado;
    private javax.swing.JCheckBox check_pedido;
    private javax.swing.JLabel consult_enfermedad;
    private javax.swing.JLabel consult_receta;
    private javax.swing.JButton evaluar;
    private javax.swing.JLabel imagen;
    private static javax.swing.JPanel inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboClima;
    private javax.swing.JComboBox<String> jComboSuelo;
    public static javax.swing.JComboBox<String> jCombotipofactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton jbbuscareceta;
    public static javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlmenu;
    private javax.swing.JLabel jltab;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbRecomendacion;
    private javax.swing.JLabel lbVentas;
    private javax.swing.JLabel lb_cuentas;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_resigstrar;
    private javax.swing.JLabel lbasignartrabajos;
    private javax.swing.JLabel lbatras1;
    private javax.swing.JLabel lbatras2;
    private javax.swing.JLabel lbcerrarsesion;
    private javax.swing.JLabel lbcomposicionprod;
    private javax.swing.JLabel lbcrearproduccion;
    private javax.swing.JLabel lbcuenta_por_cobrar;
    private javax.swing.JLabel lbproduccionp3;
    private javax.swing.JLabel lbregistrar_empleados;
    private javax.swing.JLabel lbregistrar_usuarios;
    private javax.swing.JLabel lbsubirimg;
    private javax.swing.JLabel lbtipofact;
    private javax.swing.JLabel minimizar;
    private javax.swing.JPanel recomendacionprincipal;
    private javax.swing.JLabel salir;
    private javax.swing.JButton seleccionar;
    private javax.swing.JTable tabla;
    public static javax.swing.JTextField text_enfermedad;
    public static javax.swing.JTextField text_especie;
    public static javax.swing.JTextField text_planta;
    private javax.swing.JTextField txruta;
    public static javax.swing.JTextField txt_cliente;
    public static javax.swing.JTextField txt_empleado;
    // End of variables declaration//GEN-END:variables
}
