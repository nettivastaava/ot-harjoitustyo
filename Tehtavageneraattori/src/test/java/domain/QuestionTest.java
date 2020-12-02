
package domain;

import exercisegenerator.domain.Question;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class QuestionTest {
    Question q;
    
    @Before
    public void setUp() {
        q = new Question("1+1?", "2");
    }
    
    @Test
    public void answeringQuestionsWork() {
        assertEquals("CORRECT", q.answerQuestion("2"));
        assertEquals("Mandatory field missing.", q.answerQuestion(""));
        assertEquals("Wrong answer. You may try again.", q.answerQuestion("1"));
    }
    
}
