
package domain;


import exercisegenerator.domain.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    @Test
    public void usersAreEqualWhenUsernamesMatch() {
        User user1 = new User("Heimo");
        User user2 = new User("Heimo");
        
        assertEquals(user1, user2);
    }
    
    @Test
    public void usersAreNotEqualsWhenUsernamesDoesntMatch() {
        User user1 = new User("Heimo");
        User user2 = new User("Huima");
        assertFalse(user1.equals(user2));
    } 
    
}
