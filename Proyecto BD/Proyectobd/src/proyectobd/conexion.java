/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guill
 */
public class conexion {
    public static Connection conectar(){
        //Connection cnn= null;
    String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=Proyecto;"
                        + "user=sa;"
                        + "password=123456;"
                        + "loginTimeout=30;";
    
        try{
            Connection connect = DriverManager.getConnection(connectionUrl);
            System.out.println("conexion realizada");
            return connect;
        }
        catch(SQLException E){
            E.printStackTrace();
            return null;
        }
}
 //   public int 
    public DefaultTableModel mostrar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ArticuloID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");
        
        try{
            CallableStatement cmd = conectar().prepareCall("select * from v1 ");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object dato[] = new Object[4];
                for(int i = 0; i<4; i++){
                    dato[i] = rs.getString(i+1);
                }
                modelo.addRow(dato);
            }
            
        }catch(SQLException E){
            E.printStackTrace();
        }
        return modelo;
    }
}
