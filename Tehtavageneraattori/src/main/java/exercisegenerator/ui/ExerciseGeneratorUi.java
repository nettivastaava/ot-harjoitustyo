/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author vaxandst
 */
public class ExerciseGeneratorUi extends Application {
    private Scene login;
    private Scene register;
    private Scene exerciseList;
    private Scene createExercise;
    private Scene solveExercise;
    
    @Override
    public void start(Stage window) throws Exception {
      
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
