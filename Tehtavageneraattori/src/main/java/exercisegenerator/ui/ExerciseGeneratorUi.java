package exercisegenerator.ui;

import exercisegenerator.dao.FileExerciseSetDao;
import exercisegenerator.dao.FileQuestionDao;
import exercisegenerator.dao.FileUserDao;
import exercisegenerator.domain.ExerciseService;
import exercisegenerator.domain.ExerciseSet;
import exercisegenerator.domain.Question;
import exercisegenerator.domain.User;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
* Sovelluksen käyttöliittymä
*/
public class ExerciseGeneratorUi extends Application {
    private Scene loginScene;
    private Scene registerScene;
    private Scene exercisesScene;
    private Scene createExerciseScene;
    private Scene solveExerciseScene;
    private Scene resultScene;
    
    private ExerciseService exService;
    private ArrayList<Question> toBeAdded;
    private VBox exerciseSets;
    private VBox answerSheet;
    private VBox resultPane;
   
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();  
        properties.load(new FileInputStream("config.properties"));
        
        String userFile = properties.getProperty("userFile");
        String exerciseFile = properties.getProperty("exerciseFile");
        String questionFile = properties.getProperty("questionFile");
        
        FileUserDao userDao = new FileUserDao(userFile);  
        FileExerciseSetDao exerciseDao = new FileExerciseSetDao(exerciseFile, questionFile);
        FileQuestionDao questionDao = new FileQuestionDao(questionFile);
        
