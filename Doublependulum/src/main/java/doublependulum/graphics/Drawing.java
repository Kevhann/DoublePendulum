/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.graphics;

import doublependulum.logic.Ball;
import doublependulum.logic.Logic;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
/**
 *
 * @author kevhann
 */
public class Drawing {
    private Logic logic;

    public void start() {
        Stage pendulums = new Stage();
        final int leveys = 1000;
        final int korkeus = 1000;
        final int xoffset = leveys / 2;
        final int yoffset = 100;
        Line upperLine = new Line();
        Line lowerLine = new Line();
        upperLine.setStartX(xoffset + 2);
        upperLine.setStartY(yoffset + 2);
        
        pendulums.setTitle("DoublePendulum");

        Group root = new Group();
        Scene doublependulum = new Scene(root);
        pendulums.setScene(doublependulum);

        Canvas drawingTable = new Canvas(leveys, korkeus);
        root.getChildren().addAll(drawingTable, upperLine, lowerLine);

        GraphicsContext drawer = drawingTable.getGraphicsContext2D();
        drawer.setFill(javafx.scene.paint.Color.WHITE);
        drawer.clearRect(0, 0, leveys, korkeus);
        drawer.translate(xoffset, yoffset);
        
        
        new AnimationTimer() {
            private final long sleepNanoseconds = 8 * 1000000;
            private long prevTime = 0;
            public void handle(long currentNanoTime) {
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }
                drawer.setFill(javafx.scene.paint.Color.WHITE);
                drawer.clearRect(-xoffset, -yoffset, leveys, korkeus);
                drawer.setFill(javafx.scene.paint.Color.BLACK);
                
                drawer.fillOval(0, 0, 5, 5);
                drawer.setFill(javafx.scene.paint.Color.FIREBRICK);
                drawer.fillOval(logic.getUpperBall().getXlocation(), logic.getUpperBall().getYlocation(), logic.getUpperBall().getMass(), logic.getUpperBall().getMass());
                upperLine.setEndX(logic.getUpperBall().getXlocation() + xoffset + logic.getUpperBall().getMass() / 2);
                upperLine.setEndY(logic.getUpperBall().getYlocation() + yoffset + logic.getUpperBall().getMass() / 2);
                
                lowerLine.setStartX(logic.getUpperBall().getXlocation() + xoffset + logic.getUpperBall().getMass() / 2);
                lowerLine.setStartY(logic.getUpperBall().getYlocation() + yoffset + logic.getUpperBall().getMass() / 2);
                lowerLine.setEndX(logic.getLowerBall().getXlocation() + xoffset + logic.getLowerBall().getMass() / 2);
                lowerLine.setEndY(logic.getLowerBall().getYlocation() + yoffset + logic.getLowerBall().getMass() / 2);
                
                drawer.fillOval(logic.getLowerBall().getXlocation(), logic.getLowerBall().getYlocation() , logic.getLowerBall().getMass(), logic.getLowerBall().getMass());
                
                logic.calculateAcceleration(); 
                prevTime = currentNanoTime;
            }
        }.start();
        pendulums.show();
    }
    public void initializeLogic(Ball upper, Ball lower, double gravity) {
        this.logic = new Logic(upper, lower, gravity);
    }
}