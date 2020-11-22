
package exercisegenerator.domain;

import java.util.ArrayList;


public class ExerciseSet {
    private String name;
    private ArrayList<Question> questions;
    
    public ExerciseSet() {
        this.name = null;
        this.questions = new ArrayList<Question>();
    }
    
    public ExerciseSet(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
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
    
    public void setNameToQuestions() {
        for (Question q: questions) {
            q.setSetName(name);
        }
    }
}
