
package model;

import model.EquipmentBBDD;
import java.util.ArrayList;

public interface EncargadoDAO {
    public void insertEquipment(EquipmentBBDD equip) throws Exception;
    public void updateEquipment(EquipmentBBDD equip) throws Exception;
    public void deleteEquipment(EquipmentBBDD equip) throws Exception;
    public ArrayList<EquipmentBBDD> listar()throws Exception;
    
}
