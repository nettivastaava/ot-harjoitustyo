
package domain;

import exercisegenerator.domain.ExerciseService;
import exercisegenerator.domain.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExerciseServiceUserTest {
    ExerciseService exService;
    FakeUserDao userDao;
    
    @Before
    public void setUp() {
        
        userDao = new FakeUserDao();
        exService = new ExerciseService(null, userDao, null);     
    }
    
    @Test
    public void userRegistrationFailsIfUsernameIsNotUnique() throws Exception {
        User testUser = new User("Heimo", "koira");
        
        boolean result = exService.createUser(testUser);
        assertFalse(result);
    }
    
    @Test
    public void userRegistrationSucceedsWhenUsernameIsValid() throws Exception {
        User testUser = new User("Huima", "koira");
        
        boolean result = exService.createUser(testUser);
        assertTrue(result);
    }
    
    @Test
    public void userRegistrationFailsWithInvalidCredentials() throws Exception {
        User testUser = new User("Mo", "123");
        
        boolean result = exService.createUser(testUser);
        assertFalse(result);
    }
    
    @Test
    public void loginFailsWithWrongPassword() throws Exception {
        boolean result = exService.login("Heimo", "salasana");
        assertFalse(result);
        
        assertEquals(null, exService.getLoggedUser());
    }
    
    @Test
    public void loginSucceedsWithCorrectCredentials() throws Exception {
        boolean result = exService.login("Heimo", "kissa");
        assertTrue(result);       
        
        assertNotEquals(null, exService.getLoggedUser());
    }
    
    @Test
    public void userCanLogout() {
        exService.login("Heimo", "kissa");
        exService.logout();
        
        assertEquals(null, exService.getLoggedUser());
    }    
}
