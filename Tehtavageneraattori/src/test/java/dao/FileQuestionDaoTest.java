
package dao;

import exercisegenerator.dao.ExerciseSetDao;
import exercisegenerator.dao.FileExerciseSetDao;
import exercisegenerator.dao.FileQuestionDao;
import exercisegenerator.dao.QuestionDao;
import exercisegenerator.domain.Question;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileQuestionDaoTest {
    @Rule   
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File exerciseFile;  
    File questionFile;
    ExerciseSetDao exerciseDao;
    QuestionDao questionDao;
    
    @Before
    public void setUp() throws Exception {
        exerciseFile = testFolder.newFile("testfile_exercises.txt");  
        questionFile = testFolder.newFile("testfile_questions.txt");
        
        try (FileWriter file = new FileWriter(exerciseFile.getAbsolutePath())) {
            file.write("Matematiikka\n");
        }
        
        try (FileWriter file = new FileWriter(questionFile.getAbsolutePath())) {
            file.write("Matematiikka;1+1?;2\n");
            file.write("Matematiikka;5-2?;3\n");
            file.write("Matematiikka;5*5;25;Neljännes vuosisata\n");
            file.write("Matematiikka;1+1+1;3;\n");
        }
        
        exerciseDao = new FileExerciseSetDao(exerciseFile.getAbsolutePath(), questionFile.getAbsolutePath());
        questionDao = new FileQuestionDao(questionFile.getAbsolutePath());
    }
    
    @Test
    public void listIsEmptyWithNonExistingSet() {
        List list = questionDao.findBySetName("Kemia");
        
        assertEquals(list.size(), 0);
    }
    
    @Test
    public void addedQuestionsAreListed() {
        List list = questionDao.findBySetName("Matematiikka");
        
        assertEquals(list.size(), 4);
    }
    
    @Test
    public void savedQuestionIsFound() throws Exception {
        Question questionToBeCreated = new Question ("1+1?", "2");
        questionToBeCreated.setSetName("Tosi helppo matikka");
        questionDao.create(questionToBeCreated);
        
        List<Question> list = questionDao.findBySetName("Tosi helppo matikka");
        Question q = list.get(0);
        assertEquals("1+1?", q.getQuestion());
        assertEquals("2", q.getAnswer());
    }
    
    @After
    public void tearDown() {
        exerciseFile.delete();
    }
}
