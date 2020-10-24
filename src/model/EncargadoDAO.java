
package Interfaces;

import Controlador.EquipmentBBDD;
import java.awt.List;

public interface EncargadoDAO {
    public void registrarEquipment(EquipmentBBDD equip) throws Exception;
    public List<EquipmentBBDD> listar()throws Exception;
    
}
