/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.EquipmentBBDD;
import model.TeacherDAO;
import view.TeacherView;

/**
 *
 * @author f_fig
 */
public class TeacherControl implements ActionListener {

    private TeacherView teacherView;
    private TeacherDAO teacherData;

    public TeacherControl(TeacherView teacherView, TeacherDAO teacherData) {
        this.teacherView = teacherView;
        this.teacherData = teacherData;
        this.teacherView.btnIdEquipo.addActionListener(this);
        this.teacherView.btnIdSala.addActionListener(this);
    }

    public DefaultTableModel createDataDisplay(ArrayList<EquipmentBBDD> data) {
        String[] columNames = {"ID", "Nombre", "Marca", "Estado", "Año"};
        Object[][] output;

        ArrayList<String[]> result = new ArrayList<>();

        Iterator itr = data.iterator();
        while (itr.hasNext()) {

            EquipmentBBDD eqp = (EquipmentBBDD) itr.next();
            String[] values = new String[5];
            values[0] = "" + eqp.getEqp_id();
            values[1] = eqp.getEqp_name();
            values[2] = eqp.getBrand();
            values[3] = eqp.getStatus();
            values[4] = eqp.getYear();

            result.add(values);
        }
        output = new Object[result.size()][];

        itr = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            output[i] = (Object[]) itr.next();
        }

        DefaultTableModel dtm = new DefaultTableModel(output, columNames);
        return dtm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(teacherView.btnIdEquipo)) {

            int id = Integer.parseInt(teacherView.txtIdEquipo.getText());
            EquipmentBBDD eqp = teacherData.searchById(id);

            if (eqp != null) {
                JOptionPane.showMessageDialog(null, "Equipo encontrado \n" +
                        eqp.getEqp_name());

            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el equipo");
            }
        } else if (e.getSource().equals(teacherView.btnIdSala)) {

        }

    }
    
    public void begin() {
        teacherView.setTitle("Sistema Profesor");
        teacherView.setLocationRelativeTo(null);
        teacherView.setVisible(true);
        
    }

}
