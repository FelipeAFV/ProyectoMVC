
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private final String base = "orcl";
    private final String user = "instituto_trabajo";
    private final String password = "progra";
    private final String url = "jdbc:oracle:thin:@40.71.170.91:1521:"+base;
    protected Connection con = null;
    
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
