/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author samuel
 */
public class AuthentificatiorDAO extends Conection {
    public boolean authentic(UserDTO user){
        try{
          this.conectarse();  
          String username = user.getUser_name();
          String pass = user.getPassword();
          PreparedStatement pr = getConexion().prepareStatement("Select * from userp WHERE USER_NAME = ? and PASSWORD = ?");
          pr.setString(1, user.getUser_name());
          pr.setString(2, user.getPassword());
          ResultSet rs = pr.executeQuery();
          if(rs.next()){
              user.setUser_id(rs.getInt("USER_ID"));
              user.setJob_title(rs.getString("JOB_TITLE"));
              this.getConexion().close();
              pr.close();
              rs.close();
              return true;
          }
          this.getConexion().close();
          pr.close();
          rs.close();
          return false;
          
        }catch(SQLException e){
            return false;
        }
        
        
    }
}
