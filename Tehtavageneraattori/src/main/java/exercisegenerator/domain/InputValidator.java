package exercisegenerator.domain;

public class InputValidator {
    
    public boolean questionValidation(String word) {
        if (word.equals("") || !word.matches("^[^;]+$")) {
            return false;
        }
        return true;
    }
}
