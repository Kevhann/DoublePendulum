package doublependulum.ui;

import doublependulum.graphics.Drawing;
import doublependulum.logic.Ball;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author kevhann
 */
public class UI extends Application {
    public UI() {
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Doublependulum");
        Label upperBall = new Label("Upper ball parameters");
        Label lowerBall = new Label("Lower ball parameters");
        Label xLabel = new Label("Enter X value -299 - 299");
        Label yLabel = new Label("Enter Y value -299 - 299");
        Label massLabel = new Label("Enter ball mass 1 - 99");
        Label gLabel = new Label("Enter gravity 0.0 - 9.99");
        Label badValues = new Label();
        TextField upperBallXLocationValue = new TextField("80");
        TextField upperBallYLocationValue = new TextField("150");
        TextField upperBallMassValue = new TextField("25");
        TextField lowerBallXLocationValue = new TextField("-123");
        TextField lowerBallYLocationValue = new TextField("-123");
        TextField lowerBallMassValue = new TextField("30");
        TextField gravityTextField = new TextField("4");
        upperBallXLocationValue.setPromptText("-299 - 299");
        upperBallXLocationValue.setPromptText("-299 - 299");
        upperBallYLocationValue.setPromptText("-299 - 299");
        lowerBallXLocationValue.setPromptText("-299 - 299");
        lowerBallYLocationValue.setPromptText("-299 - 299");
        upperBallMassValue.setPromptText("1 - 99");
        lowerBallMassValue.setPromptText("1 - 99");
        gravityTextField.setPromptText("0.01 - 9.99");
        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (upperBallXLocationValue.getCharacters().toString().matches("-?[1,2]?[0-9]{1,2}") 
                    && upperBallYLocationValue.getCharacters().toString().matches("-?[1,2]?[0-9]{1,2}") 
                    && upperBallMassValue.getCharacters().toString().matches("[1-9][0-9]?") 
                    && lowerBallXLocationValue.getCharacters().toString().matches("-?[1,2]?[0-9]{1,2}") 
                    && lowerBallYLocationValue.getCharacters().toString().matches("-?[1,2]?[0-9]{1,2}") 
                    && lowerBallMassValue.getCharacters().toString().matches("[1-9][0-9]?") 
                    && gravityTextField.getCharacters().toString().matches("[0-9]?.?[0-9]?[1-9]")) {
                    
                    Drawing dr = new Drawing();
                    Ball upperBall = new Ball(Integer.parseInt(upperBallMassValue.getCharacters().toString()), Integer.parseInt(upperBallXLocationValue.getCharacters().toString()), Integer.parseInt(upperBallYLocationValue.getCharacters().toString()));
                    Ball lowerBall = new Ball(upperBall, Integer.parseInt(lowerBallMassValue.getCharacters().toString()), Integer.parseInt(lowerBallXLocationValue.getCharacters().toString()), Integer.parseInt(lowerBallYLocationValue.getCharacters().toString()));
                    dr.initializeLogic(upperBall, lowerBall, (Double.parseDouble(gravityTextField.getCharacters().toString()) / 10));
                    dr.start();
                    stage.close();
                } else {
                    badValues.setText("Enter valid values");;
                    upperBallXLocationValue.setText("");
                    upperBallYLocationValue.setText("");
                    upperBallMassValue.setText("");
                    lowerBallXLocationValue.setText("");
                    lowerBallYLocationValue.setText("");
                    lowerBallMassValue.setText("");
                    gravityTextField.setText("");
                }
            }
        });
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setVgap(5);
        layout.setHgap(10);
        layout.add(upperBall, 0, 1);
        layout.add(lowerBall, 0, 2);
        layout.add(xLabel, 1, 0);
        layout.add(yLabel, 2, 0);
        layout.add(gLabel, 0, 3);
        layout.add(massLabel, 3, 0);
        layout.add(upperBallXLocationValue, 1, 1);
        layout.add(upperBallYLocationValue, 2, 1);
        layout.add(upperBallMassValue, 3, 1);
        layout.add(lowerBallXLocationValue, 1, 2);
        layout.add(lowerBallYLocationValue, 2, 2);
        layout.add(lowerBallMassValue, 3, 2);
        layout.add(gravityTextField, 1, 3);
        layout.add(startButton, 1, 4);
        layout.add(badValues, 1, 5, 2, 1);
            
        Scene scene = new Scene(layout, 740, 220);
        stage.setScene(scene);
        stage.show();
    } 
    public void compile(String[] args) {
        launch(UI.class);
    }
}
