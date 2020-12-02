package exercisegenerator.domain;

/**
* Käyttäjän syötteiden validointiin käytettävä luokka
* 
*/
public class InputValidator {
    
    public boolean questionValidation(String word) {
        if (word.equals("") || !word.matches("^[^;]+$")) {
            return false;
        }
        return true;
    }
}