        answerSheet = new VBox(10);
        exService = new ExerciseService(exerciseDao, userDao, questionDao);
        toBeAdded = new ArrayList<>();
        resultPane = new VBox(10);
    }
    
    public Node createQuestionNode(Question q) {
        VBox box = new VBox(10);
        HBox hintBox = new HBox(10);
        HBox answerBox = new HBox(10);
        Label question = new Label(q.getQuestion());
        Label message = new Label();
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        Button hintButton = new Button("Hint");
        hintButton.setOnAction(e-> {
           message.setText(q.getHint());
           message.setTextFill(Color.BLACK);
        });
        Label answerLabel = new Label("Answer");
        TextField answerInput = new TextField();
        Button answerButton = new Button("Submit");    
        answerButton.setOnAction(e-> {
            String answer = answerInput.getText();
            message.setText(q.answerQuestion(answer));
            if (message.getText().equals("CORRECT")) {
                message.setTextFill(Color.GREEN);
                q.setCorrect(true);
            } else {
                message.setTextFill(Color.RED);
                q.setCorrect(false);
            }
        });
        if (q.getHint()!=null) {
            hintBox.getChildren().addAll(hintButton, message);
        } else {  
            hintBox.getChildren().addAll(message);       
        }   
        answerBox.getChildren().addAll(answerLabel, answerInput, answerButton);
        box.getChildren().addAll(question, hintBox, answerBox, spacer);
        return box;
    }
    
    public void solveExercise(ExerciseSet ex, Stage window) {       
        answerSheet.getChildren().clear();
        List<Question> questions = ex.getQuestions();
        questions.forEach(q-> {
            answerSheet.getChildren().add(createQuestionNode(q));
        });  
        Button finish = new Button("Finished");
        answerSheet.getChildren().addAll(finish);
        finish.setOnAction(e-> {
            window.setScene(resultScene);
            showPoints(ex, window);
        });
    }
    
    public Node createCorrectAnswerNode(Question q) {
        VBox vbox = new VBox(10);
        HBox questionBox = new HBox(10);
        HBox answerBox = new HBox(10);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        
        questionBox.getChildren().addAll(new Label("Question: " + q.getQuestion()));
        answerBox.getChildren().addAll(new Label("Answer: " +q.getAnswer()));
        vbox.getChildren().addAll(questionBox, answerBox, spacer);
        
        return vbox;
    }
    
    public void showPoints(ExerciseSet exSet, Stage window) {
        resultPane.getChildren().clear();
        HBox hbox = new HBox(10);
        VBox correctAnswers = new VBox(10);
        int points = exSet.countPoints();
        Button toMenu = new Button("Return to main menu");
        Button showCorrectButton = new Button("Show correct answers");
        HBox showButtonBox = new HBox(10);
        
        toMenu.setOnAction(e-> {
            exSet.resetCorrectAnswers();
            window.setScene(exercisesScene);
        });
        
        showCorrectButton.setOnAction(e-> {
            for (Question q: exSet.getIncorrect()) {
                correctAnswers.getChildren().add(createCorrectAnswerNode(q));
            }
            showButtonBox.getChildren().clear();
        });
      
        showButtonBox.getChildren().addAll(showCorrectButton);
        hbox.getChildren().addAll(new Label("You got " + points + "/" + exSet.getQuestions().size() + " points"), toMenu);
        resultPane.getChildren().addAll(new Label(exSet.getName()), hbox, correctAnswers);
        if (points!=exSet.getQuestions().size()) {
            resultPane.getChildren().addAll(showButtonBox);
        } else {
            Label allCorrectLabel = new Label("Well done!");
            allCorrectLabel.setTextFill(Color.GREEN);
            resultPane.getChildren().addAll(allCorrectLabel);
        }
    }
    
    public Node createExerciseNode(ExerciseSet ex, Stage window) {
        HBox box = new HBox(10);
        Label label  = new Label(ex.getName());
        label.setMinHeight(28);
        Button button = new Button("Solve");
        button.setOnAction(e-> {
            window.setScene(solveExerciseScene);
            solveExercise(ex, window);          
        });
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.setPadding(new Insets(0, 5, 0, 5));

        box.getChildren().addAll(label, spacer, button);
        return box;
    }
    
    public void updateExercises(Stage window) {
        exerciseSets.getChildren().clear();    
           
        List<ExerciseSet> currentSets = exService.exercisesList();
        currentSets.forEach(set-> {
            exerciseSets.getChildren().add(createExerciseNode(set, window));
        });     
    }
    
    @Override
    public void start(Stage window) throws Exception {
        VBox loginPane = new VBox(10);
        HBox inputPaneUpper = new HBox(10);
        HBox inputPaneLower = new HBox(10);
        loginPane.setPadding(new Insets(10));
        
        TextField usernameInput = new TextField();     
        usernameInput.setPrefWidth(150);
        
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPrefWidth(150);
        
        inputPaneUpper.getChildren().addAll(new Label("username:"), usernameInput);
        inputPaneLower.getChildren().addAll(new Label("password:"), passwordInput);
        Label loginNotification = new Label();
        Label registerNotification = new Label();
        
        Button toRegistrationButton = new Button("create a new user");
        toRegistrationButton.setPadding(new Insets(10));       
        Button loginButton = new Button("login");
        loginButton.setPadding(new Insets(10));
        
        loginPane.getChildren().addAll(new Label("ExerciseApp"), loginNotification, inputPaneUpper, inputPaneLower, loginButton, toRegistrationButton);       
        
        loginScene = new Scene(loginPane, 420, 300);  
         
        window.setScene(loginScene);
        window.show();
        
        Button registerButton = new Button("create");
        Button returnToLogin = new Button("cancel");
        returnToLogin.setPadding(new Insets(10));
        
        ScrollPane scrollPane = new ScrollPane();      
        BorderPane mainPane = new BorderPane(scrollPane);       
        HBox menuPane = new HBox(10);       
        
        Region menuSpacer = new Region();
        Region createQuestionSpacer = new Region();
        
        HBox.setHgrow(createQuestionSpacer, Priority.ALWAYS);
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("logout");
   
        Button createExerciseButton = new Button("create new");
       
        menuPane.getChildren().addAll(new Label("ExerciseApp"), menuSpacer, logoutButton);
            
        registerButton.setPadding(new Insets(10)); 
        TextField usernameRegInput = new TextField();           
        usernameRegInput.setPrefWidth(150);
            
        PasswordField passwordRegInput = new PasswordField();
        passwordRegInput.setPrefWidth(150);
        
        exerciseSets = new VBox(10);
        exerciseSets.setMaxWidth(300);
        exerciseSets.setMinWidth(300);
        updateExercises(window);
        
        scrollPane.setContent(exerciseSets);
        
        mainPane.setBottom(createExerciseButton);
        mainPane.setTop(menuPane);         
                       
        exercisesScene = new Scene(mainPane, 420, 300);
        
        VBox newExercisePane = new VBox(10);
        HBox questionPane = new HBox(10);
        HBox answerPane = new HBox(10);
        HBox namePane = new HBox(10);
        HBox hintPane = new HBox(10);
        HBox addPane = new HBox(10);
        
        TextField exQuestion = new TextField();
        TextField exHint = new TextField();
        TextField exAnswer = new TextField();
        TextField setName = new TextField();
        Label creationNotification = new Label();
        
        Button addExercise = new Button("add");
        Button createSet = new Button("create");
        Button returnToMainMenu = new Button("Cancel");
        
        questionPane.getChildren().addAll(new Label("Question:"), exQuestion, createQuestionSpacer, returnToMainMenu);
        answerPane.getChildren().addAll(new Label("Answer:"), exAnswer);
        namePane.getChildren().addAll(new Label("Set name:"), setName, createSet);
        hintPane.getChildren().addAll(new Label("Hint:"), exHint, new Label(" (Optional)"));
        addPane.getChildren().addAll(addExercise);
        
        newExercisePane.getChildren().addAll(creationNotification, questionPane, hintPane, answerPane, addPane, namePane);       
        createExerciseScene = new Scene(newExercisePane, 420, 300);
        
        VBox registerPane = new VBox(10);
        HBox inputPaneUpper2 = new HBox(10);   
        HBox inputPaneLower2 = new HBox(10);
        HBox buttonPane = new HBox(10);
        registerPane.setPadding(new Insets(10));
                       
        inputPaneUpper2.getChildren().addAll(new Label("username:"), usernameRegInput, new Label("(at least 3 characters)"));
        inputPaneLower2.getChildren().addAll(new Label("password:"), passwordRegInput, new Label("(at least 5 characters)"));
        buttonPane.getChildren().addAll(registerButton, returnToLogin);
        Label registerLabel = new Label("Registration");
                        
        registerPane.getChildren().addAll(registerNotification, registerLabel, inputPaneUpper2, inputPaneLower2, buttonPane);                   
        registerScene = new Scene(registerPane, 420, 300);
        
        ScrollPane scrollPaneQuestions = new ScrollPane();   
        BorderPane questionsPane = new BorderPane(scrollPaneQuestions);       
        scrollPaneQuestions.setContent(answerSheet);
                     
        solveExerciseScene = new Scene(questionsPane, 420, 300);        
        resultScene = new Scene(resultPane, 420, 300);
               
        loginButton.setOnAction(e-> {
            String username =usernameInput.getText();
            String password = passwordInput.getText();
            if (exService.login(username, password)) {
                updateExercises(window);
                window.setScene(exercisesScene);
                usernameInput.setText("");
                passwordInput.setText("");
                loginNotification.setText("");
                
            } else {
                loginNotification.setText("invalid credentials");
                loginNotification.setTextFill(Color.RED);
            }
        });
        
        logoutButton.setOnAction(e-> {
            exService.logout();
            window.setScene(loginScene);
        });
        
        toRegistrationButton.setOnAction(e-> {          
            window.setScene(registerScene);  
            usernameInput.setText("");
            passwordInput.setText("");
        });  
        
        registerButton.setOnAction(e-> {
            String username = usernameRegInput.getText();
            String password = passwordRegInput.getText();
            User newUser = new User(username, password);
            
            if (!newUser.isValid()) {
                registerNotification.setText("invalid username or password");
                registerNotification.setTextFill(Color.RED);
            } else if (exService.createUser(newUser)) {
                usernameRegInput.setText("");
                passwordRegInput.setText("");
                window.setScene(loginScene);
                loginNotification.setText("user created successfully");
                loginNotification.setTextFill(Color.GREEN);
                usernameRegInput.setText("");
                passwordRegInput.setText("");
            } else {
                registerNotification.setText("username is not available");     
                registerNotification.setTextFill(Color.RED);
            }           
        }); 
        
        returnToLogin.setOnAction(e-> {
            usernameRegInput.setText("");
            passwordRegInput.setText("");
            window.setScene(loginScene); 
        });
        
        createExerciseButton.setOnAction(e-> {            
            window.setScene(createExerciseScene);
        });
        
        addExercise.setOnAction(e-> {
            Question q = new Question(exQuestion.getText(), exAnswer.getText());
            if (!exHint.getText().equals("")) {
                q.setHint(exHint.getText());
            }
            
            if (!q.questionValidation()) {
                creationNotification.setText("Malformed input");
                creationNotification.setTextFill(Color.RED);
            } else {
                toBeAdded.add(q);
                creationNotification.setText("Question added");
                creationNotification.setTextFill(Color.GREEN);
            }
            if (toBeAdded.size()==8) {
                questionPane.getChildren().clear();
                answerPane.getChildren().clear();
                hintPane.getChildren().clear();
                addPane.getChildren().clear();
            }
            exQuestion.setText("");
            exAnswer.setText("");
            exHint.setText("");
            
        });
        
        returnToMainMenu.setOnAction(e-> {
            if (toBeAdded.size()==8) {
                window.setScene(exercisesScene);
                questionPane.getChildren().addAll(new Label("Question:"), exQuestion, createQuestionSpacer, returnToMainMenu);
                answerPane.getChildren().addAll(new Label("Answer:"), exAnswer);
                hintPane.getChildren().addAll(new Label("Hint:"), exHint, new Label(" (Optional)"));
                addPane.getChildren().addAll(addExercise);
                creationNotification.setText("");
                toBeAdded.clear();
            } else {
                toBeAdded.clear();
                creationNotification.setText("");
                exQuestion.setText("");
                exHint.setText("");
                exAnswer.setText("");
                setName.setText("");
                window.setScene(exercisesScene);
            }

        });
        
        createSet.setOnAction(e-> {
            ExerciseSet exSet = new ExerciseSet(setName.getText(), exService.getLoggedUser().getUsername(), toBeAdded);
            exSet.setNameToQuestions();
            if (exService.getExerciseSetDao().findOne(setName.getText())==null && exSet.nameValidation()) {          
                if (exService.createExerciseSet(exSet)) {
                    for (Question q: exSet.getQuestions()) {
                        if (exService.createQuestion(q)) {
                            continue;
                        }              
                    }
                    toBeAdded.clear();
                    exQuestion.setText("");
                    exHint.setText("");
                    exAnswer.setText("");
                    setName.setText("");
                    creationNotification.setText("");
                    updateExercises(window);                
                    window.setScene(exercisesScene);
                    questionPane.getChildren().addAll(new Label("Question:"), exQuestion, createQuestionSpacer, returnToMainMenu);
                    answerPane.getChildren().addAll(new Label("Answer:"), exAnswer);
                    hintPane.getChildren().addAll(new Label("Hint:"), exHint, new Label(" (Optional)"));
                    addPane.getChildren().addAll(addExercise);
                } else if (toBeAdded.size()<4) {
                    creationNotification.setText("At least 4 questions are required");
                    creationNotification.setTextFill(Color.RED);
                }
            } else {
                creationNotification.setText("Exercise set name is not available.");
                creationNotification.setTextFill(Color.RED);
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
