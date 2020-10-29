/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AuthentificatiorDAO;
import model.UserDTO;

import view.Vista_login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class Controlador_login implements ActionListener {
    private Vista_login view;
    private UserDTO user;
    private AuthentificatiorDAO aut;
    
    
    public Controlador_login(Vista_login view,UserDTO user,AuthentificatiorDAO aut){
        this.view = view;
        this.user = user;
        this.aut = aut;
        this.view.boton_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user.setUser_name(view.texto_username.getText());
        user.setPassword(String.valueOf(view.texto_password.getPassword()));
        if(aut.authentic(user)){
            view.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "user not found");
        }
    }
    
    public void init(){
        this.view.setLocationRelativeTo(null);
        view.setTitle("LOGN_SCREEN");
        this.view.setVisible(true);

        
    }
    
    
}
