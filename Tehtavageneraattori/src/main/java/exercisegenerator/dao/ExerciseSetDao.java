package exercisegenerator.dao;

import exercisegenerator.domain.ExerciseSet;
import java.util.List;

public interface ExerciseSetDao {
    
    ExerciseSet create(ExerciseSet ex) throws Exception;

    List<ExerciseSet> getAll();
    
    ExerciseSet findOne(String setName);
  
}
