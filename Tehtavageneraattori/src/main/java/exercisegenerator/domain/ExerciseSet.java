
package exercisegenerator.domain;

import java.util.ArrayList;

/**
* Yksittäistä tehtäväsarjaa kuvaava luokka
* 
*/
public class ExerciseSet {
    private String name;
    private String createdBy;
    private ArrayList<Question> questions;
    
    public ExerciseSet() {
        this.name = null;
        this.createdBy = null;
        this.questions = new ArrayList<Question>();
    }
    
    public ExerciseSet(String name, String createdBy, ArrayList<Question> questions) {
        this.name = name;
        this.createdBy = createdBy;
        this.questions = new ArrayList<Question>();
        for (Question q: questions) {
            this.questions.add(q);
        }
    }
    
    /**
     * Metodi tarkistaa, onko syöttikö käyttäjä tehtäväsarjalle ei-sallitun nimen tai jäikö kenttä tyhjäksi.
     *
     * @return True mikäli nimi oli sallittu, muuten false.
     */
    public boolean nameValidation() {
        if (this.name == null || !this.name.matches("^[^;]+$")) {
            return false;
        } else {
            return true;
        }
        
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }  

    public String getCreatedBy() {
        return createdBy;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    
    
    public void addQuestion(Question q) {
        this.questions.add(q);
    }
   
     /**
     * Metodi käy läpi sarjan kysymykset ja lisää niihin sarjan nimitunnisteen. Metodia hyödynnetään sarjan luomisen yhteydessä.
     * 
     */
    public void setNameToQuestions() {
        for (Question q: questions) {
            q.setSetName(name);
        }
    }
    
    /**
     * Metodi käy läpi sarjan kysymykset ja alustaa ne vastaamattomiksi/vääriksi.
     */
    public void resetCorrectAnswers() {
        for (Question q: questions) {
            q.setCorrect(false);
        }
    }
    
    /**
     * Metodi käy läpi sarjan kysymykset ja laskee moneenko on vastattu oikein.
     * 
     * @return Oikein vastattujen kysymysten lukumäärä
     */
    public int countPoints() {
        int points = 0;
        
        for (Question q: questions) {
            if (q.isCorrect()) {
                points++;
            }
        } 
        
        return points;
    }
    
    /**
     * Metodi käy läpi sarjan kysymykset ja palauttaa listan väärin vastatuista kysymyksistä.
     * 
     * @return Lista väärin vastatuista/vastaamattomista tehtävistä
     */
    public ArrayList<Question> getIncorrect() {
        ArrayList<Question> incorrect = new ArrayList<>();
        
        for (Question q: questions) {
            if (!q.isCorrect()) {
                incorrect.add(q);
            }
        }
        
        return incorrect;
    }
}
