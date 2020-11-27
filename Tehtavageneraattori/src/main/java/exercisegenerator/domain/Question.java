
package exercisegenerator.domain;


public class Question {
    private String setName;
    private String question;
    private String hint;
    private String answer;
    
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
    
    public String answerQuestion(String attempt) {
        if (attempt.equals("")) {
            return "Mandatory field missing";
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
    
    
          
} 
