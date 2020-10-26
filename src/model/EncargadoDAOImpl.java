package model;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class EncargadoDAOImpl extends Conexion implements EncargadoDAO {

    @Override
    public void insertEquipment(EquipmentBBDD equip) throws Exception {
        try {
            this.getConexion();
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Equipment(eqp_id) VALUES(?)");
            ps.setString(1, equip.getEqp_name());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    @Override
    public void updateEquipment(EquipmentBBDD equip) throws Exception {
        
    }

    @Override
    public void deleteEquipment(EquipmentBBDD equip) throws Exception {
        
    }

    @Override
    public ArrayList<EquipmentBBDD> listar() throws Exception {
        //aaaa
    }
}
