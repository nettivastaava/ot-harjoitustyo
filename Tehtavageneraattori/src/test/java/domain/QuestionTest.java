
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
    public void questionFeedback() {
        assertEquals("CORRECT", q.answerQuestion("2"));
        assertEquals("Mandatory field missing.", q.answerQuestion(""));
        assertEquals("Wrong answer. You may try again.", q.answerQuestion("1"));
    }
    
    @Test
    public void questionCantBeEmpty() {
        Question question = new Question("", "Kanada");
        
        assertFalse(question.questionValidation());
    }
    
    @Test
    public void answerCantBeEmpty() {
        Question question = new Question("Onko maa litteä?", "");
        
        assertFalse(question.questionValidation());
    }
    
    @Test
    public void validAnswerReturnsTrue() {
        Question question = new Question("2+2?", "4");
        
        assertTrue(question.questionValidation());
    }
    
}
