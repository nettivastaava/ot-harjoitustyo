
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
    
    public FileExerciseSetDao(String file, String anotherFile) throws Exception {
        exercises = new ArrayList<>();
        this.file = file;
        this.file2 = anotherFile;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                String exName = parts[0];
                ArrayList<Question> questions = new ArrayList<>();
                Scanner reader2 = new Scanner(new File(file2));
                while (reader2.hasNextLine()) {
                    String[] parts2 = reader2.nextLine().split(";");
                    if (parts2[0].equals(exName) && parts2.length == 4) {
                        questions.add(new Question(parts[0], parts2[1], parts2[2], parts2[3]));
                    } else if (parts2[0].equals(exName)) {
                        questions.add(new Question(parts[0], parts2[1], parts2[2]));
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
        for (ExerciseSet ex: exercises) {
            if (ex.getName().equals(setName)) {
                return ex;
            }
        }
        return null;
    }
        
    public ExerciseSet create(ExerciseSet exSet) throws Exception {
        exercises.add(exSet);
        save();
        return exSet;
    }
    
}
