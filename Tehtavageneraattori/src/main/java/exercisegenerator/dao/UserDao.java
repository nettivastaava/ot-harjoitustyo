/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.dao;

import java.util.List;
import exercisegenerator.domain.User;

public interface UserDao {
    
    User create(User user) throws Exception;

    User findByUsername(String username);

    List<User> getAll();
    
}
