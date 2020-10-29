/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author f_fig
 */
public interface AdminDAO {

    public boolean insert(UserDTO user);

    public UserDTO delete(int userId);

    public boolean update(UserDTO user);

    public UserDTO select(int userId);

}
