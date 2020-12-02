
package exercisegenerator.domain;

import java.util.ArrayList;

/**
* Yksittäistä tehtäväsarjaa kuvaava luokka
* 
*/
public class ExerciseSet {
    private String name;
    private ArrayList<Question> questions;
    
    public ExerciseSet() {
        this.name = null;
        this.questions = new ArrayList<Question>();
    }
    
    public ExerciseSet(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = new ArrayList<Question>();
        for (Question q: questions) {
            this.questions.add(q);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
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
}
