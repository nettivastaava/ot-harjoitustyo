package dao;

import exercisegenerator.dao.FileUserDao;
import exercisegenerator.dao.UserDao;
import exercisegenerator.domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;


public class FileUserDaoTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;  
    UserDao userDao;
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("Heimo;huima\n");
        }
        
        userDao = new FileUserDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void usersAreReadCorrectlyFromFile() {
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("Heimo", user.getUsername());
        assertEquals("huima", user.getPassword());
    }
   
    @Test
    public void existingUserIsFound() {
        User user = userDao.findByUsername("Heimo");
        assertEquals("Heimo", user.getUsername());
        
        User user2 = userDao.findByUsernameAndPassword("Heimo", "huima");
        assertEquals("Heimo", user2.getUsername());
    }
    
    @Test
    public void nonExistingUserIsNotFound() {
        User user = userDao.findByUsername("Jallu");
        assertEquals(null, user);
        
        User user2 = userDao.findByUsernameAndPassword("Heimo", "huimo");
        assertEquals(null, user2);
    }
    
    
    @After
    public void tearDown() {
        userFile.delete();
    }
}
