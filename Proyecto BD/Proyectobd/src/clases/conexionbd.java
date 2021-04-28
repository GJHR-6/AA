/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author guill
 */
public class conexionbd {

    /* public void insertar(String sql){
        try {
            PreparedStatement st = connect.prepareStatement(sql);
            st.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }
    }
    
    public ResultSet seleccionar (String sql){
        try {
            PreparedStatement st = connect.prepareStatement(sql);
            result = st.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
            //System.out.println(e.toString());
        }
        return result;
    }
    
    public void cerrar(){
        try {
            connect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Conectado el Error es: " + e.toString());
           // System.out.println(e.toString());
        }
    }*/
}
