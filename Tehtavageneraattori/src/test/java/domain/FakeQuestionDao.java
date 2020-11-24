package domain;

import exercisegenerator.dao.QuestionDao;
import exercisegenerator.domain.Question;
import java.util.ArrayList;
import java.util.List;


public class FakeQuestionDao implements QuestionDao {
    List<Question> questions;
    
    public FakeQuestionDao() {
        questions = new ArrayList<>();
        questions.add(new Question("Matikka", "6+6?", "12"));
        questions.add(new Question("Matikka", "5-3?", "2", "Enemmän kuin 1"));
        questions.add(new Question("Matikka", "1*6", "6", "Et tarvitse vihjettä"));
        questions.add(new Question("Matikka", "2*2*2?", "8"));
    }
    
    @Override
    public Question create(Question q) throws Exception {
        questions.add(q);
        return q;
    }

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
