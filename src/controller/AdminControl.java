/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AdminDAO;
import model.UserDTO;
import view.AdminView;

/**
 *
 * @author f_fig
 */
public class AdminControl implements ActionListener {

    private AdminView adminView;
    private AdminDAO adminDao;

    public AdminControl(AdminView adminView, AdminDAO adminDao) {
        this.adminView = adminView;
        this.adminDao = adminDao;
        adminView.jButton1.addActionListener(this);
        adminView.jButton2.addActionListener(this);
        adminView.jButton3.addActionListener(this);
        adminView.jButton4.addActionListener(this);
    }

    public void begin() {
        adminView.setTitle("Sistema Admin");
        adminView.setLocationRelativeTo(null);
        adminView.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(adminView.jButton4)) {
            String value = adminView.jTextField3.getText();
            if (value == "") {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(value);
            UserDTO user = adminDao.select(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" + user.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        } else if (e.getSource().equals(adminView.jButton2)) {
            if (!checkInput()) {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(adminView.jTextField3.getText());
            String userName = adminView.jTextField1.getText();
            String password = adminView.jTextField2.getText();
            String jobTitle = (String) adminView.jComboBox2.getSelectedItem();

            UserDTO user = new UserDTO();
            user.setUser_id(id);
            user.setUser_name(userName);
            user.setPassword(password);
            user.setJob_title(jobTitle);
            if (adminDao.insert(user)) {
                JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
            }

        } else if (e.getSource().equals(adminView.jButton3)) {
            String value = adminView.jTextField3.getText();
            if (value == "") {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(value);
            UserDTO user = adminDao.delete(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado:\n" + user.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }

        } else if (e.getSource().equals(adminView.jButton1)) {
            if (!checkInput()) {
                JOptionPane.showMessageDialog(null, "Ingrese todo los campos necesarios para la operacion");
                return;
            }
            int id = Integer.parseInt(adminView.jTextField3.getText());
            String userName = adminView.jTextField1.getText();
            String password = adminView.jTextField2.getText();
            String jobTitle = (String) adminView.jComboBox2.getSelectedItem();

            UserDTO user = new UserDTO();
            user.setUser_id(id);
            user.setUser_name(userName);
            user.setPassword(password);
            user.setJob_title(jobTitle);

            if (adminDao.update(user)) {
                JOptionPane.showMessageDialog(null, "Usuario modificado");
            }
        }
    }

    public boolean checkInput() {
        return adminView.jTextField1.getText() != "" && adminView.jTextField2.getText() != ""
                && adminView.jTextField3.getText() != "" && adminView.jComboBox2.getSelectedItem() != null;

    }

}
