/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.TeacherDAO;
import view.TeacherView;

/**
 *
 * @author f_fig
 */
public class TeacherControl {
    
    private TeacherView teacherView;
    private TeacherDAO teacherData;
    
    public DefaultTableModel createDataDisplay(ArrayList<Equipment> data) {
        String[] columNames = {"ID","Nombre","Marca","Estado", "Año"};
        Object[][] output = {};
        
        //Ingrasar datos a el array output
        
        DefaultTableModel dtm = new DefaultTableModel(output, columNames);
        return dtm;
    }
    
}
