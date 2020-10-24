/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.BorderLayout;
import java.awt.print.PrinterException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.TeacherView;

/**
 *
 * @author f_fig
 */
public class Main {

    public static void main(String[] args) throws PrinterException {

        TeacherView tv = new TeacherView();
        /*String[] names = {"Nombre", "Apellido"};
        Object[][] data = {{"Felipe","Figueroa"}};
        JTable jTable = new JTable(data,names);
        tv.jScrollPane2.add(jTable);*/
        
        tv.setVisible(true);
   

      
    }
}
