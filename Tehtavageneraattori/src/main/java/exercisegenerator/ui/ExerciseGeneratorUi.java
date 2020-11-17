package exercisegenerator.ui;

import exercisegenerator.dao.FileUserDao;
import exercisegenerator.domain.ExerciseService;
import exercisegenerator.domain.User;
import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ExerciseGeneratorUi extends Application {
    private Scene loginScene;
    private Scene registerScene;
    private Scene exercisesScene;
    private Scene createExerciseScene;
    private Scene solveExerciseScene;
    
    private ExerciseService exService;
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();  
        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");
        FileUserDao userDao = new FileUserDao(userFile);     
        exService = new ExerciseService(null, userDao);
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
        registerButton.setPadding(new Insets(10));
        
        TextField usernameRegInput = new TextField();           
        usernameRegInput.setPrefWidth(150);
            
        PasswordField passwordRegInput = new PasswordField();
        passwordRegInput.setPrefWidth(150);
        
        VBox exercisesPane = new VBox();
        HBox logoutPane = new HBox();
        Button logoutButton = new Button("logout");
        
        logoutPane.getChildren().addAll(exerciseLabel, logoutButton);
        exercisesPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        
        exercisesPane.getChildren().addAll(logoutPane);
        
        exercisesScene = new Scene(exercisesPane, 420, 300);
        
        loginButton.setOnAction(e-> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            if (exService.login(username, password)) {
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
                window.setScene(loginScene);
            } else {
                System.out.println("username is not available");       
            }
        }); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
