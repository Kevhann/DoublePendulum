package doublependulum.UI;

import doublependulum.Doublependulum;
import doublependulum.graphics.Drawing;
import doublependulum.logic.Logic;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kevhann
 */
public class UI extends Application{
    public UI(){
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Doublependulum");
        Label upperBall = new Label("Upper ball parameters");
        Label lowerBall = new Label("Lower ball parameters");
        Label xLabel = new Label("Enter X value -199 - 199");
        Label yLabel = new Label("Enter Y value -199 - 199");
        Label massLabel = new Label("Enter ball mass 1 - 99");
        Label gLabel = new Label("Enter gravity 0.0 - 10\n(lower might work better)");
        Label badValues = new Label();
        TextField upperBallXLocationValue = new TextField();
        TextField upperBallYLocationValue = new TextField();
        TextField upperBallMassValue = new TextField();
        TextField lowerBallXLocationValue = new TextField();
        TextField lowerBallYLocationValue = new TextField();
        TextField lowerBallMassValue = new TextField();
        TextField gravityTextField = new TextField();
        upperBallXLocationValue.setPromptText("-199 - 199");
        upperBallXLocationValue.setPromptText("-199 - 199");
        upperBallYLocationValue.setPromptText("-199 - 199");
        lowerBallXLocationValue.setPromptText("-199 - 199");
        lowerBallYLocationValue.setPromptText("-199 - 199");
        upperBallMassValue.setPromptText("1 - 99");
        lowerBallMassValue.setPromptText("1 - 99");
        gravityTextField.setPromptText("0.01 - 9.99");
        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (upperBallXLocationValue.getCharacters().toString().matches("-?1?[0-9]{1,2}") && 
                    upperBallYLocationValue.getCharacters().toString().matches("-?1?[0-9]{1,2}") && 
                    upperBallMassValue.getCharacters().toString().matches("[0-9]?[1-9]") &&
                    lowerBallYLocationValue.getCharacters().toString().matches("-?1?[0-9]{1,2}") && 
                    lowerBallYLocationValue.getCharacters().toString().matches("-?1?[0-9]{1,2}") &&
                    upperBallMassValue.getCharacters().toString().matches("[0-9]?[1-9]") &&
                    gravityTextField.getCharacters().toString().matches("[0-9]?.?[0-9]?[1-9]"))
                {
                    System.out.println("good values");
                } else{
                    badValues.setText("Enter valid values");
                    System.out.println("bad values");
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
        layout.setPadding(new Insets(20,20,20,20));
        layout.setVgap(5);
        layout.setHgap(10);
        GridPane.setConstraints(upperBall, 0, 1);
        GridPane.setConstraints(lowerBall, 0, 2);
        GridPane.setConstraints(xLabel, 1, 0);
        GridPane.setConstraints(yLabel, 2, 0);
        GridPane.setConstraints(gLabel, 0, 3,1,2);
        GridPane.setConstraints(massLabel, 3, 0);
        
        GridPane.setConstraints(upperBallXLocationValue, 1, 1);
        GridPane.setConstraints(upperBallYLocationValue, 2, 1);
        GridPane.setConstraints(upperBallMassValue, 3, 1);
        GridPane.setConstraints(lowerBallXLocationValue, 1, 2);
        GridPane.setConstraints(lowerBallYLocationValue, 2, 2);
        GridPane.setConstraints(lowerBallMassValue, 3, 2);
        GridPane.setConstraints(gravityTextField, 1, 3);
        GridPane.setConstraints(startButton, 1, 4);
        GridPane.setConstraints(badValues, 1, 5,2,1);
        
        layout.getChildren().addAll(lowerBallMassValue,upperBallMassValue,massLabel,upperBall,lowerBall,xLabel,upperBallXLocationValue,upperBallYLocationValue,yLabel,lowerBallXLocationValue,lowerBallYLocationValue,gLabel,gravityTextField,startButton,badValues);
        
        Scene scene = new Scene(layout,700,220);
        stage.setScene(scene);
        
        stage.show();
        
    } 
    public void compile(String[] args){
        launch(UI.class);
    }
}
