/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;


import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author victor
 */
public class Redneu extends javax.swing.JFrame {

    public Redneu() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    private File es = null;
    private JFileChooser file;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelprincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        evaluar = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        salir = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelprincipal.setBackground(new java.awt.Color(0, 0, 51));
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("selecciona una imagen:");
        panelprincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));
        panelprincipal.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 202, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelprincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 27, -1));

        evaluar.setBackground(new java.awt.Color(255, 255, 255));
        evaluar.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        evaluar.setText("evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });
        panelprincipal.add(evaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        imagen.setBackground(new java.awt.Color(255, 255, 255));
        imagen.setForeground(new java.awt.Color(255, 255, 255));
        imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        imagen.setOpaque(true);
        panelprincipal.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 202, 172));

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

        panelprincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 439, 89));

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
        panelprincipal.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        minimizar.setBackground(new java.awt.Color(255, 255, 255));
        minimizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("_");
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
        panelprincipal.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        panelprincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (jList1.getSelectedValue() != null) {
                JOptionPane.showMessageDialog(null, "usted selecciono: " + jList1.getSelectedValue());
            }
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (jList1.getSelectedValue() != null) {
            String[] r=jList1.getSelectedValue().toString().split(" porciento de acierto: ");
            JOptionPane.showMessageDialog(null, "usted selecciono: " + r[0]);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        try {
            if (!this.jTextField1.getText().equals("")) {
                URL url = new URL("http://127.0.0.1:5000/upload/" + this.jTextField1.getText());//your url i.e fetch data from .
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
                resultados = resultados.replace(":", " porciento de acierto: ");
                String[] resul = resultados.split(",");
                this.jList1.setListData(resul);
                conn.disconnect();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exception in NetClientGet:- " + e);
        }
    }//GEN-LAST:event_evaluarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, png y gif", "jpg","png","gif");
        file.setFileFilter(filtro);
        file.setCurrentDirectory(es);
        file.showOpenDialog(this);
        
        if (file.getSelectedFile() != null) {
            es = file.getSelectedFile();
            this.jTextField1.setText(es.getAbsolutePath());
            rsscalelabel.RSScaleLabel.setScaleLabel(imagen, es.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        //System.exit(0);
        this.dispose();
    }//GEN-LAST:event_salirMousePressed
    private int x,y;
    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_salirMouseExited

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        this.setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseEntered
        minimizar.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_minimizarMouseEntered

    private void minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseExited
        minimizar.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_minimizarMouseExited

    private void minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMousePressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizarMousePressed
    
    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton evaluar;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel minimizar;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JLabel salir;
    // End of variables declaration//GEN-END:variables
}
