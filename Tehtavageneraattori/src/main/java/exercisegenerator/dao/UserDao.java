package exercisegenerator.dao;

import java.util.List;
import exercisegenerator.domain.User;

public interface UserDao {
    
    User create(User user) throws Exception;

    User findByUsername(String username);
    
    User findByUsernameAndPassword(String username, String password);

    List<User> getAll();
    
}
