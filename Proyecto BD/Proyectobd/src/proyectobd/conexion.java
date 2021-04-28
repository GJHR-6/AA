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
    
    public DefaultTableModel mostrar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ArticuloID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Descuento");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total");
        
        try{
            CallableStatement cmd = conectar().prepareCall("select * from v1 ");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object dato[] = new Object[7];
                for(int i = 0; i<7; i++){
                    dato[i] = rs.getString(i+1);
                }
                modelo.addRow(dato);
            }
            
        }catch(SQLException E){
            E.printStackTrace();
        }
        return modelo;
    }
    public DefaultTableModel mostrar1(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CompraID");
        modelo.addColumn("ProveedorID");
        modelo.addColumn("NombreProv");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Descuento");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total");
        
        try{
            CallableStatement cmd = conectar().prepareCall("select * from v2 ");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                Object dato[] = new Object[8];
                for(int i = 0; i<8; i++){
                    dato[i] = rs.getString(i+1);
                }
                modelo.addRow(dato);
            }
            
        }catch(SQLException E){
            E.printStackTrace();
        }
        return modelo;
    }
    public DefaultTableModel form3(int a){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("No. de Cuenta");
        modelo.addColumn("Nombre");
        modelo.addColumn("Moneda");
        modelo.addColumn("Saldo");
        
        try{
            
        CallableStatement entrada = conectar().prepareCall("{call spSelectCuenta("+a+")}");
        ResultSet rs = entrada.executeQuery();
        while(rs.next()){
                Object dato[] = new Object[4];
                for(int i = 0; i<4; i++){
                    dato[i] = rs.getString(i+1);
                    System.out.println(dato[i].toString());
                }
                modelo.addRow(dato);
            }    
        }catch(SQLException E){
            E.printStackTrace();
        }
        return modelo;
    }
}
