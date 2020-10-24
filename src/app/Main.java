/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.TeacherControl;
import model.TeacherBBDD;
import view.TeacherView;

/**
 *
 * @author f_fig
 */
public class Main {

    public static void main(String[] args) {
        TeacherView tv = new TeacherView();
        TeacherBBDD tb = new TeacherBBDD();
        TeacherControl teachC = new TeacherControl(tv, tb);
        teachC.begin();

      
    }
}
