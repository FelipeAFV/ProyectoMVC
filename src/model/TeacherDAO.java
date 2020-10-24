/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.JTable;
import view.TeacherView;

/**
 *
 * @author f_fig
 */
public interface TeacherDAO {
    
    public EquipmentBBDD searchById(int id);
    public ArrayList<EquipmentBBDD> searchByClassroom(int classroomId);
    

    
}
