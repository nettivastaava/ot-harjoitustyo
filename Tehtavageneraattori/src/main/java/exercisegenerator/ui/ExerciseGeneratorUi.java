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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ExerciseGeneratorUi extends Application {
    private Scene loginScene;
    private Scene registerScene;
    private Scene exercisesScene;
    private Scene createExerciseScene;
    private Scene solveExerciseScene;
    
    private ExerciseService exService;
    private ArrayList<Question> toBeAdded;
    private VBox exerciseSets;
    private VBox answerSheet;
    private HBox answerBox;
    private HBox questionBox;
    
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
        questionBox = new HBox(10);
        answerBox = new HBox(10);
        exService = new ExerciseService(exerciseDao, userDao, questionDao);
        toBeAdded = new ArrayList<>();
    }
    
    public Node createQuestionNode(Question q) {
        VBox box = new VBox(10);
        HBox hintBox = new HBox(10);
        HBox answerBox = new HBox(10);
        Label question = new Label(q.getQuestion());
        Button hintButton = new Button("Hint");
        hintButton.setOnAction(e-> {
           hintBox.getChildren().addAll(new Label(q.getHint()));
        });
        Label answerLabel = new Label("Answer");
        TextField answerInput = new TextField();
        Button answerButton = new Button("Submit");    
        answerButton.setOnAction(e-> {
            
        });
        if (q.getHint()!=null) {
            hintBox.getChildren().addAll(hintButton);
        }
        
        answerBox.getChildren().addAll(answerLabel, answerInput, answerButton);
        box.getChildren().addAll(question, hintBox, answerBox);
        return box;
    }
    
    public void solveExercise(ExerciseSet ex, Stage window) {       
        answerSheet.getChildren().clear();
        System.out.println(ex.getQuestions().size());
        System.out.println(ex.getName());
        for (Question q: ex.getQuestions()) {
            answerSheet.getChildren().add(createQuestionNode(q));
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
        System.out.println(label);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.setPadding(new Insets(0, 5, 0, 5));

        box.getChildren().addAll(label, spacer, button);
        return box;
    }
    
    public void updateExercises(Stage window) {
        exerciseSets.getChildren().clear();    
        exerciseSets.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));       

        List<ExerciseSet> currentSets = exService.exercisesList();
        System.out.println("sets: "+ currentSets.size());
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
        Label exerciseLabel = new Label("ExerciseApp");
        
        Button toRegistrationButton = new Button("create a new user");
        toRegistrationButton.setPadding(new Insets(10));
        
        Button loginButton = new Button("login");
        loginButton.setPadding(new Insets(10));
        
        loginPane.getChildren().addAll(exerciseLabel, inputPaneUpper, inputPaneLower, loginButton, toRegistrationButton);       
        loginPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        loginScene = new Scene(loginPane, 420, 300);  
         
        window.setScene(loginScene);
        window.show();
        
        Button registerButton = new Button("create");
        
        ScrollPane scrollPane = new ScrollPane();
        
        BorderPane mainPane = new BorderPane(scrollPane);
        
        HBox menuPane = new HBox(10);       
        
        Region menuSpacer = new Region();
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("logout");
   
        Button createExerciseButton = new Button("create new");
       
        menuPane.getChildren().addAll(exerciseLabel, menuSpacer, logoutButton);
            
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
        scrollPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setBottom(createExerciseButton);
        mainPane.setTop(menuPane);
                
        mainPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
                
        exercisesScene = new Scene(mainPane, 420, 300, Color.KHAKI);
        
        VBox newExercisePane = new VBox(10);
        HBox questionPane = new HBox(10);
        HBox answerPane = new HBox(10);
        HBox namePane = new HBox(10);
        HBox hintPane = new HBox(10);
        
        TextField exQuestion = new TextField();
        TextField exHint = new TextField();
        TextField exAnswer = new TextField();
        TextField setName = new TextField();
        
        Button addExercise = new Button("add");
        Button createSet = new Button("create");
        
        questionPane.getChildren().addAll(new Label("Question:"), exQuestion);
        answerPane.getChildren().addAll(new Label("Answer:"), exAnswer);
        namePane.getChildren().addAll(new Label("Set name:"), setName, createSet);
        hintPane.getChildren().addAll(new Label("Hint:"), exHint, new Label(" (Optional)"));
        
        newExercisePane.getChildren().addAll(questionPane, hintPane, answerPane, addExercise, namePane);
        newExercisePane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        
        createExerciseScene = new Scene(newExercisePane, 420, 300);
        
        VBox registerPane = new VBox(10);
        HBox inputPaneUpper2 = new HBox(10);   
        HBox inputPaneLower2 = new HBox(10);
        registerPane.setPadding(new Insets(10));
                       
        inputPaneUpper2.getChildren().addAll(new Label("username:"), usernameRegInput);
        inputPaneLower2.getChildren().addAll(new Label("password:"), passwordRegInput);
        Label registerLabel = new Label("Registration");
                        
        registerPane.getChildren().addAll(registerLabel, inputPaneUpper2, inputPaneLower2, registerButton);       
        registerPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
            
        registerScene = new Scene(registerPane, 420, 300);
        
        ScrollPane scrollPaneQuestions = new ScrollPane();   
        BorderPane questionsPane = new BorderPane(scrollPaneQuestions);
        
        scrollPaneQuestions.setContent(answerSheet);
        answerSheet.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPaneQuestions.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
               
        solveExerciseScene = new Scene(questionsPane, 420, 300);
        
        loginButton.setOnAction(e-> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            if (exService.login(username, password)) {
                updateExercises(window);
                window.setScene(exercisesScene);
            } else {
                System.out.println("wrong credentials");
            }
        });
        
        logoutButton.setOnAction(e-> {
            exService.logout();
            window.setScene(loginScene);
        });
        
        toRegistrationButton.setOnAction(e-> {          
            window.setScene(registerScene);         
        });  
        
        registerButton.setOnAction(e-> {
            String username = usernameRegInput.getText();
            String password = passwordRegInput.getText();
            User newUser = new User(username, password);
            
            if (newUser.getUsername() == null) {
                System.out.println("username or password is too short");
            } else if (exService.createUser(newUser)) {
                System.out.println("success");
                usernameRegInput.setText("");
                passwordRegInput.setText("");
                window.setScene(loginScene);
            } else {
                System.out.println("username is not available");       
            }           
        }); 
        
        createExerciseButton.setOnAction(e-> {            
            window.setScene(createExerciseScene);
        });
        
        addExercise.setOnAction(e-> {
            Question q = new Question(exQuestion.getText(), exAnswer.getText());
            if (!exHint.getText().equals("")) {
                q.setHint(exHint.getText());
            }
            toBeAdded.add(q);
            exQuestion.setText("");
            exAnswer.setText("");
            exHint.setText("");
            
        });
        
        createSet.setOnAction(e-> {
            ExerciseSet exSet = new ExerciseSet(setName.getText(), toBeAdded);
            exSet.setNameToQuestions();
            
            for (Question q: exSet.getQuestions()) {
                if (exService.createQuestion(q)) {
                    continue;
                }              
            }
            if (exService.createExerciseSet(exSet)) {
                toBeAdded.clear();
                setName.setText("");
                updateExercises(window);
                
                window.setScene(exercisesScene);
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
