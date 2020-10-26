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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(e)) {
            int id = Integer.parseInt(adminView.txtId.getText());
            UserDTO user = adminDao.select(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario encontrado:\n"+ user.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        } else if (e.getSource().equals(e)) {
            int id = Integer.parseInt(adminView.txtId.getText());
            String userName = adminView.txtUserName.getText;
            String password = adminView.txtPassword.getText;
            String jobTitle = adminView.txtJobTitle.getText;
            
            UserDTO user = new UserDTO();
            user.setUser_id(id);
            user.setUser_name(userName);
            user.setPassword(password);
            user.setJob_title(jobTitle);
            if(adminDao.insert(user)) {
                JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
            }
            
        } else if (e.getSource().equals(e)) {
            int id = Integer.parseInt(adminView.txtId.getText());
            UserDTO user = adminDao.delete(id);
            if (user != null) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado:\n"+ user.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
            
        } else if (e.getSource().equals(e)) {
            int id = Integer.parseInt(adminView.txtId.getText());
            String userName = adminView.txtUserName.getText;
            String password = adminView.txtPassword.getText;
            String jobTitle = adminView.txtJobTitle.getText;
            
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
        if (adminView.btb) {
            
        }
    }
    
    
    
    
}
