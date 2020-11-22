
package exercisegenerator.dao;

import exercisegenerator.domain.Question;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileQuestionDao implements QuestionDao {
    private List<Question> questions;
    private String file;
    
    public FileQuestionDao(String file) throws Exception {
        questions = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                if (parts.length==4) {
                    Question q = new Question(parts[0], parts[1], parts[2]);
                    questions.add(q);
                } else {
                    Question q = new Question(parts[0], parts[1]);
                    questions.add(q);
                }
                
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Question q: questions) {
                if (q.getHint()==null) {
                    writer.write(q.getSetName() + ";" + q.getQuestion() + ";" + q.getAnswer() + "\n");
                } else {
                    writer.write(q.getSetName() + ";" + q.getQuestion() + ";" + q.getAnswer() + ";" + q.getHint() + "\n");
                }
            }           
        } 
    }

    @Override
    public Question create(Question q) throws Exception {
        questions.add(q);
        save();
        return q;
    }

    @Override
    public String findBySetName(String set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
