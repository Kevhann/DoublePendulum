/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.graphics;

import doublependulum.logic.Ball;

import doublependulum.logic.Logic;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.*;

/**
 *
 * @author kevhann
 */
public class Drawing extends Application {

public void start(Stage stage){
        
        
        final int leveys = 800;
        final int korkeus = 800;

        stage.setTitle("DoublePendulum");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        javafx.scene.canvas.Canvas drawingTable = new javafx.scene.canvas.Canvas(leveys, korkeus);
        root.getChildren().add(drawingTable);
        

        GraphicsContext drawer = drawingTable.getGraphicsContext2D();
        drawer.setFill(javafx.scene.paint.Color.WHITE);
        drawer.clearRect(0, 0, leveys, korkeus);
        drawer.translate(400, 100);
        
        new AnimationTimer() {
            private long sleepNanoseconds = 6 * 1000000;
            private long prevTime = 0;
            Line upperLine = new Line();
            Ball lowerBall = new Ball(20,150,-100);
            Ball upperBall = new Ball(20,150,-50);
            double g = 0.4;
            Logic logic = new Logic(upperBall,lowerBall,g);
            
            Circle upperCircle = new Circle();
            Line lowerLine = new Line();
            Circle lowerCircle = new Circle();

            public void handle(long currentNanoTime) {
                // päivitetään animaatiota noin 200 millisekunnin välein
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }
                
                drawer.setFill(javafx.scene.paint.Color.WHITE);
                drawer.clearRect(-400, -100, leveys, korkeus);
                drawer.setFill(javafx.scene.paint.Color.BLACK);
                
                
                
                drawer.fillOval(0, 0, 5, 5);
                drawer.moveTo(100, 100);
                drawer.lineTo(150, 150);
                drawer.fillOval(upperBall.getXlocation() , upperBall.getYlocation(), 20, 20);
                drawer.lineTo(0, 0);
                drawer.setFill(javafx.scene.paint.Color.BLUE);
                
                drawer.fillOval(lowerBall.getXlocation(),lowerBall.getYlocation() , 20, 20);
                logic.calculateAcceleration();
                
                
                prevTime = currentNanoTime;
            }
        }.start();
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
//
//    private Point lastPoint;
//
//    /**
//     * Constructs a panel, registering listeners for the mouse.
//     */
//    public Drawing() {
//        // When the mouse button goes down, set the current point
//        // to the location at which the mouse was pressed.
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                lastPoint = new Point(e.getX(), e.getY());
//            }
//        });
//
//        // When the mouse is dragged, draw a line from the old point
//        // to the new point and update the value of lastPoint to hold
//        // the new current point.
//        addMouseMotionListener(new MouseMotionAdapter() {
//            public void mouseDragged(MouseEvent e) {
//                Graphics g = getGraphics();
//                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
//                lastPoint = new Point(e.getX(), e.getY());
//                g.dispose();
//            }
//        });
//    }
//    
//    