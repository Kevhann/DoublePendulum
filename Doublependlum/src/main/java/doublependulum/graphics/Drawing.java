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
import javafx.scene.layout.GridPane;
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
        final int xoffset = 400;
        final int yoffset = 300;

        stage.setTitle("DoublePendulum");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        javafx.scene.canvas.Canvas drawingTable = new javafx.scene.canvas.Canvas(leveys, korkeus);
        root.getChildren().add(drawingTable);
        

        GraphicsContext drawer = drawingTable.getGraphicsContext2D();
        drawer.setFill(javafx.scene.paint.Color.WHITE);
        drawer.clearRect(0, 0, leveys, korkeus);
        drawer.translate(xoffset, yoffset);
        
        
        new AnimationTimer() {
            private long sleepNanoseconds = 1000 * 1000000;
            private long prevTime = 0;
            Ball upperBall = new Ball(20,30,40);  
            
            Ball lowerBall = new Ball(upperBall,20,-123,-123);  
            double g = 0.7;
            Logic logic = new Logic(upperBall,lowerBall,g);
            
            

            public void handle(long currentNanoTime) {
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }
                
                drawer.setFill(javafx.scene.paint.Color.WHITE);
                drawer.clearRect(-xoffset, -yoffset, leveys, korkeus);
                drawer.setFill(javafx.scene.paint.Color.BLACK);
                
                
                
                drawer.fillOval(0, 0, 5, 5);
                drawer.fillOval(upperBall.getXlocation() , upperBall.getYlocation(), upperBall.getMass(), upperBall.getMass());
                drawer.setFill(javafx.scene.paint.Color.FIREBRICK);
                drawer.fillOval(lowerBall.getXlocation(),lowerBall.getYlocation() , lowerBall.getMass(), lowerBall.getMass());
                
                
                logic.calculateAcceleration();
                
                
                prevTime = currentNanoTime;
            }
        }.start();
        stage.show();
    }
    public void compile(String[] args){
        
        
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