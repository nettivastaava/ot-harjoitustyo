package domain;

import exercisegenerator.dao.ExerciseSetDao;
import exercisegenerator.domain.ExerciseSet;
import java.util.ArrayList;
import java.util.List;

public class FakeExerciseSetDao implements ExerciseSetDao {
    List<ExerciseSet> exercises;
    
    public FakeExerciseSetDao() {
        exercises = new ArrayList<>();
        exercises.add(new ExerciseSet("Matikka", "Heimo", new ArrayList<>()));
    }

    @Override
    public ExerciseSet create(ExerciseSet ex) throws Exception {
        exercises.add(ex);
        return ex;
    }

    @Override
    public List<ExerciseSet> getAll() {
        return exercises;
    }

    @Override
    public ExerciseSet findOne(String setName) {
        for (ExerciseSet ex: exercises) {
            if (ex.getName().equals(setName)) {
                return ex;
            }
        }
        return null;
        
    }
    
}
