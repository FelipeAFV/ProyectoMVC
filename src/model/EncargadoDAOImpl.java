
package model;

import java.sql.PreparedStatement;
import Interfaces.EncargadoDAO;

public class EncargadoDAOImpl extends Conexion implements EncargadoDAO{
    

    @Override
    public void registrarEquipment(EquipmentBBDD equip) throws Exception {
        try {
            this.getConexion();
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Equipment(eqp_id) VALUES(?)");
            //terminar registro
        } catch(Exception e) {
            throw e;
        }finally {
            
        }
        
    }

    @Override
    public Object listar() throws Exception {
        //terminar 
    }
    
    
}
