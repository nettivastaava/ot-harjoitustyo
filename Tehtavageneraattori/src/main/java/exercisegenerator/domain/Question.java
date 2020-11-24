
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
    
    public boolean answerQuestion(String attempt) {
        return this.answer.equals(attempt);
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
