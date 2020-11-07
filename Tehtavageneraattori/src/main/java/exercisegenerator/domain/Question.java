
package exercisegenerator.domain;


public class Question {
    private String question;
    private String hint;
    private String answer;
    
    public Question(String question, String answer) {
        this.question = question;
        this.hint=null;
        this.answer = answer;
    }
    
    public Question(String question, String hint, String answer) {
        this.question = question;
        this.hint = hint;
        this.answer = answer;
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
      
} 
