/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.UI;

import doublependulum.logic.Logic;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kevhann
 */
public class UI extends Application{

    private Button buton;
    
    public UI(){
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Doublependulum");
        Button buton = new Button();
        buton.setText("butonerino");
        
        StackPane layout = new StackPane();
        layout.getChildren().add(buton);
        
        Scene scene = new Scene(layout,300,300);
        stage.setScene(scene);
        
        stage.show();
    }
    public void compile(String[] args){
        launch(args);
    }
}
