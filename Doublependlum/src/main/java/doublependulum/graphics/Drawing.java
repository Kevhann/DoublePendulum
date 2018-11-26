/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.graphics;

import doublependulum.Doublependulum;
import doublependulum.UI.UI;
import doublependulum.logic.Ball;
import doublependulum.logic.Logic;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
/**
 *
 * @author kevhann
 */
public class Drawing extends Application {
    Logic logic;

public void start(Stage stage) throws Exception{
        UI ui = new UI();
        final int leveys = 800;
        final int korkeus = 800;
        final int xoffset = 400;
        final int yoffset = 300;

        stage.setTitle("DoublePendulum");

        Group root = new Group();
        Scene doublependulum = new Scene(root);
        stage.setScene(doublependulum);

        javafx.scene.canvas.Canvas drawingTable = new javafx.scene.canvas.Canvas(leveys, korkeus);
        root.getChildren().add(drawingTable);
        

        GraphicsContext drawer = drawingTable.getGraphicsContext2D();
        drawer.setFill(javafx.scene.paint.Color.WHITE);
        drawer.clearRect(0, 0, leveys, korkeus);
        drawer.translate(xoffset, yoffset);

        
        ui.start(stage);
        
        new AnimationTimer() {
            private final long sleepNanoseconds = 10 * 1000000;
            private long prevTime = 0;
            public void handle(long currentNanoTime) {
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }
                drawer.setFill(javafx.scene.paint.Color.WHITE);
                drawer.clearRect(-xoffset, -yoffset, leveys, korkeus);
                drawer.setFill(javafx.scene.paint.Color.BLACK);
                
                
                
                drawer.fillOval(0, 0, 5, 5);
                drawer.fillOval(logic.getUpperBall().getXlocation() , logic.getUpperBall().getYlocation(), logic.getUpperBall().getMass(), logic.getUpperBall().getMass());
                drawer.setFill(javafx.scene.paint.Color.FIREBRICK);
                drawer.fillOval(logic.getLowerBall().getXlocation(),logic.getLowerBall().getYlocation() , logic.getLowerBall().getMass(), logic.getLowerBall().getMass());
                
                
                logic.calculateAcceleration();
                
                
                prevTime = currentNanoTime;
            }
        }.start();
        stage.show();
    }
    public void compile(String[] args){
        launch(args);
    }
    public void initializeLogic(int upperMass,int upperX,int upperY,int lowerMass,int lowerX,int lowerY,double gravity){
        Ball upper = new Ball(upperMass,upperX,upperY);
        Ball lower = new Ball(upper,lowerMass,lowerX,lowerY);
        logic = new Logic(upper,lower,gravity);
    }
}