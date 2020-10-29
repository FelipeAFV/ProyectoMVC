
package model;

import model.EquipmentBBDD;
import java.util.ArrayList;

public interface EncargadoDAO {
    public boolean insertEquipment(EquipmentBBDD equip);
    public boolean updateEquipment(EquipmentBBDD equip);
    public boolean deleteEquipment(EquipmentBBDD equip);
    public ArrayList<EquipmentBBDD> listar();
    
}
