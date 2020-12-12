package domain;

import exercisegenerator.domain.Question;
import exercisegenerator.domain.ExerciseSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseSetTest {
    ExerciseSet exSet;
    
    @Before
    public void setUp() {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i=0;i<4;i++) {
            questions.add(new Question(i+" 1?", String.valueOf(i+1)));
        }
        
        exSet = new ExerciseSet("Matikka", questions);
        
    }
    
    @Test
    public void questionsAreNotCorrectAtStart() {
        assertEquals(4, exSet.getIncorrect().size());
    }
    
    @Test
    public void onlyIncorrectAreReturned() {
        Question q = exSet.getQuestions().get(0);
        q.setCorrect(true);
        
        assertEquals(3, exSet.getIncorrect().size());
    }
    
    @Test
    public void pointsAreCountedCorrectly() {
        assertEquals(0, exSet.countPoints());
        exSet.getQuestions().get(0).setCorrect(true);
        assertEquals(1, exSet.countPoints());
    }
    
    @Test
    public void resetCorrectWorks() {
         List<Question> questions = exSet.getQuestions();
         
         questions.get(0).setCorrect(true);
         exSet.resetCorrectAnswers();
         
         for (Question q: questions) {
             assertFalse(q.isCorrect());
         }
    }
}
