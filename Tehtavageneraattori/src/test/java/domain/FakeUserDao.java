
package domain;

import java.util.ArrayList;
import java.util.List;
import exercisegenerator.dao.UserDao;
import exercisegenerator.domain.User;


public class FakeUserDao implements UserDao {
     List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("Heimo", "kissa"));
    }
    
    @Override
    public User create(User user) throws Exception {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u->u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
    
}
