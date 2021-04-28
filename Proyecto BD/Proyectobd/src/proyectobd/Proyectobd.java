/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd;
/**
 *
 * @author guill
 */
public class Proyectobd {

    /**
     * @param args the command line arguments
     */
    connection cnn;
    public static void main(String[] args) {
        // TODO code application logic here
        cnn = conexion.conectar(); 
        menu m = new menu();
        m.setVisible(true);
    }
    
}
