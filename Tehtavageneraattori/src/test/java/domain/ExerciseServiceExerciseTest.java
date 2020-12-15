
package domain;

import exercisegenerator.domain.ExerciseService;
import exercisegenerator.domain.ExerciseSet;
import exercisegenerator.domain.Question;
import exercisegenerator.domain.User;
import java.util.ArrayList;
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
        List<ExerciseSet> exercises = exService.exercisesList();
        
        assertEquals(1, exercises.size());
        ExerciseSet exSet = exercises.get(0);
        assertEquals("Matikka", exSet.getName());    
    }
    
    @Test
    public void setQuestionNameWorks() {
        List<ExerciseSet> exercises = exerciseSetDao.getAll();
        ExerciseSet exSet = exercises.get(0);
        exSet.addQuestion(new Question("1+1?", "2"));
        Question q = exSet.getQuestions().get(0);
        
        assertEquals(null, q.getSetName());
        exSet.setNameToQuestions();
        assertEquals("Matikka", q.getSetName());
    }
    
    @Test
    public void exerciseSetCreationFailsWithLessThanFourQuestions() throws Exception {
        ArrayList<Question> questions = returnQuestionList(3);     
        
        ExerciseSet exSet = new ExerciseSet("Matikka II", "Heimo", questions);
        boolean result = exService.createExerciseSet(exSet);
        assertFalse(result);
    }
    
    public ArrayList<Question> returnQuestionList(int size) {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0;i<size;i++) {
            questions.add(new Question(i+" 1?", String.valueOf(i+1)));
        }
        return questions;
    }
    
    @Test
    public void exerciseSetCreationFailsWhenSetNameIsNotUnique() throws Exception {
        ArrayList<Question> questions = returnQuestionList(4);
        
        ExerciseSet exSet = new ExerciseSet("Matikka", "Heimo", questions);
        boolean result = exService.createExerciseSet(exSet);
        assertFalse(result);
    }
    
    @Test
    public void validExerciseSetCanBeCreated() throws Exception {
        ArrayList<Question> questions = returnQuestionList(4);
        
        ExerciseSet exSet = new ExerciseSet("Matikka II", "Heimo", questions);
        boolean result = exService.createExerciseSet(exSet);
        assertTrue(result);
    }
 
}
