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
import javax.swing.JOptionPane;

/**
 *
 * @author f_fig
 */
public class AdminBBDD implements AdminDAO {

    private Conexion conn = new Conexion();
    private Connection connection;

    @Override
    public boolean insert(UserDTO user) {

        try {

            String query = "INSERT INTO CLIENTS(client_id, client_name, password, job_title) VALUES(?,?,?,?)";
            connection = conn.getConexion();
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, user.getUser_id());
            ps.setString(2, user.getUser_name());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getJob_title());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar el Usuario: " + user.getUser_name()+" \n"+ ex);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }

    @Override
    public UserDTO delete(int userId) {

        try {

            UserDTO user = select(userId);
            String query = "DELETE FROM CLIENTS WHERE client_id = ? ";
            connection = conn.getConexion();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            if (user != null) {
                ps.executeUpdate();
            }

            return user;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
    public boolean update(UserDTO user) {

        try {
            String query = "UPDATE CLIENTS SET client_name = ? , password = ?, job_title = ? WHERE client_id = ? ";
            connection = conn.getConexion();
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getJob_title());
            ps.setInt(4, user.getUser_id());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
        }

    }

    @Override
    public UserDTO select(int userId) {
        try {
            UserDTO user = null;
            String query = "SELECT * FROM CLIENTS WHERE client_id = ?";
            connection = conn.getConexion();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserDTO();
                user.setUser_id(rs.getInt("client_id"));
                user.setUser_name(rs.getString("client_name"));
                user.setPassword(rs.getString("password"));
                user.setJob_title(rs.getString("job_title"));
            }
            return user;
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


