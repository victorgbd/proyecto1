/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Felix Artiles
 */
public class Funciones {

    static final ConexionBD cc = new ConexionBD();
    static final Connection cn = cc.conexion();
    public static String sql = null;

    public boolean empleado_usuario = false;

    public static ResultSet consulta(String consulta) {
        Statement st;
        ResultSet datos = null;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return datos;

    }

    public static void validar_correo(JTextField correo) {
        Pattern expresion = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = expresion.matcher(correo.getText());
        if (!mather.find()) {
            JOptionPane.showMessageDialog(null, "El correo " + correo.getText() + " esta mal escrito.", "", JOptionPane.ERROR_MESSAGE);
            correo.requestFocus();
        }

    }

    public static void llenar_combo(JComboBox combo, String tabla, String columna) {
        sql = "SELECT * from " + tabla;
        combo.removeAllItems();
        ResultSet rs = Funciones.consulta(sql);
        try {

            while (rs.next()) {
                combo.addItem(rs.getString(columna));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void solo_numeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keytyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.consume();
                }
            }

        });
    }

    public static boolean buscar_usuario(String usuario) {
        boolean encontrado = false;
        sql = "select nickname from usuario where nickname = " + usuario;
        ResultSet dato = consulta(sql);

        try {
            if (dato.next()) {
                encontrado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }
    public static int traeindice(String tabla, String descripcion){
        
        sql = "SELECT * from " + tabla+" WHERE descripcion='"+descripcion+"'";
        
        ResultSet rs = Funciones.consulta(sql);
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
}
