/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.arrays.ArrayData;

/**
 *
 * @author f_fig
 */
public class TeacherBBDD implements TeacherDAO {

    private Conexion conn = new Conexion();
    private Connection connection;

    @Override
    public EquipmentBBDD searchById(int id) {
        
        try {

            String query = "SELECT eqp_id, eqp_name, status, brand, year"
                    + " FROM equipment WHERE eqp_id = ?";
            connection = conn.getConexion();
            if (connection != null) {
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
            }
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            EquipmentBBDD eqp = null;
            if (rs.next()) {
                
                int eqpId = rs.getInt("EQP_ID");
                String eqpName = rs.getString("EQP_NAME");
                String status = rs.getString("STATUS");
                String brand = rs.getString("BRAND");
                String year = rs.getString("YEAR");
                eqp = new EquipmentBBDD();
                eqp.setEqp_id(eqpId);
                eqp.setEqp_name(eqpName);
                eqp.setStatus(status);
                eqp.setBrand(brand);
                eqp.setYear(year);
                        
            }
            
            return eqp;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public ArrayList<EquipmentBBDD> searchByClassroom(int classroomId) {
        try {

            String query = "SELECT eqp_id, eqp_name, status, brand, year"
                    + " FROM EQUIPMENT WHERE classroom_id = ?";
                        connection = conn.getConexion();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, classroomId);

            ResultSet rs = ps.executeQuery();

            ArrayList<EquipmentBBDD> equipments = new ArrayList<>();
            while (rs.next()) {
                int eqpId = rs.getInt("EQP_ID");
                String eqpName = rs.getString("EQP_NAME");
                String status = rs.getString("STATUS");
                String brand = rs.getString("BRAND");
                String year = rs.getString("YEAR");
                EquipmentBBDD eqp = new EquipmentBBDD();
                eqp.setEqp_id(eqpId);
                eqp.setEqp_name(eqpName);
                eqp.setStatus(status);
                eqp.setBrand(brand);
                eqp.setYear(year);
                equipments.add(eqp);
                        
            }
            return equipments;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

}
