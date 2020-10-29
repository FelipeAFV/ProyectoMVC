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
import javax.swing.table.DefaultTableModel;
import model.EncargadoDAO;
import model.EquipmentBBDD;
import model.UserDTO;
import view.Vista_encargado;

/**
 *
 * @author f_fig
 */
public class ControladorEncargado implements ActionListener {

    private Vista_encargado view;
    private EncargadoDAO encargadoDAO;

    public ControladorEncargado(Vista_encargado view, EncargadoDAO encargadoDAO) {
        this.view = view;
        this.encargadoDAO = encargadoDAO;
        view.btnRegistrar.addActionListener(this);
        view.btnModificar.addActionListener(this);
        view.btnEliminar.addActionListener(this);
        view.btnMostrar.addActionListener(this);
    }

    public DefaultTableModel createDataDisplay(ArrayList<EquipmentBBDD> data) {
        String[] columNames = {"ID","ID Sala", "Nombre", "Marca", "Estado", "Año"};
        Object[][] output;

        ArrayList<String[]> result = new ArrayList<>();

        Iterator itr = data.iterator();
        while (itr.hasNext()) {

            EquipmentBBDD eqp = (EquipmentBBDD) itr.next();
            String[] values = new String[6];
            values[0] = "" + eqp.getEqp_id();
            values[1] = "" + eqp.getClassroom_id();
            values[2] = eqp.getEqp_name();
            values[3] = eqp.getBrand();
            values[4] = eqp.getStatus();
            values[5] = eqp.getYear();

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
        if (e.getSource().equals(view.btnMostrar)) {

            ArrayList<EquipmentBBDD> equipments = encargadoDAO.listar();
            DefaultTableModel def = createDataDisplay(equipments);
            view.tablaDatos.setModel(def);
            
        } else if (e.getSource().equals(view.btnRegistrar)) {
            if (!checkInput()) {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(view.txtId.getText());
            int idSala = Integer.parseInt(view.txtIdSala.getText());
            String estado = view.txtEstado.getText();
            String marca = view.txtMarca.getText();
            String nombre = view.txtNombre.getText();
            String year = view.txtYear.getText();

            EquipmentBBDD equip = new EquipmentBBDD();
            equip.setEqp_id(id);
            equip.setClassroom_id(idSala);
            equip.setStatus(estado);
            equip.setBrand(marca);
            equip.setEqp_name(nombre);
            equip.setYear(year);
            if(encargadoDAO.insertEquipment(equip)) {
                JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
            }

        } else if (e.getSource().equals(view.btnEliminar)) {
            String value = view.txtId.getText();
            if (value == "") {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            EquipmentBBDD equip = new EquipmentBBDD();
            
            int id = Integer.parseInt(value);
            equip.setEqp_id(id);
            boolean resultado = encargadoDAO.deleteEquipment(equip);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            } 

        } else if (e.getSource().equals(view.btnModificar)) {
            if (!checkInput()) {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(view.txtId.getText());
            int idSala = Integer.parseInt(view.txtIdSala.getText());
            String estado = view.txtEstado.getText();
            String marca = view.txtMarca.getText();
            String nombre = view.txtNombre.getText();
            String year = view.txtYear.getText();

            EquipmentBBDD equip = new EquipmentBBDD();
            equip.setEqp_id(id);
            equip.setClassroom_id(idSala);
            equip.setStatus(estado);
            equip.setBrand(marca);
            equip.setEqp_name(nombre);
            equip.setYear(year);

            if (encargadoDAO.updateEquipment(equip)) {
                JOptionPane.showMessageDialog(null, "Usuario modificado");
            }
        }
    }

    public boolean checkInput() {
        return view.txtId.getText() != "" && view.txtIdSala.getText() != "" && view.txtNombre.getText() != "" &&
                view.txtEstado.getText() != "" && view.txtYear.getText() != "" && view.txtMarca.getText() != "" ;

    }
}
