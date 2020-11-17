
package exercisegenerator.domain;

import java.util.ArrayList;


public class ExerciseSet {
    private String name;
    private ArrayList<Question> questions;
    
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
}
