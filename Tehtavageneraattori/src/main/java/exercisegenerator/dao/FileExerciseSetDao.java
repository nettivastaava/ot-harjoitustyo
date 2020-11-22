
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
    private String file2;
    
    public FileExerciseSetDao(String file, String file2) throws Exception {
        exercises = new ArrayList<>();
        this.file = file;
        this.file2=file2;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                String exName = parts[0];
                ArrayList<Question> questions = new ArrayList<>();
                Scanner reader2 = new Scanner(new File(file2));
                while(reader2.hasNextLine()) {
                    String[] parts2 = reader.nextLine().split(";");
                    if (parts[0].equals(exName) && parts2.length==4) {
                        questions.add(new Question(parts2[1], parts2[2], parts2[3]));
                    } else if (parts[0].equals(exName)) {
                        questions.add(new Question(parts2[1], parts2[2]));
                    }
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
                writer.write(exSet.getName() + "\n");
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
