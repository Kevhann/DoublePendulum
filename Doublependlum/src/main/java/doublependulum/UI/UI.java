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
import javafx.stage.Stage;

/**
 *
 * @author kevhann
 */
public class UI extends Application{
    
    private Slider ryhmia;
    private Slider prosAlueestaKaytossa;
    private Slider tyytyvaisyysRaja;

    private Button kaynnistaNappi;
    
    public UI(){

        this.ryhmia = new Slider(2, 5, 2);
        this.ryhmia.setShowTickLabels(true);
        this.ryhmia.setShowTickMarks(true);
        this.ryhmia.setMajorTickUnit(1.0);
        this.ryhmia.setMinorTickCount(0);
        this.ryhmia.setSnapToTicks(true);

        this.prosAlueestaKaytossa = new Slider(0, 100, 70);
        this.prosAlueestaKaytossa.setShowTickLabels(true);
        this.prosAlueestaKaytossa.setShowTickMarks(true);
        this.prosAlueestaKaytossa.setMajorTickUnit(25.0);
        this.prosAlueestaKaytossa.setMinorTickCount(4);

        this.tyytyvaisyysRaja = new Slider(0, 9, 5);
        this.tyytyvaisyysRaja.setShowTickLabels(true);
        this.tyytyvaisyysRaja.setShowTickMarks(true);
        this.tyytyvaisyysRaja.setMajorTickUnit(1.0);
        this.tyytyvaisyysRaja.setMinorTickCount(0);
        this.tyytyvaisyysRaja.setSnapToTicks(true);

        this.kaynnistaNappi = new Button("Alusta ja käynnistä");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        GridPane grid = new GridPane();
        
        
        grid.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(70);
        
        Label ryhmiaTeksti = new Label("Ryhmien lukumäärä: ");
        GridPane.setConstraints(ryhmiaTeksti, 0, 1);
        grid.getChildren().add(ryhmiaTeksti);
        GridPane.setConstraints(ryhmia, 1, 1);
        grid.getChildren().add(ryhmia);

        Label tyhjyysProsTeksti = new Label("Alueesta käytössä (%): ");
        GridPane.setConstraints(tyhjyysProsTeksti, 0, 2);
        grid.getChildren().add(tyhjyysProsTeksti);
        GridPane.setConstraints(prosAlueestaKaytossa, 1, 2);
        grid.getChildren().add(prosAlueestaKaytossa);

        Label tyytyvaisyysraja = new Label("Tyytyväisyysraja: ");
        GridPane.setConstraints(tyytyvaisyysraja, 0, 3);
        grid.getChildren().add(tyytyvaisyysraja);
        GridPane.setConstraints(tyytyvaisyysRaja, 1, 3);
        grid.getChildren().add(tyytyvaisyysRaja);

        GridPane.setConstraints(kaynnistaNappi, 0, 4);
        GridPane.setColumnSpan(kaynnistaNappi, 2);
        grid.getChildren().add(kaynnistaNappi);

        root.getChildren().add(grid);
        
    }
    public void compile(String[] args){
        
        
        launch(args);
    }
}
