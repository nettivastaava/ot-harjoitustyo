package dao;

import exercisegenerator.dao.ExerciseSetDao;
import exercisegenerator.dao.FileExerciseSetDao;
import exercisegenerator.dao.QuestionDao;
import exercisegenerator.domain.ExerciseSet;
import exercisegenerator.domain.Question;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

public class FileExerciseSetDaoTest {
    @Rule   
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File exerciseFile;  
    File questionFile;
    ExerciseSetDao exerciseDao;
    QuestionDao questionDao;
    ExerciseSet exSet;
    
    @Before
    public void setUp() throws Exception {
        exerciseFile = testFolder.newFile("testfile_exercises.txt");  
        questionFile = testFolder.newFile("testfile_questions.txt");
        
        try (FileWriter file = new FileWriter(exerciseFile.getAbsolutePath())) {
            file.write("Matematiikka\n");
        }
        
        try (FileWriter file = new FileWriter(questionFile.getAbsolutePath())) {
            file.write("Matematiikka;1+1?;2\n");
            file.write("Matematiikka;5-2?;3");
        }
        
        exerciseDao = new FileExerciseSetDao(exerciseFile.getAbsolutePath(), questionFile.getAbsolutePath());
        exSet = exerciseDao.findOne("Matematiikka");
    }    
    
    @Test
    public void exercisesAreReadCorrectlyFromFile() {
        List<ExerciseSet> ex = exerciseDao.getAll();
        assertEquals(1, ex.size());
        ExerciseSet set = ex.get(0);
        assertEquals("Matematiikka", set.getName());
        assertEquals(2, set.getQuestions().size());
    }
    
    @Test
    public void exerciseSetIsFound() {
        ExerciseSet setToBeFound = exerciseDao.findOne("Matematiikka");

        assertEquals(exSet.getName(), setToBeFound.getName());
    }
    
    @Test
    public void nonExistingSetIsNotFound() {
        ExerciseSet exSet2 = exerciseDao.findOne("Kemia");
        
        assertEquals(exSet2, null);
    }
    
    @Test
    public void savedExerciseSetIsFound() throws Exception {
        ExerciseSet setToBeCreated = new ExerciseSet();
        setToBeCreated.setName("Fysiikka");

        exerciseDao.create(setToBeCreated);
        
        ExerciseSet found = exerciseDao.findOne("Fysiikka");
        assertEquals(found.getName(), "Fysiikka");
    }
    
    @After
    public void tearDown() {
        exerciseFile.delete();
    }
    
}
