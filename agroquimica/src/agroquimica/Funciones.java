/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Felix Artiles
 */
public class Funciones {
    private static ConexionBD cc = new ConexionBD();
    private static Connection cn=cc.conexion();
    public static ResultSet consulta(String consulta){
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
}
