
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
        exService = new ExerciseService(null, userDao);     
    }
    
    @Test
    public void userRegistrationFailsIfNameIsNotUnique() throws Exception {
        User testUser = new User("Heimo", "koira");
        
        boolean result = exService.createUser(testUser);
        assertFalse(result);
    }
}
