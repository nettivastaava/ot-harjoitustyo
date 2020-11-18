/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.dao;

import exercisegenerator.domain.ExerciseSet;
import exercisegenerator.domain.Question;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExerciseSetDao implements ExerciseSetDao {
    private List<ExerciseSet> exercises;
    private String file;
    
    public FileExerciseSetDao(String file) throws Exception {
        exercises = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                String exName = parts[0];
                ArrayList<Question> questions = new ArrayList<>();
                for(int i=1;i<parts.length;i+=2) {
                    questions.add(new Question(parts[i], parts[i+1]));
                }
                exercises.add(new ExerciseSet(exName, questions));
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }    
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (ExerciseSet exSet : exercises) {
                writer.write(exSet.getName());
                for (Question q: exSet.getQuestions()) {
                    writer.write(";" + q.getQuestion() + ";" + q.getAnswer());
                }
            }
        } 
    }

    public List<ExerciseSet> getAll() {
        return exercises;
    }


    public ExerciseSet findOne(String setName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ExerciseSet create(ExerciseSet exSet) throws Exception {
        exercises.add(exSet);
        save();
        return exSet;
    }
    
}
