package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EncargadoDAOImpl extends Conexion implements EncargadoDAO {

    @Override
    public boolean insertEquipment(EquipmentBBDD equip) {
        try {
            this.getConexion();
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO Equipment VALUES(?,?,?,?,?,?)");
            ps.setInt(1, equip.getEqp_id());
            ps.setInt(2, equip.getClassroom_id());
            ps.setString(3, equip.getEqp_name());
            ps.setString(4, equip.getStatus());
            ps.setString(5, equip.getBrand());
            ps.setString(6, equip.getYear());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                this.con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public boolean updateEquipment(EquipmentBBDD equip) {
        try {
            this.getConexion();
            PreparedStatement ps = this.con.prepareStatement("UPDATE Equipment SET classroom_id = ?, eqp_name = ?, status = ?, brand = ?, year = ? WHERE eqp_id = ?");
            ps.setInt(1, equip.getClassroom_id());
            ps.setString(2, equip.getEqp_name());
            ps.setString(3, equip.getStatus());
            ps.setString(4, equip.getBrand());
            ps.setString(5, equip.getYear());
            ps.setInt(6, equip.getEqp_id());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                this.con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public boolean deleteEquipment(EquipmentBBDD equip) {
        try {
            this.getConexion();
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM Equipment WHERE eqp_id = ?");
            ps.setInt(1, equip.getEqp_id());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                this.con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public ArrayList<EquipmentBBDD> listar() {
        try {
            ArrayList<EquipmentBBDD> lista = new ArrayList<>();
            this.getConexion();
            Statement ps = this.con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM Equipment");
            while(rs.next()){
                EquipmentBBDD equipo = new EquipmentBBDD();
                equipo.setEqp_id(rs.getInt("eqp_id"));
                equipo.setClassroom_id(rs.getInt("classroom_id"));
                equipo.setEqp_name(rs.getString("eqp_name"));
                equipo.setStatus(rs.getString("status"));
                equipo.setBrand(rs.getString("brand"));
                equipo.setYear(rs.getString("year"));
                lista.add(equipo);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                this.con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
