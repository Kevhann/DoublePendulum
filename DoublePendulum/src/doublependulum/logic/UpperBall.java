/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.logic;

/**
 *
 * @author kevhann
 */
public class UpperBall {
    private Ball upperBall;
    private double gravity;
    private Line upperLine;
    private double lineLength;
    private double upperAngle;
    private int xlocation;
    private int ylocation;
    private double xAcceleration;
    private double yAcceleration;
    private double yVelocity;
    private double xVelocity;
    private double mass;

    public UpperBall(Ball upperBall, double gravity, Line upperLine, double upperAngle, int xlocation, int ylocation, double xAcceleration, double yAcceleration, double yVelocity, double xVelocity, double mass, int radius) {
        this.upperBall = upperBall;
        this.gravity = gravity;
        this.upperLine = upperLine;
        this.upperAngle = upperAngle;
        this.xlocation = xlocation;
        this.ylocation = ylocation;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.yVelocity = yVelocity;
        this.xVelocity = xVelocity;
        this.mass = mass;
    }
    

    
    
}
