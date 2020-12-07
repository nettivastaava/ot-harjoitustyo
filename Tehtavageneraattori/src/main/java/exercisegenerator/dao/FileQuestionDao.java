
package exercisegenerator.dao;

import exercisegenerator.domain.Question;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Kysymysten pysyväistalletuksesta huolehtiva luokka
*/
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
                if (parts.length == 4) {
                    Question q = new Question(parts[0], parts[1], parts[2], parts[3]);
                    questions.add(q);
                } else {
                    Question q = new Question(parts[0], parts[1], parts[2]);
                    questions.add(q);
                }
                
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    /**
    * Kirjoittaa luodun kysymyksen, vastauksen ja mahdollisen vihjeen tiedostoon erotettuna ;-merkillä
    */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Question q: questions) {
                if (q.getHint() == null) {
                    writer.write(q.getSetName() + ";" + q.getQuestion() + ";" + q.getAnswer() + "\n");
                } else {
                    writer.write(q.getSetName() + ";" + q.getQuestion() + ";" + q.getAnswer() + ";" + q.getHint() + "\n");
                }
            }           
        } 
    }
    
    /**
    * Lisää kysymyksen listalle  ja kutsuu save()-metodia
    * 
    * @param q Listalle lisättävä kysymys
    * 
    * @return parametrina annettu kysymysolio
    */
    @Override
    public Question create(Question q) throws Exception {
        questions.add(q);
        save();
        return q;
    }

    /**
    * Etsii ja palauttaa järjestelmästä kaikki tiettyyn tehtäväsarjaan kuuluvat kysymykset listana
    * 
    * @param set Tehtäväsarjan nimeä vastaava merkkijono
    * 
    * @return Lista tehtäväsarjaan kuuluvista kysymyksistä
    */
    @Override
    public List findBySetName(String set) {
        ArrayList<Question> list = new ArrayList<>();
        for (Question q: questions) {
            if (q.getSetName().equals(set)) {
                list.add(q);
            }
        }
        return list;
    }
   
}
