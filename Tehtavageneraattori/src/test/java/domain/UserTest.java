
package domain;


import exercisegenerator.domain.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    @Test
    public void usersAreEqualWhenUsernamesAndPasswordsMatch() {
        User user1 = new User("Heimo", "kissa");
        User user2 = new User("Heimo", "kissa");
        
        assertEquals(user1, user2);
    }
    
    @Test
    public void usersAreNotEqualsWhenPasswordsAreNotEqual() {
        User user1 = new User("Heimo", "kissa");
        User user2 = new User("Heimo", "koira");
        
        assertFalse(user1.equals(user2));
    }
    
    @Test
    public void usersAreNotEqualsWhenUsernamesAreNotEqual() {
        User user1 = new User("Heimo", "kissa");
        User user2 = new User("Huima", "kissa");
        
        assertFalse(user1.equals(user2));
    } 
    
}
