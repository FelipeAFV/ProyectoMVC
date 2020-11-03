/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controlador_login;
import model.AuthentificatiorDAO;
import model.UserDTO;
import view.Vista_login;



/**
 *
 * @author f_fig
 */
public class Main {

    public static void main(String[] args) {
        
        Controlador_login control = new Controlador_login(new Vista_login(), new UserDTO(), new AuthentificatiorDAO());
        control.init();
      
    }
}
