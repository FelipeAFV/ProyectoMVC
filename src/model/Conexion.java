
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private final String base = "BBDDEJ";
    private final String user = "trabajo_pa";
    private final String password = "190298";
    private final String url = "jdbc:oracle:thin:@localhost:1521:BBDDEJ";
    public Connection con = null;
    
    public Connection getConexion() {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(this.url,this.user,this.password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha logrado la conexión a la BBDD");
        }
        return con;
    }
}
