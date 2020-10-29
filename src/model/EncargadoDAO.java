
package model;

import model.EquipmentBBDD;
import java.util.ArrayList;

public interface EncargadoDAO {
    public boolean insertEquipment(EquipmentBBDD equip) throws Exception;
    public boolean updateEquipment(EquipmentBBDD equip) throws Exception;
    public boolean deleteEquipment(EquipmentBBDD equip) throws Exception;
    public ArrayList<EquipmentBBDD> listar()throws Exception;
    
}
