/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.domain;

import exercisegenerator.dao.ExerciseSetDao;
import exercisegenerator.dao.UserDao;

public class ExerciseService {
    private ExerciseSetDao exerciseSetDao;
    private UserDao userDao;
    private User loggedUser;
    
    public ExerciseService(ExerciseSetDao exerciseSetDao, UserDao userDao) {
        this.exerciseSetDao = exerciseSetDao;
        this.userDao = userDao;       
    }
    
    public boolean createUser(User user)  {   
        System.out.println("1");
        if (userDao.findByUsername(user.getUsername()) != null) {
            return false;
        }
        System.out.println("2");
        try {
            userDao.create(user);
        } catch(Exception e) {
            return false;
        }
        System.out.println("3");
        return true;
    }
}
