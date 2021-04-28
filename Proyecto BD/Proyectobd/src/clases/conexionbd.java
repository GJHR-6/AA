/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guill
 */
public class conexionbd {
    public void conectar(){
        //Connection cnn= null;
    String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=Proyecto;"
                        + "user=sa;"
                        + "password=123456;"
                        + "loginTimeout=30;";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("conexion realizada");
        }
        catch(SQLException E){
            E.printStackTrace();
        }
      //  return cnn;
}
}
