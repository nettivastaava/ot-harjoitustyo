/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.ui;

import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

/**
 *
 * @author vaxandst
 */
public class ExerciseGeneratorUi extends Application {
    private Scene loginScene;
    private Scene registerScene;
    private Scene exercisesScene;
    private Scene createExerciseScene;
    private Scene solveExerciseScene;
    
   
    
    @Override
    public void start(Stage window) throws Exception {
        VBox loginPane = new VBox(10);
        HBox inputPane = new HBox(10);
        loginPane.setPadding(new Insets(10));
        
        TextField usernameInput = new TextField();     
        usernameInput.setPrefWidth(150);
        
        inputPane.getChildren().addAll(new Label("username:"), usernameInput);
        Label exerciseLabel = new Label("ExerciseApp");
        Button toRegistrationButton = new Button("create a new user");
        toRegistrationButton.setPadding(new Insets(10));
        
        loginPane.getChildren().addAll(exerciseLabel, inputPane, toRegistrationButton);       
        loginPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        loginScene = new Scene(loginPane, 420, 300);  
         
        window.setScene(loginScene);
        window.show();
        
        Button registerButton = new Button("create");
        registerButton.setPadding(new Insets(10));
        
        toRegistrationButton.setOnAction(e->{
            VBox registerPane = new VBox(10);
            HBox inputPane2 = new HBox(10);            
            registerPane.setPadding(new Insets(10));
            
            TextField usernameRegInput = new TextField();           
            usernameRegInput.setPrefWidth(150);
            
            inputPane2.getChildren().addAll(new Label("username:"), usernameRegInput);
            Label registerLabel = new Label("Registration");
            
            
            registerPane.getChildren().addAll(registerLabel, inputPane2, registerButton);       
            registerPane.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
            
            registerScene = new Scene(registerPane, 420, 300);
            window.setScene(registerScene);
            
        });  
        
        registerButton.setOnAction(e->{
            
        });
        
        
      
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
