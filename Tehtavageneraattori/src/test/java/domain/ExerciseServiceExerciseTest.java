
package domain;

import exercisegenerator.domain.ExerciseService;
import exercisegenerator.domain.ExerciseSet;
import exercisegenerator.domain.User;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExerciseServiceExerciseTest {
    FakeExerciseSetDao exerciseSetDao;
    FakeQuestionDao questionDao;
    FakeUserDao userDao;
    ExerciseService exService;
    
    @Before
    public void setUp() {
        exerciseSetDao = new FakeExerciseSetDao();
        questionDao = new FakeQuestionDao();
        userDao = new FakeUserDao();
        User user = new User("Heimo", "kissa");
        userDao.create(user);       
        exService = new ExerciseService(exerciseSetDao, userDao, questionDao);     
        exService.login("Heimo", "kissa");
    }
    
    @Test
    public void atStartListContainsOneExerciseSet() {
        List<ExerciseSet> exercises = exerciseSetDao.getAll();
        
        assertEquals(1, exercises.size());
        ExerciseSet exSet = exercises.get(0);
        assertEquals("Matikka", exSet.getName());    
    }
    
 
}