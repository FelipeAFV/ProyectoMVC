/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.arrays.ArrayData;

/**
 *
 * @author f_fig
 */
public class TeacherBBDD implements TeacherDAO {

    Connection conn;

    @Override
    public Equipment searchById(int id) {
        try {

            String query = "SELECT eqp_id, eqp_name, status, brand, year"
                    + " FROM EQUIPMENT WHERE eqp_id = ?";
            PreparedStatement ps = conn.connect().prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Equipment eqp = null;
            if (rs.next()) {
                int eqpId = rs.getInt("EQP_ID");
                String eqpName = rs.getString("EQP_NAME");
                String status = rs.getString("STATUS");
                String brand = rs.getString("BRAND");
                String year = rs.getString("YEAR");
                eqp = new Equipment()
                        
            }
            return eqp;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            conn.disconnect();
        }
    }

    @Override
    public ArrayList<Equipment> searchByClassroom(int classroomId) {
        try {

            String query = "SELECT eqp_id, eqp_name, status, brand, year"
                    + " FROM EQUIPMENT WHERE classroom_id = ?";
            PreparedStatement ps = conn.connect().prepareStatement(query);
            ps.setInt(1, classroomId);

            ResultSet rs = ps.executeQuery();

            ArrayList<Equipment> equipments = new ArrayList<Equipment>;
            while (rs.next()) {
                int eqpId = rs.getInt("EQP_ID");
                String eqpName = rs.getString("EQP_NAME");
                String status = rs.getString("STATUS");
                String brand = rs.getString("BRAND");
                String year = rs.getString("YEAR");
                equipments = new Equipment();
                equipments.add(eqp);
                        
            }
            return equipments;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            conn.disconnect();
        }
    }

}
