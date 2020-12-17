
package exercisegenerator.domain;

/**
* Yksittäistä tehtäväsarjan kysymystä kuvaava luokka
* 
*/
public class Question {
    private String setName;
    private String question;
    private String hint;
    private String answer;
    private boolean correct;
    
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    public Question(String setName, String question, String answer) {
        this.setName = setName;
        this.question = question;
        this.answer = answer;
    }
    
    public Question(String setName, String question, String answer, String hint) {
        this.setName = setName;
        this.question = question;
        this.hint = hint;
        this.answer = answer;
    }
    
     /**
     * Metodi vertaa käyttäjän antamaa vastausta kysymyksen oikeaan vastaukseen ja antaa palauttaa sen mukaan, mikä on vertailun tulos.
     *
     * @param   attempt   Käyttäjän antama syöte
     *
     * @return Vastauksen palaute.
     */
    public String answerQuestion(String attempt) {
        if (attempt.equals("")) {
            return "Mandatory field missing.";
        } else if (attempt.equals(this.answer)) {
            return "CORRECT";
        } else {
            return "Wrong answer. You may try again.";
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getHint() {
        return hint;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSetName() {
        return setName;
    }
    
    public void setSetName(String setName) {
        this.setName = setName;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
    /**
     * Metodi tarkistaa, syöttikö käyttäjä mihinkään kysymyksen luomislomakkeen syötekenttään virheellisiä arvoja tai jäikö pakollisia kenttiä täyttämättä.
     *
     * @return True mikäli arvot olivat sallittuja, false mikäli jokin kenttä sisälsi ei-sallitun arvon.
     */
    public boolean questionValidation() {
        if (this.question.equals("") || !this.question.matches("^[^;]+$") || this.answer.equals("") || !this.answer.matches("^[^;]+$")) {
            return false;
        } else if (this.hint != null && !this.hint.matches("^[^;]+$")) {
            return false;
        } else {
            return true;
        }
    }
    
    
          
} 
