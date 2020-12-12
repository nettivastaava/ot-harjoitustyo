package exercisegenerator.domain;

import exercisegenerator.dao.ExerciseSetDao;
import exercisegenerator.dao.QuestionDao;
import exercisegenerator.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

/**
* Sovelluslogiikasta vastaava luokka
* 
*/
public class ExerciseService {
    private ExerciseSetDao exerciseSetDao;
    private UserDao userDao;
    private User loggedUser;
    private QuestionDao questionDao;
    
    public ExerciseService(ExerciseSetDao exerciseSetDao, UserDao userDao, QuestionDao questionDao) {
        this.exerciseSetDao = exerciseSetDao;
        this.userDao = userDao;       
        this.questionDao = questionDao;
    }
    
     /**
     * Metodia käytetään luomaan uusi käyttäjä.
     *  
     * @param user luotavaa käyttäjää vastaava olio
     * 
     * @return true jos käyttäjä luodaan onnistuneesti, muuten false.
     */
    public boolean createUser(User user)  {   
        if (userDao.findByUsername(user.getUsername()) != null || user.isValid() == false) {
            return false;
        }
        
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Käytetään palauttamaan kaikki järjestelmään tallennetut tehtäväsarjat
     * 
     * @return lista tehtäväsarjoista tai tyhjä lista, mikäli sarjoja ei löydy
     */
    public List<ExerciseSet> exercisesList() {
        if (loggedUser == null) {
            return new ArrayList<>();
        }
        
        return exerciseSetDao.getAll();
    }

    public ExerciseSetDao getExerciseSetDao() {
        return exerciseSetDao;
    }
    
    /**
     * Metodia käytetään luomaan uusi tehtäväsarja.
     *  
     * @param exSet luotavaa sarjaa vastaava olio
     * 
     * @return true jos sarja luodaan onnistuneesti, muuten false.
     */
    public boolean createExerciseSet(ExerciseSet exSet) {
        if (exSet.getQuestions().size() < 4 || exerciseSetDao.findOne(exSet.getName())!=null) {
            return false;
        } 
        
        try {
            exerciseSetDao.create(exSet);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Metodia käytetään luomaan uusi kysymys.
     *  
     * @param q luotavaa kysymystä vastaava olio
     * 
     * @return true jos kysymys luodaan onnistuneesti, muuten false.
     */
    public boolean createQuestion(Question q) {
        try {
            questionDao.create(q);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodilla yritetään kirjata käyttäjä sisään järjestelmään.
     * 
     * @param username käyttäjän antama syöte käyttäjätunnukselle
     * @param password käyttäjän antama syöte salasanalle
     * 
     * @return true mikäli kirjautuminen onnistuu. muuten false.
     */
    public boolean login(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) {
            loggedUser = user;
            return true;
        }
        return false;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    
     /**
     * Metodia käytetään kirjaamaan käyttäjä ulos järjestelmästä.
     * 
     */
    public void logout() {
        loggedUser = null;
    }
}
